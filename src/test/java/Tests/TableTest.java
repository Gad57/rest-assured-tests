package Tests;

import BaseTest.BaseTest;
import Page.TablePage;
import org.junit.jupiter.api.Test;

public class TableTest extends BaseTest {
    TablePage tablePage = new TablePage();
    @Test
    public void openTest(){
        tablePage.openPage().cheakRowsCount(4).cheakRowText("Smith", 0);
    }
}
