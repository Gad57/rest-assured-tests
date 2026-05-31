package Page;

import Component.ButtonChallingComponent;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class ButtonChallingPage {
    private ElementsCollection button = $$(".button");
    public ButtonChallingPage openPage(){
        open("https://the-internet.herokuapp.com/challenging_dom?utm_source=chatgpt.com");
        return this;
    }
    public ButtonChallingComponent buttonss(int index){
        return new ButtonChallingComponent(button.get(index));
    }
}
