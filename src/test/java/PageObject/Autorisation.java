package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static Settings.Configuration.getFromProperties;
import static com.codeborne.selenide.Selenide.$x;

public class Autorisation {

    static String loginField = "//input[@id = 'login-form-username']";
    static String passwordField = "//input[@id = 'login-form-password']";
    static String buttonEnter = "//input[@id = 'login-form-submit']";

    @Step("Авторизация по адресу {url}")
    public static void goToUrl(String url) {
        Selenide.open("https://edujira.ifellow.ru/login.jsp");
    }

    @Step("Авторизация под логином {login}")
    public static void enterLoginPass(String login) {
        $x(loginField).click();
        $x(loginField).sendKeys(login);
        $x(passwordField).click();
        $x(passwordField).sendKeys(getFromProperties("password"));
        $x(buttonEnter).click();
    }
}

