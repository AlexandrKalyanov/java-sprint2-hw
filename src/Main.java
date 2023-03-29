import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        YearlyReport yReport = new YearlyReport("resources/y.2021.csv");
        MonthlyReport mReport = new MonthlyReport();
        mReport.loadFile("resources/m.202101.csv");
        mReport.loadFile("resources/m.202102.csv");
        mReport.loadFile("resources/m.202103.csv");

        Checker checker = new Checker(yReport,mReport);
        boolean answer =checker.check();
        System.out.println("Результат проверки: " + answer);
        yReport.getInfoForYearReport();
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){

            } else if (command == 2){

            } else if (command == 3){

            } else if (command == 4){

            } else if (command == 5){

            } else if (command == 5){

            } else if (command == 0){
                System.out.println("_____________________________________");
                System.out.println("        Программа завершена          ");
                break;
            }

        }


    }
    public static void printMenu(){
        System.out.println("Ведите номер команды:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");

    }
}

