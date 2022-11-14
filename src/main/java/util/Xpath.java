package util;

public class Xpath {
    public static Xpath all(){
        return new Xpath("//*");
    }
    private String selector;
    public Xpath(String selectorStart) {
        selector = selectorStart;
    }
    public Xpath by(String predicate){
        selector += "[" + predicate + "]";
        return this;
    }
    public Xpath byNot(String predicate){
        selector += "[not(" + predicate + ")]";
        return this;
    }
    public Xpath child(){
        child("*");
        return this;
    }
    public Xpath child(String element){
        selector += "/" + element;
        return this;
    }
    public Xpath descendant(){
        descendant("*");
        return this;
    }
    public Xpath descendant(String element){
        selector += "//" + element;
        return this;
    }
    public String build(){
        return selector;
    }
}
