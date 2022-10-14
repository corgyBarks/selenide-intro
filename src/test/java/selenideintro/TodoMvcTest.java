package selenideintro;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$$;

public class TodoMvcTest {


    @Test
    void completesTask(){



        open("https://todomvc.com/examples/emberjs/");



        $("#new-todo").setValue("a").pressEnter();

        $("#new-todo").setValue("b").pressEnter();

        $("#new-todo").setValue("c").pressEnter();



        $$("#todo-list li").shouldHave(exactTexts("a", "b", "c"));

        $("#todo-list li:nth-child(2) .toggle").click();
        $("#todo-list li.completed:nth-child(2)")

                .shouldHave(exactText("b"));



        $$("#todo-list>li:not(.completed)")

                .shouldHave(exactTexts("a", "c"));

    }

}
