package pageObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BugPage {

    static String header = "//h1[contains(text(), 'System')]";
    static String allProjects = "//*[@id='browse_link']";
    static String allProjects2 = "//*[@id='admin_main_proj_link_lnk']";
    static String allTasks = "//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']";

    @Step("Проверка удачной авторизации")
    public static void isOpened() {
        $x(header).exists();
    }

    @Step("Переходим в список всех задач")
    public static void clickAllProjects() {
        $x(allProjects).click();
        $x(allProjects2).click();
        $x(allTasks).click();

    }

    @Step("Проверка совпадения количества задач")
    public static void chekingNumbers() {
        String num = ($x("//div[@class='ghx-issue-count']").getText()).split(" ")[0];
        int num2 = Integer.parseInt(num);
        int num3 = $$(By.xpath("//div[@class='ghx-issue-content']")).size();
        Assertions.assertEquals(num2, num3);
    }

    static String createBug = "//a[@id='create_link']";
    static String fieldTheme = "//input[@id='summary']";
    static String buttonCreate = "//input[@id='create-issue-submit']";
    static String myTestNumber = "//*[@id='aui-flag-container']//a";
    static String goToTest = "//*[@class='issueaction-viewworkflow jira-workflow-designer-link']";
    static String buttonBussinesProc = "//*[@id='opsbar-transitions_more']";
    static String buttonComplite = "//*[@id='action_id_31']";

    @Step("Кликаем создание бага")
    public static void clickCreateBug() {
        $x(createBug).click();
    }

    @Step("Заполняем поле 'тема задачи'")
    public static void enterThemeBug() {
        $x(fieldTheme).sendKeys("Тест Владимир Гарин");

    }

    @Step("Подтверждаем создание задачи")
    public static void clickCreateBugFinal() {
        $x(buttonCreate).click();
    }

    @Step("Переходим в созданную задачу и меняем статус на 'Готово'")
    public static void clickMyTest() {
        $x(myTestNumber).click();
        $x(buttonBussinesProc).click();
        $x(buttonComplite).click();

    }

    @Step("Проверяем, поменялся ли статус на 'Готово'")
    public static void checkComplite() {
        $x("//*[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium']").shouldHave(Condition.text("Готово"));

    }

}