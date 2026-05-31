package Page;

import Component.TableRowsComponent;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TableRowsPage {
    private ElementsCollection rows = $$("table tbody tr");
    public TableRowsPage openPage(){
        open("https://the-internet.herokuapp.com/tables?utm_source=chatgpt.com");
        return this;
    }
    public TableRowsComponent row(int index){
        return new TableRowsComponent(rows.get(index));

    }
}
