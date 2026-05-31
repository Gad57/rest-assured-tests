package Component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class ButtonComponent {
    private SelenideElement button;
    public ButtonComponent (SelenideElement button){
        this.button = button;
    }
    public ButtonComponent cheakText(String text){
        button.shouldHave(text(text));
        return this;
    }
    public ButtonComponent click(){
        button.click();
        return this;
    }
}
