package  com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;

public record GroceryItem (String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}