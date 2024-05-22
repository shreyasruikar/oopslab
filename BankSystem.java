//bank system

import java.util.*;

interface BankAcc {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankAcc toAcc, double amount);
    void viewTransactions();
    String getAccNumber();
}

abstract class AbsBankAcc implements BankAcc {
    protected String accNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public AbsBankAcc(String accNumber, double initialDeposit) {
        this.accNumber = accNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial deposit: $" + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: $" + amount);
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void transfer(BankAcc toAcc, double amount) {
        if (balance >= amount) {
            balance -= amount;
            toAcc.deposit(amount);
            transactionHistory.add("Transfer to Account " + toAcc.getAccNumber() + ": $" + amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    @Override
    public void viewTransactions() {
        System.out.println("Transaction History for Account " + accNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }

    @Override
    public String getAccNumber() {
        return accNumber;
    }
}

class SavAcc extends AbsBankAcc {
    public SavAcc(String accNumber, double initialDeposit) {
        super(accNumber, initialDeposit);
    }
}

class ChkAcc extends AbsBankAcc {
    public ChkAcc(String accNumber, double initialDeposit) {
        super(accNumber, initialDeposit);
    }
}

class Bnk {
    private final Map<String, BankAcc> accounts = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account type (Savings/Checking): ");
        String type = scanner.nextLine();
        double initialDeposit = getValidDoubleInput("Enter initial deposit amount: ");
        System.out.print("Enter desired account number: ");
        String accNumber = scanner.nextLine();

        if (accounts.containsKey(accNumber)) {
            System.out.println("Account number already exists. Please try again.");
            return;
        }

        BankAcc account;
        if (type.equalsIgnoreCase("Savings")) {
            account = new SavAcc(accNumber, initialDeposit);
        } else if (type.equalsIgnoreCase("Checking")) {
            account = new ChkAcc(accNumber, initialDeposit);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        accounts.put(accNumber, account);
        System.out.println("Account created successfully! Account Number: " + accNumber);
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        double amount = getValidDoubleInput("Enter deposit amount: ");

        BankAcc account = accounts.get(accNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        double amount = getValidDoubleInput("Enter withdrawal amount: ");

        BankAcc account = accounts.get(accNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performTransfer() {
        System.out.print("Enter your account number: ");
        String fromAccNumber = scanner.nextLine();
        System.out.print("Enter target account number: ");
        String toAccNumber = scanner.nextLine();
        double amount = getValidDoubleInput("Enter transfer amount: ");

        BankAcc fromAccount = accounts.get(fromAccNumber);
        BankAcc toAccount = accounts.get(toAccNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewTransactions() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        BankAcc account = accounts.get(accNumber);
        if (account != null) {
            account.viewTransactions();
        } else {
            System.out.println("Account not found.");
        }
    }

    private double getValidDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // consume invalid input
            }
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    viewTransactions();
                    break;
                case 6:
                    System.out.println("Exiting. Thank you for using the banking system!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getValidIntInput() {
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

public class BankSys {
    public static void main(String[] args) {
        Bnk bank = new Bnk();
        bank.showMenu();
    }
}
