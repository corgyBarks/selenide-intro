package util;

public class Its {

    public static String cssClass(String value){
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')";
    }
    public static String id(String value){
        return  "@id='" + value + "'";
    }
    public static String descendantWithText(String value){
        return ".//text()='" + value + "'";
    }
}
