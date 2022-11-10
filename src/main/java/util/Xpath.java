package util;

public class Xpath {
    public static Xpath all(){
        return new Xpath("//*");
    }
    private String selector;

    public Xpath(String selectorStart) {
        selector = selectorStart;
    }
    public Xpath child(String value){
        selector += "/" + value;
        return this;
    }
    public Xpath by(String predicate){
        selector += "[" + predicate + "]";
        return this;
    }
    public Xpath descendant(){
        selector += "//*";
        return this;
    }
    public Xpath descendant(String value){
        selector += "//" + value;
        return this;
    }
    public String build(){
        return selector;
    }
}
