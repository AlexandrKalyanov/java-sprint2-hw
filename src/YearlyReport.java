import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    public ArrayList<Report> reports = new ArrayList<>();

    public YearlyReport(String path){
        List<String> tokens = readFileContents(path);
        for (int i = 1; i < tokens.size(); i++) {
            String[] token = tokens.get(i).split(","); // token = "01,1593150,false
            int month = Integer.parseInt(token[0]);
            int amount = Integer.parseInt(token[1]);
            boolean isExpense = Boolean.parseBoolean(token[2]);
            Report report = new Report(month,amount,isExpense);
            this.reports.add(report);

        }
    }
    void getInfoForYearReport(){ //  метод
        HashMap<Boolean,Integer> yearReport = new HashMap<>();
        for (Report report : reports) {
            yearReport.put(report.isExpense, yearReport.getOrDefault( report.amount,0) + report.amount);
        }
        yearReport.forEach((key, value) -> {
            if (key == true){
                System.out.println("Доходы за год: " + value);
            }else if (key == false) {
                System.out.println("Расходы за год: " + value);
            }
        });
    }
    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

}
