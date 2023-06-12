import models.MonthlyReport;
import models.YearlyReport;
import models.YearlyReportRecord;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        YearlyReport yearlyReport = null;
        List<MonthlyReport> monthlyReports = null;

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReports = readMonthReports();
                System.out.println("Месячные отчеты считаны");
                System.out.println("_____________________________________");

            } else if (command == 2) {
                yearlyReport = readYearReport();
                System.out.println("Годовой отчет считан");
                System.out.println("_____________________________________");
            } else if (command == 3) {
                if (yearlyReport != null && monthlyReports != null
                        && !monthlyReports.isEmpty()) {
                    checkReports(yearlyReport, monthlyReports);
                } else {
                    System.out.println("Cначала необходимо считать отчеты");
                }

            } else if (command == 4) {
                if (monthlyReports == null) {
                    System.out.println("Необходимо сначала считать месячные отчеты");
                } else {

                    for (final var report : monthlyReports) {
                        System.out.println("За " + report.getMonth() + " месяц.");

                        report.informMonthlyReport();
                    }
                }
            } else if (command == 5) {
                if (yearlyReport != null) {
                    yearlyReport.getInfoProfitInYear(monthlyReports, yearlyReport);
                    System.out.println("Cредний расход за все имеющиеся операции в году: " + yearlyReport.averageExpenseOrProfit(monthlyReports, true));
                    System.out.println("Cредний доход за все имеющиеся операции в году: " + yearlyReport.averageExpenseOrProfit(monthlyReports, false));
                } else {
                    System.out.println("Необходимо сначала считать годовой отчет");
                }
            } else if (command == 0) {
                System.out.println("_____________________________________");
                System.out.println("        Программа завершена          ");
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Ведите номер команды:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }

    private static YearlyReport readYearReport() {
        String path = "resources/y.2021.csv";
        List<List<String>> rawYearReportRecords = CsvParser.readRawRecords(path);
        int year = Integer.parseInt(path.substring(12, 16));
        return ReportCreator.createYearlyReport(rawYearReportRecords, year);
    }

    private static List<MonthlyReport> readMonthReports() {
        List<MonthlyReport> monthlyReports = new ArrayList<>();

        List<String> monthReportPaths = Arrays.asList("resources/m.202101.csv", "resources/m.202102.csv", "resources/m.202103.csv");
        for (String path : monthReportPaths) {
            int month = Integer.parseInt(path.substring(16, 18));
            List<List<String>> rawRecords = CsvParser.readRawRecords(path);
            MonthlyReport monthlyReport = ReportCreator.createMonthlyReport(rawRecords, month);
            monthlyReports.add(monthlyReport);
        }
        return monthlyReports;
    }

    private static void checkReports(YearlyReport yearReport,
                                     List<MonthlyReport> monthlyReports) {

        List<YearlyReportRecord> yearlyReportRecords = yearReport.getRecords();

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
    }

    private static void printReport(int month, int sumInMonthReport, int sumInYearReport, String incomeOrExpense) {
        System.out.println(incomeOrExpense + " за месяц: " + month);
        System.out.println(incomeOrExpense + " за месяц: " + sumInMonthReport);
        System.out.println(incomeOrExpense + " за месяц " + "в годовом отчете: " + sumInYearReport);
        System.out.println("Доход за " + month + " месяц соответствует годовому отчету");
        System.out.println(" ");
    }
}






