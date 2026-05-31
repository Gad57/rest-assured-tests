package Component;

import Page.TablePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TableRowsComponent {
    private SelenideElement row;
    public TableRowsComponent (SelenideElement row){
        this.row = row;
    }

// Ищет в первом столбце Имя
    public TableRowsComponent cheakLastName(String name){
        row.$$("td").get(0).shouldHave(text(name));
        return this;
    }
    // Ищет емаил в третьем столбце ( 3 столбец это 2 индекс)
    public TableRowsComponent cheakEmail(String email){
        row.$$("td").get(2).shouldHave(text(email));
        return this;
    }
}
