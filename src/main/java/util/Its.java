package util;

public class Its {

    public static String cssClass(String value){
        return hasCssClass(value);
    }

    public static String noCssClass(String value){
        return not(hasCssClass(value));
    }
    private static String hasCssClass(String value) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')";
    }
    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }
    public static String id(String value){
        return  "@id='" + value + "'";
    }
    public static String descendantWithText(String value){
        return ".//text()='" + value + "'";
    }
}
