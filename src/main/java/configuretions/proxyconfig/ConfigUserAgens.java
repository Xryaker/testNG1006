package configuretions.proxyconfig;

import net.lightbody.bmp.BrowserMobProxyServer;

public class ConfigUserAgens {
    public static void createUserAgent(USERAGENT useragent, BrowserMobProxyServer server){
        switch (useragent){
            case ANDROIRU -> createAndroidRuAgent(server);
            case ANDROIDEN -> createAndroidEN(server);
            case RUSSIAN -> createRusssianAgent(server);
        }
    }

    private static void createRusssianAgent(BrowserMobProxyServer server) {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");
            request.headers().add("Accept-Language", "ru");
            request.headers().add("Content-Language", "ru_RU");
            request.headers().remove("Referer");

            return null;
        });
    }

    private static void createAndroidEN(BrowserMobProxyServer server) {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");
//Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36
            // request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            request.headers().add("User-Agent","Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
            request.headers().add("Accept-Language", "en");
            request.headers().add("Content-Language", "en_EN");

            request.headers().remove("Referer");

            return null;
        });
    }

    private static void createAndroidRuAgent(BrowserMobProxyServer server) {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");
//Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36
           // request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            request.headers().add("User-Agent","Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
            request.headers().add("Accept-Language", "ru");
            request.headers().add("Content-Language", "ru_RU");

            request.headers().remove("Referer");

            return null;
        });

    }
}
