import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Report {
    MonthlyReport monthlyReport1 = new MonthlyReport();

   /* public yearlyReport(String path){
        String content = readFileContent(path);
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            Report report = new Report(month,amount,isExpense);
            reports.add(report);

        }
    }
    public String readFileContent(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return null;
        }
    }
*/
}
