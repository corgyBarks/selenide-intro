package selenideintro.xpath;

import org.junit.jupiter.api.Test;

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

        $(byXpath("//*[@id='todo-list']//li[.//text()='b']//*[contains(concat(' ', normalize-space(@class), ' '), ' toggle ')]"))
                .click();

        $$(byXpath("//*[@id='todo-list']//li[contains(concat(' ', normalize-space(@class), ' '), ' completed ')]"))
                .shouldHave(exactTexts("b"));
        $$(byXpath("//*[@id='todo-list']//li[not(contains(concat(' ', normalize-space(@class), ' '), ' completed '))]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
