import java.util.*;

class Bus {
    int busNo;
    String driverName;
    String from;
    String to;
    int totalSeats = 40;
    int bookedSeats = 0;

    Bus(int busNo, String driverName, String from, String to) {
        this.busNo = busNo;
        this.driverName = driverName;
        this.from = from;
        this.to = to;
    }

    void displayBusDetails() {
        System.out.println("Bus No: " + busNo + ", Driver: " + driverName +
                ", From: " + from + ", To: " + to +
                ", Seats Available: " + (totalSeats - bookedSeats));
    }

    boolean bookSeat(int seats) {
        if (bookedSeats + seats <= totalSeats) {
            bookedSeats += seats;
            return true;
        } else {
            return false;
        }
    }
}

class BusManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Bus> busList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Bus Management System ===");
            System.out.println("1. Add Bus");
            System.out.println("2. View Buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    viewBuses();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    System.out.println("Exiting...Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addBus() {
        System.out.print("Enter Bus No: ");
        int busNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Driver Name: ");
        String driver = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();

        busList.add(new Bus(busNo, driver, from, to));
        System.out.println("Bus added successfully.");
    }

    static void viewBuses() {
        if (busList.isEmpty()) {
            System.out.println("No buses available.");
        } else {
            System.out.println("\nAvailable Buses:");
            for (Bus b : busList) {
                b.displayBusDetails();
            }
        }
    }

    static void bookTicket() {
        System.out.print("Enter Bus No: ");
        int busNo = sc.nextInt();
        System.out.print("Enter number of seats to book: ");
        int seats = sc.nextInt();

        for (Bus b : busList) {
            if (b.busNo == busNo) {
                if (b.bookSeat(seats)) {
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("Not enough seats available.");
                }
                return;
            }
        }
        System.out.println("Bus not found!");
    }
}
