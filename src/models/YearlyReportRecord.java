package models;
public class YearlyReportRecord {
    private final int month;

    private final int amount;
    private final boolean isExpense;
    private final int year;


    public YearlyReportRecord(int month, int amount, boolean isExpense, int year) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
        this.year = year;

    }

    @Override
    public String toString() {
        return "YearlyReportRecord{" +
                "month=" + month +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }

    public int getMonth() {
        return month;
    }
    public int getAmount() {
        return amount;
    }
    public boolean isExpense() {
        return isExpense;
    }

    public int getYear() {
        return year;
    }
}
