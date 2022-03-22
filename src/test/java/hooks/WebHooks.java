package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {

    @BeforeAll
    public static void setDriver() {
        Configuration.startMaximized = true;
        Configuration.timeout = 120000;
    }

    @BeforeAll
    public static void allureSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true));

    }
}


