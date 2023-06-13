import models.MonthlyReport;
import models.Months;
import models.YearlyReport;
import models.YearlyReportRecord;

import java.util.ArrayList;
import java.util.List;

public class ReportExecutor {
    YearlyReport yearlyReport;
    List<MonthlyReport> monthlyReports;
    public void readYearReport() {
        String path = "resources/y.2021.csv";
        List<List<String>> rawYearReportRecords = CsvParser.readRawRecords(path);
        int year = Integer.parseInt(path.substring(12, 16));
        this.yearlyReport = ReportCreator.createYearlyReport(rawYearReportRecords, year);
        System.out.println("Годовой отчет считан");
        System.out.println("_____________________________________");
    }
    public void readMonthReports() {
        List<MonthlyReport> monthlyReports = new ArrayList<>();
        List<String> monthReportPaths = new ArrayList<>(2);
        final int countMonths = 3; // кол-во месячных отчетов
        for (int i = 1; i <= countMonths; i++){
            if (i < 10) {
            monthReportPaths.add("resources/m.20210" + i + ".csv");
            } else monthReportPaths.add("resources/m.2021" + i + ".csv");
        }
        for (String path : monthReportPaths) {
            int month = Integer.parseInt(path.substring(16, 18));
            List<List<String>> rawRecords = CsvParser.readRawRecords(path);
            MonthlyReport monthlyReport = ReportCreator.createMonthlyReport(rawRecords, month);
            monthlyReports.add(monthlyReport);
        }
        this.monthlyReports = monthlyReports;
        System.out.println("Месячные отчеты считаны");
        System.out.println("_____________________________________");
    }
    public void checkReports() {
        if (yearlyReport != null && monthlyReports != null
                && !monthlyReports.isEmpty() && !yearlyReport.getRecords().isEmpty()) {
            List<YearlyReportRecord> yearlyReportRecords = yearlyReport.getRecords();
            for (YearlyReportRecord b : yearlyReportRecords) {
                boolean isExpense = b.isExpense();
                int monthInYear = b.getMonth();
                int income = monthlyReports.get(monthInYear - 1).getTotalIncome();
                int sumInYear = b.getAmount();
                int expense = monthlyReports.get(monthInYear - 1).getTotalExpense();
                if (monthlyReports.get(monthInYear - 1).getMonth() == monthInYear && !isExpense) {
                    if (b.getAmount() == monthlyReports.get(monthInYear - 1).getTotalIncome()) {
                        printReport(monthInYear, income, sumInYear, "Доход");
                    } else {
                        System.out.println("В отчете по доходам за " + monthInYear + " месяц ОШИБКА");
                        System.out.println(" ");
                    }
                } else {
                    if (b.getAmount() == monthlyReports.get(monthInYear - 1).getTotalExpense()) {
                        printReport(monthInYear, expense, sumInYear, "Расход");
                    } else {
                        System.out.println("В отчете по расходам за " + monthInYear + " месяц ОШИБКА");
                        System.out.println(" ");
                    }
                }
            }
        } else  System.out.println("Cначала необходимо считать отчеты");
    }
    public void informMonth(){
        if (monthlyReports == null) {
            System.out.println("Необходимо сначала считать месячные отчеты");
        } else {
            for (final var report : monthlyReports) {
                System.out.println("За " + Months.getMonthName(report.getMonth()) + " месяц.");
                report.informMonthlyReport();
                System.out.println(" ");
            }
        }
    }
    public void informYear(){
        if (yearlyReport != null) {
            yearlyReport.getInfoProfitInYear(monthlyReports);
            System.out.println("Cредний расход за все имеющиеся операции в году: " + yearlyReport.averageExpenseOrProfit(monthlyReports, true) + " руб");
            System.out.println("Cредний доход за все имеющиеся операции в году: " + yearlyReport.averageExpenseOrProfit(monthlyReports, false) + " руб");
        } else {
            System.out.println("Необходимо сначала считать годовой отчет");
        }
    }
    public void printReport(int month, int sumInMonthReport, int sumInYearReport, String incomeOrExpense) {
        System.out.println(incomeOrExpense + " за месяц: " + Months.getMonthName(month));
        System.out.println(incomeOrExpense + " за месяц: " + sumInMonthReport + " руб");
        System.out.println(incomeOrExpense + " за месяц " + "в годовом отчете: " + sumInYearReport + " руб");
        System.out.println("Доход за " + Months.getMonthName(month) + " соответствует годовому отчету");
        System.out.println(" ");
    }
}
