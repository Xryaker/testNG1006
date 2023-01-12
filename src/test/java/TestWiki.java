import configuretions.BaseClass;
import data.DataProvaders;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.MyRetry;
import util.Namess;

import java.util.ResourceBundle;
import static org.testng.Assert.*;

public class TestWiki extends BaseClass {

    @BeforeClass
    public void startTest() {
        driver.get("https://wikipedia.org/");
    }

    @Test(description = "this test check title", groups = {"smoke", "regresions"}, priority = 2)
    public void test1() {
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "tt");
    }

    @Test(dependsOnMethods = "test1", priority = 2)
    public void test2() {
        System.out.println("test2");
    }

    @Test(description = "*******", groups = {"smoke"}, dependsOnMethods = "test1", alwaysRun = true, priority = 1)
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
    public void test5(String name,String family,int age,int x) {
        System.out.println(name);
    }
    int i=0;

    @Test(retryAnalyzer = MyRetry.class)
    public void test6(){

        System.out.print(i+" ");
        System.out.println(Namess.name);
        assertEquals(Namess.name,"Vasiliy");
        i++;
    }

    @AfterClass
    public void afterTest() {
        driver.close();
    }
}
