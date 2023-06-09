package models;

import java.util.Objects;

public class MonthlyReportRecord {
    private String itemName;
    private  boolean isExpense;
    private int quantity;
    private int sumOfOne;

    public MonthlyReportRecord(String itemName, boolean isExpense, int quantity, int sumOfone){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfone;

    }


    public String getItemName() {
        return itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSumOfOne() {
        return sumOfOne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthlyReportRecord record = (MonthlyReportRecord) o;
        return isExpense == record.isExpense && quantity == record.quantity && sumOfOne == record.sumOfOne && Objects.equals(itemName, record.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, isExpense, quantity, sumOfOne);
    }


}
