package Page;

import Component.HeaderComponent;

import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    public HeaderComponent header = new HeaderComponent();
    public HomePage openPage(){
        open("https://the-internet.herokuapp.com/?utm_source=chatgpt.com");
        return this;
    }
}
