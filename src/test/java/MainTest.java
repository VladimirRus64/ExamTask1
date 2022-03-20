import Hooks.WebHooks;
import PageObject.Autorisation;
import PageObject.BugPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MainTest extends WebHooks {
    @Test
    @DisplayName("Задание по проверке количества задач")
    public void test() {
        Autorisation.goToUrl("https://edujira.ifellow.ru/login.jsp");
        Autorisation.enterLoginPass("garinVladimir");
        BugPage.isOpened();
        BugPage.clickAllProjects();
        BugPage.chekingNumbers();

    }

    @Test
    @DisplayName("Задание по созданию бага")
    public void test2() {
        Autorisation.goToUrl("https://edujira.ifellow.ru/login.jsp");
        Autorisation.enterLoginPass("garinVladimir");
        BugPage.isOpened();
        BugPage.clickCreateBug();
        BugPage.enterThemeBug();
        BugPage.clickCreateBugFinal();
        BugPage.clickMyTest();
        BugPage.checkComplite();
    }
}

