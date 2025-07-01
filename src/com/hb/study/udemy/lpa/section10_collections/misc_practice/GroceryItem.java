package  com.hb.study.udemy.lpa.section10_collections.misc_practice;

public record GroceryItem (String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}