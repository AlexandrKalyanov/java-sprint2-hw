import models.Months;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportExecutor reportExecutor = new ReportExecutor();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                reportExecutor.readMonthReports();


            } else if (command == 2) {
                reportExecutor.readYearReport();

            } else if (command == 3) {
                    reportExecutor.checkReports();

            } else if (command == 4) {
                reportExecutor.informMonth();

            } else if (command == 5) {
                reportExecutor.informYear();

            } else if (command == 0) {
                System.out.println("_____________________________________");
                System.out.println("        Программа завершена          ");
                break;
            }
        }
    }
    private static void printMenu() {
        System.out.println(" ");
        System.out.println("Ведите номер команды:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}






