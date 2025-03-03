import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Phone", "Electronics", 800.00),
            new Product("TV", "Electronics", 1500.00),
            new Product("Sofa", "Furniture", 700.00),
            new Product("Table", "Furniture", 300.00),
            new Product("Chair", "Furniture", 150.00)
        );

        // Grouping products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products grouped by category: " + productsByCategory);

        // Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        System.out.println("Most expensive product in each category: " + mostExpensiveByCategory);

        // Calculating the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0.0);
        System.out.println("Average price of all products: $" + averagePrice);
    }
}


// output:
// Products grouped by category: {Electronics=[Laptop (Electronics, $1200.0), Phone (Electronics, $800.0), TV (Electronics, $1500.0)], Furniture=[Sofa (Furniture, $700.0), Table (Furniture, $300.0), Chair (Furniture, $150.0)]}
// Most expensive product in each category: {Electronics=Optional[TV (Electronics, $1500.0)], Furniture=Optional[Sofa (Furniture, $700.0)]}
// Average price of all products: $775.0
