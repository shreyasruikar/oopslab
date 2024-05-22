//thread demo

class TablePrinter {
    synchronized void printTwoTable() {
        System.out.println("2's Table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(2 + " * " + i + " = " + 2 * i);
            try {
                Thread.sleep(500); // Simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void printFiveTable() {
        System.out.println("5's Table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(5 + " * " + i + " = " + 5 * i);
            try {
                Thread.sleep(500); // Simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        TablePrinter tablePrinter = new TablePrinter();

        Thread thread1 = new Thread(() -> tablePrinter.printTwoTable());
        Thread thread2 = new Thread(() -> tablePrinter.printFiveTable());

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Simulate some delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true); // Setting the thread as daemon

        thread1.start();
        thread2.start();
        daemonThread.start();

        // Menu-driven program to demonstrate different operations
        System.out.println("Menu:");
        System.out.println("1. Print 2's Table");
        System.out.println("2. Print 5's Table");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        // Assume user input is provided as per the menu options
        int choice = 0; // Placeholder for user choice
        // Perform actions based on user choice
        switch (choice) {
            case 1:
                tablePrinter.printTwoTable();
                break;
            case 2:
                tablePrinter.printFiveTable();
                break;
            case 3:
                System.out.println("Exiting program...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }
}
