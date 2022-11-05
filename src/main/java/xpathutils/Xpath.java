package xpathutils;

public class Xpath {

    public static String hasCssClass(String cssClass){
        return "[contains(concat(' ', normalize-space(@class), ' '), ' " + cssClass + " ')]";
    }

    public static String notHaveCssClass(String cssClass){
        return "[not(contains(concat(' ', normalize-space(@class), ' '), ' " + cssClass + " '))]";
    }
}
