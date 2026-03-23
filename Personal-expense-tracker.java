```
import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String date;
    private String category;
    private double amount;
    private String description;

    public Expense(String date, String category, double amount, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " | " + description;
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Personal Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Expense");
            System.out.println("4. Search by Category");
            System.out.println("5. Monthly Expense Summary");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    calculateTotal();
                    break;
                case 4:
                    searchByCategory(sc);
                    break;
                case 5:
                    monthlyExpenseSummary();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addExpense(Scanner sc) {
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Expense e = new Expense(date, category, amount, description);
        expenses.add(e);

        System.out.println("Expense Added Successfully!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    public static void calculateTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Expense: " + total);
    }

    public static void searchByCategory(Scanner sc) {
        System.out.print("Enter category to search: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public static void monthlyExpenseSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        double jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0;
        double jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

        for (Expense e : expenses) {
            String date = e.getDate();
            double amount = e.getAmount();

            String month = date.substring(3, 5); // MM

            switch (month) {
                case "01": jan += amount; break;
                case "02": feb += amount; break;
                case "03": mar += amount; break;
                case "04": apr += amount; break;
                case "05": may += amount; break;
                case "06": jun += amount; break;
                case "07": jul += amount; break;
                case "08": aug += amount; break;
                case "09": sep += amount; break;
                case "10": oct += amount; break;
                case "11": nov += amount; break;
                case "12": dec += amount; break;
            }
        }

        System.out.println("\nMonthly Expense Summary:");
        System.out.println("Jan: " + jan);
        System.out.println("Feb: " + feb);
        System.out.println("Mar: " + mar);
        System.out.println("Apr: " + apr);
        System.out.println("May: " + may);
        System.out.println("Jun: " + jun);
        System.out.println("Jul: " + jul);
        System.out.println("Aug: " + aug);
        System.out.println("Sep: " + sep);
        System.out.println("Oct: " + oct);
        System.out.println("Nov: " + nov);
        System.out.println("Dec: " + dec);
    }
}


```
