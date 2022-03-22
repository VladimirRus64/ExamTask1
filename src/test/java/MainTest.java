import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.Autorisation;
import pageObject.BugPage;


public class MainTest extends WebHooks {
    @Test
    @DisplayName("Задание по проверке количества задач")
    public void test() {
        Autorisation.goToUrl();
        Autorisation.enterLoginPass();
        BugPage.isOpened();
        BugPage.clickAllProjects();
        BugPage.chekingNumbers();

    }

    @Test
    @DisplayName("Задание по созданию бага")
    public void test2() {
        Autorisation.goToUrl();
        Autorisation.enterLoginPass();
        BugPage.isOpened();
        BugPage.clickCreateBug();
        BugPage.enterThemeBug();
        BugPage.clickCreateBugFinal();
        BugPage.clickMyTest();
        BugPage.checkComplite();
    }
}

