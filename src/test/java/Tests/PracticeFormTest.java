package Tests;

import BaseTest.BaseTest;
import Page.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    public void SetFormsTest(){
        practiceFormPage.openPage()
                .setFirstName("Данил")
                .setLastName("Рушков")
                .setEmail("rushkov@gmail.ru")
                .clickGender()
                .setNumber("89323291288")
                .clickHobbi()
                .setBirdDane("April","1998", "11")
                .pathFile()
                .clickButton()
                .cheakResultProfile("Thanks for submitting the form");
    }
}
