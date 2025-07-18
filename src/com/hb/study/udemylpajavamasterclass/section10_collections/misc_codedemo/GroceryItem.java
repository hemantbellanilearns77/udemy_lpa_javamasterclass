package  com.hb.study.udemylpajavamasterclass.section10_collections.misc_codedemo;

public record GroceryItem (String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}