import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Transaction\n2. View Balance\n3. View Spending by Category\n4. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Date (e.g., 2023-01-01): ");
                    String date = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount (positive for income, negative for expense): ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    manager.addTransaction(new Transaction(date, desc, category, amount));
                    break;
                case "2":
                    System.out.println("Current Balance: $" + manager.getBalance());
                    break;
                case "3":
                    System.out.println("Spending by Category: " + manager.getSpendingByCategory());
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}