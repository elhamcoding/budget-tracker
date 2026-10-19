public class BudgetCategory implements Comparable<BudgetCategory> {
    private String category;
    private double limit;
    private double spent;

    
public BudgetCategory(String category, double limit, double spent) {
    this.category = category;
    this.limit = limit;
    this.spent = spent;
}

public String getCategory() {
    return category;
}

public double getLimit() {
    return limit;
}

public double getSpent() {
    return spent;
}

public String toString() {
    return "Category: " + category + ", Limit: $" + limit
            + ", Spent: $" + spent;
}

    public int compareTo(BudgetCategory other) {
        double myDifference = spent - limit;
        double otherDifference = other.spent - other.limit;

        if (myDifference < otherDifference) {
            return -1;
        } else if (myDifference > otherDifference) {
            return 1;
        } else {
            return 0;
         }
    }

}
