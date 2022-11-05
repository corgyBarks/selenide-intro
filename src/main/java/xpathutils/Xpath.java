package xpathutils;

public class Xpath {

    public static String hasCssClass(String cssClassName){
        return "[contains(concat(' ', normalize-space(@class), ' '), ' " + cssClassName + " ')]";
    }

    public static String notHaveCssClass(String cssClassName){
        return "[not(contains(concat(' ', normalize-space(@class), ' '), ' " + cssClassName + " '))]";
    }
}
