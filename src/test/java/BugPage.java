import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.*;

public class BugPage {
    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'System')]")
    private SelenideElement header;

    @FindBy(how = How.XPATH, using = "//*[@id='browse_link']")
    private SelenideElement allProjects;

    @FindBy(how = How.XPATH, using = "//*[@id='admin_main_proj_link_lnk']")
    private SelenideElement allProjects2;

    @FindBy(how = How.XPATH, using = "//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']")
    private SelenideElement allTasks;

    @Step("Проверка удачной авторизации")
    public BugPage isOpened() {
        header.exists();
        return page(BugPage.class);
    }
    @Step("Переходим в список всех задач")
    public BugPage clickAllProjects() {
            allProjects.click();
            allProjects2.click();
            allTasks.click();
            return page(BugPage.class);
    }
    @Step("Проверка совпадения количества задач")
    public BugPage chekingNumbers(){
        String num = ($x("//div[@class='ghx-issue-count']").getText()).split(" ")[0];
        int num2 = Integer.parseInt(num);
        int num3 = $$(By.xpath("//div[@class='ghx-issue-content']")).size();
        Assertions.assertEquals(num2, num3);
        System.out.println("Колличество задач в списке задач  " + num2);
        System.out.println("Колличество задач построчно  " + num3);
        return page(BugPage.class);
    }

    @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
    private SelenideElement createBug;

    @FindBy(how = How.XPATH, using = "//input[@id='summary']")
    private SelenideElement fieldTheme;

    @FindBy(how = How.XPATH, using = "//input[@id='create-issue-submit']")
    private SelenideElement buttonCreate;

    @FindBy(how = How.XPATH, using = "//*[@id='aui-flag-container']//a")
    private SelenideElement myTestNumber;

    @FindBy(how = How.XPATH, using = "//*[@class='issueaction-viewworkflow jira-workflow-designer-link']")
    private SelenideElement goToTest;

    @FindBy(how = How.XPATH, using = "//*[@id='opsbar-transitions_more']")
    private SelenideElement buttonBussinesProc;

    @FindBy(how = How.XPATH, using = "//*[@id='action_id_31']")
    private SelenideElement buttonComplite;

    @Step("Кликаем создание бага")
    public BugPage clickCreateBug() {
        createBug.click();
        return page(BugPage.class);
    }
    @Step("Заполняем поле 'тема задачи'")
    public BugPage enterThemeBug() {
        fieldTheme.sendKeys("Тест Владимир Гарин");
        return page(BugPage.class);
    }
    @Step("Подтверждаем создание задачи")
    public BugPage clickCreateBugFinal() {
        buttonCreate.click();
        return page(BugPage.class);
    }
    @Step("Переходим в созданную задачу и меняем статус на 'Готово'")
    public BugPage clickMyTest() {
        myTestNumber.click();
        buttonBussinesProc.click();
        buttonComplite.click();
        return page(BugPage.class);
    }
    @Step("Проверяем, поменялся ли статус на 'Готово'")
    public BugPage checkComplite() {
        $x("//*[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium']").shouldHave(Condition.text("Готово"));
        return page(BugPage.class);
    }

}