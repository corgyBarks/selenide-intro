package selenideintro.xpath;

import org.junit.jupiter.api.Test;
import xpathutils.Xpath;

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

        $(byXpath("//*[@id='todo-list']//li[.//text()='b']//*" + Xpath.hasCssClass("toggle")))
                .click();

        $$(byXpath("//*[@id='todo-list']//li" + Xpath.hasCssClass("completed")))
                .shouldHave(exactTexts("b"));
        $$(byXpath("//*[@id='todo-list']//li" + Xpath.notHaveCssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }
}
