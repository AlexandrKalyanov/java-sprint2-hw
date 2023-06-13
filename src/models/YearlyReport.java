package models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YearlyReport {
    private final List<YearlyReportRecord> records;

    public YearlyReport(List<YearlyReportRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "records=" + records +
                '}';
    }

    public List<YearlyReportRecord> getRecords() {
        return records;
    }

    public int profitInMonth(int month) {
        Map<String, Integer> sumOfProfitsAndExpense = new HashMap<>();
        for (YearlyReportRecord a : records) {
            if (a.getMonth() == month) {
                if (!a.isExpense()) {
                    sumOfProfitsAndExpense.put("profit", a.getAmount());
                } else {
                    sumOfProfitsAndExpense.put("expense", a.getAmount());
                }
            }
        }
        int profit = sumOfProfitsAndExpense.get("profit");
        int expenses = sumOfProfitsAndExpense.get("expense");
        return profit - expenses;
    }


    public void getInfoProfitInYear(List<MonthlyReport> monthlyReports) {
        System.out.println("Год: " + records.get(0).getYear());
        for (MonthlyReport a : monthlyReports) {
            System.out.println(
                    "Прибыль за " + Months.getMonthName(a.getMonth()) + " месяц равна " + profitInMonth(a.getMonth()) + " руб");
        }

    }

    public int averageExpenseOrProfit(List<MonthlyReport> monthlyReports, boolean isExpense) {
        int sumExpenseOrProfit = 0;
        for (YearlyReportRecord a : records) {
            if (a.isExpense() == isExpense) {
                sumExpenseOrProfit += a.getAmount();
            }
        }
        return sumExpenseOrProfit / monthlyReports.size();

    }
}

