import java.util.Scanner;

public class ATM {
    private double balance;
    private String transactionHistory;
    
    public ATM() {
        balance = 0.0;
        transactionHistory = "";
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory += "Deposit: $" + amount + "\n";
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory += "Withdrawal: $" + amount + "\n";
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public void transfer(double amount, ATM otherAccount) {
        if (balance >= amount) {
            withdraw(amount);
            otherAccount.deposit(amount);
            transactionHistory += "Transfer: $" + amount + " to account " + otherAccount + "\n";
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public void showTransactionHistory() {
        System.out.println(transactionHistory);
    }
    
    public static void main(String[] args) {
        ATM account1 = new ATM();
        ATM account2 = new ATM();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        
        while (!quit) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show transaction history");
            System.out.println("5. Quit");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    account1.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    account1.withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    account1.transfer(amount, account2);
                    break;
                case 4:
                    account1.showTransactionHistory();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
