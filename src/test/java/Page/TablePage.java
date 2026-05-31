package Page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class TablePage {
    private ElementsCollection table = $$("table tbody tr");
    public TablePage openPage(){
        open("https://the-internet.herokuapp.com/tables?utm_source=chatgpt.com");
        return this;
    }
    // Проверяет размер по индексу
    public TablePage cheakRowsCount(int count){
        table.shouldHave(size(count));
        return this;
    }
    // проверяем по таблице необходимые элементы по индексу и по названию
    public TablePage cheakRowText(String text, int index){
        table.get(index).shouldBe(visible).shouldHave(text(text));
        return this;

    }
}
