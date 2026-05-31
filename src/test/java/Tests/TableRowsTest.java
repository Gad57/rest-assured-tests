package Tests;

import BaseTest.BaseTest;
import Page.TableRowsPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class TableRowsTest extends BaseTest {
    TableRowsPage tableRowsPage = new TableRowsPage();
    @Test
    public void openTest(){
        tableRowsPage.openPage();
        tableRowsPage.row(0).cheakLastName("Smith").cheakEmail("jsmith@gmail.com");
    }
}
