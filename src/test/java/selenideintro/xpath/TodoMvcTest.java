package selenideintro.xpath;

import org.junit.jupiter.api.Test;
import util.Its;
import util.Xpath;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath(Xpath.all().by(Its.id("new-todo")).build())).setValue("a").pressEnter();
        $(byXpath(Xpath.all().by(Its.id("new-todo")).build())).setValue("b").pressEnter();
        $(byXpath(Xpath.all().by(Its.id("new-todo")).build())).setValue("c").pressEnter();
        $$(byXpath(Xpath.all().by(Its.id("todo-list")).descendant("li").build()))
                .shouldHave(exactTexts("a", "b", "c"));

        $(byXpath(Xpath
                        .all()
                        .by(Its.id("todo-list"))
                        .child("li")
                        .by(Its.descendantWithText("b"))
                        .descendant()
                        .by(Its.cssClass("toggle"))
                        .build()
                        )).click();

        $$(byXpath(Xpath
                .all()
                .by(Its.id("todo-list"))
                .child("li")
                .by(Its.cssClass("completed"))
                .build()))
                .shouldHave(exactTexts("b"));

        $$(byXpath(new Xpath("//*")
                .by(Its.id("todo-list"))
                .child("li")
                .by(Its.noCssClass("completed"))
                .build()))
                .shouldHave(exactTexts("a", "c"));
    }
}
