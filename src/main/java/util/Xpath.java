package util;

public class Xpath {
    private String selector;

    public Xpath(String selectorStart) {
        selector = selectorStart;
    }
    public Xpath byCssClass(String value){
        selector += "[contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')]";
        return this;
    }
    public Xpath byNoCssClass(String value){
        selector += "[not(contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '))]";
        return this;
    }
    public Xpath byId(String value){
        selector += "[@id='" + value + "']";
        return this;
    }
    public Xpath child(String value){
        selector += "//" + value;
        return this;
    }
    public Xpath filterByDescendantWithText(String value){
        selector += "[.//text()='"+ value + "']";
        return this;
    }
    public Xpath descendant(){
        selector += "//*";
        return this;
    }
    public String build(){
        return selector;
    }
}
