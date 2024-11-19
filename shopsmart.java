import java.util.ArrayList;
import java.util.Scanner;

// Product class to hold product details
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

// Cart class to manage cart items
class Cart {
    ArrayList<Product> items = new ArrayList<>();

    void addProduct(Product product) {
        items.add(product);
        System.out.println(product.name + " added to the cart.");
    }

    void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            double total = 0;
            for (Product product : items) {
                System.out.println(product);
                total += product.price;
            }
            System.out.println("Total: $" + total);
        }
    }
}

// Main E-Commerce Application
public class shopsmart{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample product catalog
        ArrayList<Product> catalog = new ArrayList<>();
        catalog.add(new Product(1, "Laptop", 750.00));
        catalog.add(new Product(2, "Smartphone", 500.00));
        catalog.add(new Product(3, "Headphones", 50.00));
        catalog.add(new Product(4, "Keyboard", 30.00));
        catalog.add(new Product(5, "Mouse", 20.00));

        Cart cart = new Cart();
        int choice;

        do {
            System.out.println("\nE-Commerce Application");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nProduct Catalog:");
                    for (Product product : catalog) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    System.out.print("\nEnter Product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    boolean found = false;
                    for (Product product : catalog) {
                        if (product.id == productId) {
                            cart.addProduct(product);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    System.out.println("Thank you for using the E-Commerce Application!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
