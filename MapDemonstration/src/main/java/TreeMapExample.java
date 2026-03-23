import java.util.*;
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> products = new TreeMap<>();
        products.put(105, "Laptop");
        products.put(106, "HP Laptop");
        products.put(103, "Mac Book");
        products.put(104, "Think Pad");
        products.put(102, "Idea pad");
        products.put(101, "Air pad");
        System.out.println(products);
    }
}
