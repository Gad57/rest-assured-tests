package Tests;

import BaseTest.BaseTest;
import Page.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @ParameterizedTest
    @CsvSource({"admin, 12345, You logged into a secure area!",
            "user, qwerty, You logged into a secure area!",
            "tomsmith, SuperSecretPassword!, You logged into a secure area!"})
    public void loginTest(String username, String password, String errorMessage){

        loginPage.openPage().clickName(username).clickPassword(password).loginclick().cheakErrorMessage(errorMessage);
    }
}


