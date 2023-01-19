package configuretions;

import configuretions.proxyconfig.ConfigUserAgens;
import configuretions.proxyconfig.USERAGENT;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseProxy extends BaseClass{
    public static BrowserMobProxyServer serverBase;
    @BeforeClass
    public  void startP(){
        ConfigUserAgens.createUserAgent(USERAGENT.ANDROIRU,serverBase);
    }
    @AfterClass
    public void stopP(){
    serverBase.stop();
    }
}
