package  com.hb.study.javamasterclasscourse.section10_collections.misc_practice;

public record GroceryItem (String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}