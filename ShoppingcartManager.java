//shopping cart manager

import java.util.*;

interface Purchasable {
    void addItem(int quantity);
    void removeItem(int quantity);
    double calculateTotalPrice();
    String getDescription();
}

abstract class Item implements Purchasable {
    protected String name;
    protected double price;
    protected int quantity;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String getDescription() {
        return name + " (Price: $" + price + ", Quantity: " + quantity + ")";
    }
}

class Electronics extends Item {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Item {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Books extends Item {
    public Books(String name, double price) {
        super(name, price);
    }
}

class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item, int quantity) {
        item.addItem(quantity);
        if (!items.contains(item)) {
            items.add(item);
        }
        System.out.println(quantity + " " + item.getDescription() + " added to the cart.");
    }

    public void removeItem(Item item, int quantity) {
        if (items.contains(item)) {
            item.removeItem(quantity);
            if (item.quantity == 0) {
                items.remove(item);
            }
            System.out.println(quantity + " " + item.getDescription() + " removed from the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Item item : items) {
                System.out.println(item.getDescription());
            }
        }
    }

    public void purchase() {
        double totalPrice = calculateTotalPrice();
        if (totalPrice > 0) {
            System.out.println("Total price: $" + totalPrice);
            System.out.println("Thank you for your purchase!");
            items.clear();
        } else {
            System.out.println("Your cart is empty.");
        }
    }
}

public class ShoppingCartManager {
    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        Map<String, Item> itemCatalog = new HashMap<>();
        itemCatalog.put("Laptop", new Electronics("Laptop", 1200));
        itemCatalog.put("Smartphone", new Electronics("Smartphone", 800));
        itemCatalog.put("T-Shirt", new Clothing("T-Shirt", 20));
        itemCatalog.put("Jeans", new Clothing("Jeans", 40));
        itemCatalog.put("Novel", new Books("Novel", 15));
        itemCatalog.put("Textbook", new Books("Textbook", 50));

        while (true) {
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. View Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Purchase Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    viewItems(itemCatalog);
                    break;
                case 2:
                    addItemToCart(itemCatalog);
                    break;
                case 3:
                    removeItemFromCart(itemCatalog);
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    cart.purchase();
                    break;
                case 6:
                    System.out.println("Exiting. Thank you for shopping with us!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewItems(Map<String, Item> itemCatalog) {
        System.out.println("Available items:");
        for (Item item : itemCatalog.values()) {
            System.out.println(item.getDescription());
        }
    }

    private static void addItemToCart(Map<String, Item> itemCatalog) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        Item item = itemCatalog.get(name);
        if (item != null) {
            System.out.print("Enter quantity: ");
            int quantity = getValidIntInput();
            cart.addItem(item, quantity);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void removeItemFromCart(Map<String, Item> itemCatalog) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        Item item = itemCatalog.get(name);
        if (item != null) {
            System.out.print("Enter quantity: ");
            int quantity = getValidIntInput();
            cart.removeItem(item, quantity);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static int getValidIntInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.next(); // consume invalid input
            }
        }
    }
}
