package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MonthlyReport {

    private final List<MonthlyReportRecord> records;
    private final int totalIncome;
    private final int totalExpense;
    private final int month;

    public MonthlyReport(List<MonthlyReportRecord> records, int month) {
        this.month = month;
        this.records = records;
        this.totalIncome = countExpensesOrIncome(false);
        this.totalExpense = countExpensesOrIncome(true);
    }

    private void findMaxPrice(HashMap<String, Integer> sumExpenses, String text) {
        Map.Entry<String, Integer> maxPriceForSum = null;
        for (Map.Entry<String, Integer> price : sumExpenses.entrySet()) {
            if (maxPriceForSum == null || price.getValue().compareTo(maxPriceForSum.getValue()) > 0) {
                maxPriceForSum = price;
            }
        }
        System.out.println(text + maxPriceForSum.getKey() + ". Cумма: " + maxPriceForSum.getValue() + " руб.");
    }

    public void informMonthlyReport() {
        HashMap<String, Integer> sumExpenses = new HashMap<>();
        HashMap<String, Integer> sumProfits = new HashMap<>();
        for (MonthlyReportRecord a : records) {
            String name = a.getItemName();
            int sum = a.getQuantity() * a.getSumOfOne();
            if (a.isExpense()) {
                sumExpenses.put(name, sum);
            } else sumProfits.put(name, sum);

        }
        findMaxPrice(sumExpenses, "Самая большая трата: ");
        findMaxPrice(sumProfits, "Самый прибыльный товар: ");

    }

    private int countExpensesOrIncome(boolean isExpense) {
        int sumExpenseOrProfits = 0;
        for (MonthlyReportRecord a : records) {
            if (a.isExpense() == isExpense) {
                int sumOnePosition = a.getQuantity() * a.getSumOfOne();
                sumExpenseOrProfits += sumOnePosition;
            }
        }
        return sumExpenseOrProfits;
    }


    public int getTotalIncome() {
        return totalIncome;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "records=" + records +
                '}';
    }
}


