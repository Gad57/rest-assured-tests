package Page;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class PracticeFormPage {
    private SelenideElement firsName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement gender = $("#gender-radio-1");
    private SelenideElement buttonClick = $("#submit");
    private SelenideElement hobbi = $x("//label[text()='Sports']");
    private SelenideElement file = $("#uploadPicture");
    private SelenideElement number = $("#userNumber");
    private SelenideElement cheakResult = $("#example-modal-sizes-title-lg");


    public PracticeFormPage openPage(){
        open("https://demoqa.com/automation-practice-form?utm_source=chatgpt.com");
        return this;
    }
    public PracticeFormPage setFirstName(String Firstname){
        firsName.shouldBe(visible).setValue(Firstname);
        return this;
    }
    public PracticeFormPage setLastName(String LastName){
        lastName.shouldBe(visible).setValue(LastName);
        return this;
    }
    public PracticeFormPage setEmail(String email){
        userEmail.shouldBe(visible).setValue(email);
        return this;
    }
    public PracticeFormPage clickGender(){
        gender.click();
        return this;
    }
    public PracticeFormPage setNumber(String num){
        number.shouldBe(visible).setValue(num);
        return this;
    }
    public PracticeFormPage clickHobbi(){
        hobbi.click();
        return this;
    }
    // МЕТОД ЗАГРУЗКИ ФАЙЛОВ
    public PracticeFormPage pathFile(){
        file.uploadFile(new File("src/test/java/resurse/get_preview_url.jpg"));
        return this;
    }
    // Каленьдарь с выбором даты ТО САМОЕ
    public PracticeFormPage setBirdDane(String mounth, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(mounth);
        $(".react-datepicker__year-select").selectOption(year);
        $x("//div[contains(@class,'day') " + "and text()='" + day + "']").click();
        return this;
    }
    public PracticeFormPage clickButton(){
        buttonClick.scrollTo().click();
        return this;
    }
    public PracticeFormPage cheakResultProfile(String text){
        cheakResult.shouldBe(visible).shouldHave(text(text));
        return this;
    }
}
