package Page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;



public class AlertPage {
    private SelenideElement clickJSAlert1 = $x("//button[text()='Click for JS Alert']");
    private SelenideElement clockforJSConf2 = $x("//button[text()='Click for JS Confirm']");
    private SelenideElement clickJSPrompt3 = $x("//button[text()='Click for JS Prompt']");
    private SelenideElement result = $("#result");
    public AlertPage openPage(){
        open("https://the-internet.herokuapp.com/javascript_alerts?utm_source=chatgpt.com");
        return this;
    }
    public AlertPage clickAlertJSAlert(){
        clickJSAlert1.click();
        return this;
    }
    public AlertPage clickAlertJSConf(){
        clockforJSConf2.click();
        return this;
    }
    public AlertPage clickJSPromt(){
        clickJSPrompt3.click();
        return this;
    }
    public AlertPage acceptAlert(){
        switchTo().alert().accept();
        return this;
    }
    public AlertPage acceptAlert2(){
        switchTo().alert().dismiss();
        return this;
    }
    public AlertPage acceptAlert3(String text){
        switchTo().alert().sendKeys(text);
        switchTo().alert().accept();
        return this;
    }
    public AlertPage cheakResult(String results){
        result.shouldHave(text(results));
        return this;
    }
}
