package Tests;

import BaseTest.BaseTest;
import Page.ButtonChallingPage;
import org.junit.jupiter.api.Test;

public class ButtonChallingTest extends BaseTest {
    ButtonChallingPage buttonChallingPage = new ButtonChallingPage();
    @Test
    public void openTest(){
        buttonChallingPage.openPage();
        buttonChallingPage.buttonss(0).cheakText("foo").clickButton();
        buttonChallingPage.buttonss(1).cheakText("bar").clickButton();
        buttonChallingPage.buttonss(2).cheakText("baz").clickButton();
    }
}
