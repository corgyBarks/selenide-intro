package selenideintro.xpath;

import org.junit.jupiter.api.Test;
import util.Xpath;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        $(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        $(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        $$(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        $(byXpath(new Xpath("//*")
                .byId("todo-list")
                .child("li")
                .filterByDescendantWithText("b")
                        .descendant()
                        .byCssClass("toggle")
                        .build()
                        )).click();

        $$(byXpath(new Xpath("//*")
                .byId("todo-list")
                .child("li")
                .byCssClass("completed")
                .build()))
                .shouldHave(exactTexts("b"));

        $$(byXpath(new Xpath("//*")
                .byId("todo-list")
                .child("li")
                .byNoCssClass("completed")
                .build()))
                .shouldHave(exactTexts("a", "c"));
    }
}
