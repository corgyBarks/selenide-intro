package selenideintro;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTestByXpath {
    @Test
    void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $(byXpath("//input[@id='new-todo']")).setValue("a").pressEnter();
        $(byXpath("//input[@id='new-todo']")).setValue("b").pressEnter();
        $(byXpath("//input[@id='new-todo']")).setValue("c").pressEnter();
        $$(byXpath("//ul[@id='todo-list']/li")).shouldHave(exactTexts("a", "b", "c"));

        $(byXpath("//ul[@id='todo-list']/li[2]//input[@class='toggle']")).click();

        $$(byXpath("//ul[@id='todo-list']/li[starts-with(@class,'completed')]"))
                .shouldHave(exactTexts("b"));
        $$(byXpath("//ul[@id='todo-list']/li[not(starts-with(@class,'completed'))]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
