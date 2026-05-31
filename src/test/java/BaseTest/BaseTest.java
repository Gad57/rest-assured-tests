package BaseTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import io.qameta.allure.Step;

public class BaseTest {

        @BeforeEach
        void setUp(){
            addListener( "allure", new AllureSelenide()
                    .screenshots(true)
                    .savePageSource(true)
            );
            Configuration.browser = "chrome";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 10000;
            Configuration.browserSize = "1920x1080";
        }

    }

