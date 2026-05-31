package Page;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;
public class LoginPage {private SelenideElement name = $("#username");
    private SelenideElement password = $("#password");
    private SelenideElement login = $(".fa-sign-in");
    @Step("Open login page")
    public LoginPage openPage(){
        open("https://the-internet.herokuapp.com/login");
        return this;
    }
    @Step("Set username: {username}")
    public LoginPage clickName(String text){
        name.shouldBe(visible).setValue(text);
        return this;
    }
    @Step("Set password")
    public LoginPage clickPassword(String text){
        password.shouldBe(visible).setValue(text);
        return this;
    }
    @Step("Click login button")
    public LoginPage loginclick(){
        login.click();
        return this;
    }
    public LoginPage cheakErrorMessage(String text){
        $("#flash").shouldHave(text(text));

        return this;
    }
}

