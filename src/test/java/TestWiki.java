import configuretions.BaseClass;
import data.DataProvaders;
import io.qameta.allure.*;
import liseners.MyLisener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.MyRetry;
import util.Namess;
import util.Screen;

import java.util.ResourceBundle;

import static org.testng.Assert.*;

@Listeners(MyLisener.class)
public class TestWiki extends BaseClass {

    @BeforeClass
    public void startTest() {
        driver.get("https://wikipedia.org/");
    }

    //    @Story("nsjsjsjssj")

    @Test(groups = {"smoke", "regresions"})
    public void test1() {
        Screen.takeScreen(driver, "pic");

    }

    @Link(name = "allure", type = "mylink")
    @Link("DqDyvyepXIA")
    @TmsLink("https://www.youtube.com/watch?v=LcY9tUioeVI")
    @Test(priority = 2)
    public void test2() {
        System.out.println("test2");
        Screen.getString();
    }

    @Issue("DqDyvyepXIA")
    @Description("This test print TEST3")
    @Test(description = "test #3 create 230123", groups = {"smoke"}, dependsOnMethods = "test1", alwaysRun = true, priority = 1)
    public void test3() {
        System.out.println("test3");
    }

    @Test(description = "dataprov", groups = {"all"}, dataProviderClass = DataProvaders.class, dataProvider = "dateLang")
    public void test4(String lang) throws InterruptedException {
        ResourceBundle bundle = ResourceBundle.getBundle(lang);
        driver.get("https://" + bundle.getString("lang") + ".wikipedia.org/");
        Thread.sleep(2000);
    }

    @Test(dataProviderClass = DataProvaders.class, dataProvider = "getdata")
    public void test5(String name, String family, int age, int x) {
        System.out.println(name);
        assertEquals(driver.getCurrentUrl(),"sss");
    }

    int i = 0;

    @Issue("#_links")
    @Test(retryAnalyzer = MyRetry.class)
    public void test6() {

        System.out.print(i + " ");
        System.out.println(Namess.name);
        assertEquals(Namess.name, "Vasiliy");
        i++;
    }

    @AfterClass
    public void afterTest() {
        driver.close();
    }
}
