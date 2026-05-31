package Tests;

import BaseTest.BaseTest;
import Page.AlertPage;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest {
    AlertPage alertPage = new AlertPage();
    @Test
    public void alertTests(){
        alertPage.openPage();
        alertPage
                .clickAlertJSAlert()
                .acceptAlert()
                .cheakResult("You successfully clicked an alert");
        alertPage
                .clickAlertJSConf()
                .acceptAlert2()
                .cheakResult("You clicked: Cancel");
        alertPage
                .clickJSPromt()
                .acceptAlert3("Hello!")
                .cheakResult("You entered: Hello!");
    }
}
