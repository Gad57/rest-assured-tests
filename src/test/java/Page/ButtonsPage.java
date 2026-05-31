package Page;

import Component.ButtonComponent;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonsPage {
    private ElementsCollection buttons = $$("button");
    public ButtonsPage openPage(){
        open("https://the-internet.herokuapp.com/add_remove_elements/?utm_source=chatgpt.com");
        return this;

    }
    public ButtonComponent button(int index){
        return new ButtonComponent(buttons.get(index));
    }
}
