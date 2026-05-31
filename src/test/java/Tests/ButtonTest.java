package Tests;

import BaseTest.BaseTest;
import Page.ButtonsPage;
import org.junit.jupiter.api.Test;

public class ButtonTest extends BaseTest {
    ButtonsPage buttonsPage = new ButtonsPage();
    @Test
    public void buttonsTest(){
        buttonsPage.openPage();
        buttonsPage.button(0).cheakText("add Element").click();
    }
}
