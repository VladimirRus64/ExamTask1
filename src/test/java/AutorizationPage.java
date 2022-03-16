import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static Settings.Configuration.getFromProperties;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AutorizationPage {
    @FindBy(how = How.XPATH, using = "//input[@id = 'login-form-username']")
    private static SelenideElement loginField;

    @FindBy(how = How.XPATH, using = "//input[@id = 'login-form-password']")
    private static SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//input[@id = 'login-form-submit']")
    private static SelenideElement buttonEnter;

    @FindBy(how = How.XPATH, using = "//input[@id = 'login-form-cancel']")
    private static SelenideElement buttonCancel;

    @Step("Авторизация на портале jira")
    public static void enterLoginPass(String login) {
        loginField.click();
        loginField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(getFromProperties("password"));
        buttonEnter.click();
    }
}