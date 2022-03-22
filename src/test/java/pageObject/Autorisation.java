package pageObject;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static settings.Configuration.getFromProperties;

public class Autorisation {

    static String loginField = "//input[@id = 'login-form-username']";
    static String passwordField = "//input[@id = 'login-form-password']";
    static String buttonEnter = "//input[@id = 'login-form-submit']";

    @Step("Переход на портал Jira")
    public static void goToUrl() {
        Selenide.open(getFromProperties("url"));

    }

    @Step("Авторизация")
    public static void enterLoginPass() {
        $x(loginField).click();
        $x(loginField).sendKeys(getFromProperties("login"));
        $x(passwordField).click();
        $x(passwordField).sendKeys(getFromProperties("password"));
        $x(buttonEnter).click();
    }
}

