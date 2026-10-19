import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class BudgetApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<BudgetCategory> categories = new ArrayList<>();

        while(scan.hasNextLine()) {
            String category = scan.nextLine();

            double limit = scan.nextDouble();
            double spent = scan.nextDouble();

            // Consume \n after spent input 
            if(scan.hasNextLine()) scan.nextLine();
            BudgetCategory newCategory = new BudgetCategory(category, limit, spent);
            categories.add(newCategory);

        }
        Collections.sort(categories);
        Collections.reverse(categories);
        
        for (BudgetCategory item : categories) {
            System.out.println(item);
        }
        
    int difference = budgetDifference(categories);
    System.out.println("Total budget difference: $" + difference);

    
    double average = averageBudgetDifference(categories);
    System.out.println("Average budget difference: $" + String.format("%.2f", average));



       /*
        BudgetCategory groceries = new BudgetCategory("Groceries", 500, 401);   

        System.out.println(groceries.getCategory());
        System.out.println(groceries.getLimit());
        System.out.println(groceries.getSpent());
        System.out.println(groceries.toString());
        */
    }

    /**
     * Returns overall how much over/under budget a person is given a list of their
     * categories.
     * 
     * This should be the sum of how much over/under budget each individual category is.
     * 
     * If the person is under budget, the result will be negative. If they are over budget, the
     * result will be positive.
     * 
     * @param categories the budget categories with the spend
     * @return the total amount over/under budget
     */
   
    public static int budgetDifference(List<BudgetCategory> categories) {
    double total = 0;

    for (BudgetCategory item : categories) {
        total = total + (item.getSpent() - item.getLimit());
    }

    return (int) Math.round(total);
    }

    public static double averageBudgetDifference(List<BudgetCategory> categories) {
        if (categories.size() == 0) {
        return 0;
        }

        double total = 0;

        for (BudgetCategory item : categories) {
        total = total + (item.getSpent() - item.getLimit());
        }

        return total / categories.size();
    }
}