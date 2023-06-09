package models;

import java.util.List;

public class YearlyReportRecord {
    private int month;

    private int amount;
    private boolean isExpense;

    public YearlyReportRecord(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
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

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

}