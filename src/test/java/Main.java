import com.codeborne.selenide.*;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    @Test
    @DisplayName("Задание по проверке количества задач")
    public void test() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AutorizationPage.class)
                .enterLoginPass("garinVladimir");
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", BugPage.class)
                .isOpened()
                .clickAllProjects()
                .chekingNumbers();
    }
    @Test
    @DisplayName("Задание по созданию бага")
    public void test2() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp", AutorizationPage.class)
                .enterLoginPass("garinVladimir");
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", BugPage.class)
                .clickCreateBug()
                .enterThemeBug()
                .clickCreateBugFinal()
                .clickMyTest()
                .checkComplite();
    }
}
