import configuretions.BaseProxy;
import org.testng.annotations.Test;

public class TestYoutube extends BaseProxy {
    String Url="https://youtube.com";

    @Test(description = "test latest")
    public void test(){

        driver.get(Url);

    }

}
