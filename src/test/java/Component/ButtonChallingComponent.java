package Component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class ButtonChallingComponent {
    private SelenideElement button;
    public ButtonChallingComponent (SelenideElement button){
        this.button = button;
    }
    public ButtonChallingComponent cheakText(String text){
        button.shouldHave(text(text));
        return this;
    }
    public ButtonChallingComponent clickButton(){
      button.click();
      return this;
    }
}
