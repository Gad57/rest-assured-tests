package Tests;

import BaseTest.BaseTest;
import Page.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void homeTest(){
        homePage.openPage();
        homePage.header.checkTitle("Welcome to the-internet").checkSubtitle( "Available Examples");

    }
}
