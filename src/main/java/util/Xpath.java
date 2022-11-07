package util;

public class Xpath {
    private static String hasCssClass(String value) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')";
    }
    public static String filterBy(String predicate){
        return "[" + predicate + "]";
    }
    public static String not(String predicate){
        return "not(" + predicate + ")";
    }
    public static String byCssClass(String value){
        return filterBy(hasCssClass(value));
    }
    public static String byNoCssClass(String value){
        return filterBy(not(hasCssClass(value)));
    }
}
