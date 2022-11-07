package util;

public class Xpath {

    public static String byCssClass(String value){
        return "[contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')]";
    }

    public static String byNoCssClass(String value){
        return "[not(contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '))]";
    }
}
