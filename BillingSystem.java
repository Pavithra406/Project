import java.util.Scanner;

class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotal() {
        return quantity * price;
    }

    void display() {
        System.out.printf("%-15s %-10d %-10.2f %-10.2f\n", name, quantity, price, getTotal());
    }
}

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item[] cart = new Item[100];
        int count = 0;

        System.out.println("🛒 Welcome to the Shop Billing System");
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1) + ":");
            System.out.print("Item name: ");
            scanner.nextLine(); 
            String name = scanner.nextLine();
            System.out.print("Quantity: ");
            int qty = scanner.nextInt();
            System.out.print("Price per unit: ");
            double price = scanner.nextDouble();

            cart[count++] = new Item(name, qty, price);
        }

        
        double grandTotal = 0;
        System.out.println("\n🧾 Final Bill:");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Item Name", "Quantity", "Price", "Total");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < count; i++) {
            cart[i].display();
            grandTotal += cart[i].getTotal();
        }

        double tax = grandTotal * 0.05; 
        double netAmount = grandTotal + tax;

        System.out.println("-------------------------------------------------");
        System.out.printf("Subtotal: %.2f\n", grandTotal);
        System.out.printf("Tax (5%%): %.2f\n", tax);
        System.out.printf("Net Amount: %.2f\n", netAmount);

        System.out.println("\n✅ Thank you for shopping with us!");
        scanner.close();
    }
}
