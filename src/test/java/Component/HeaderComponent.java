package Component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {
    private SelenideElement title = $("h1");
    private SelenideElement subtitle = $("h2");
    public HeaderComponent checkTitle(String text){
        title.shouldHave(text(text));
        return this;
    }
    public HeaderComponent checkSubtitle(String text){
        subtitle.shouldHave(text(text));
        return this;
    }
}
