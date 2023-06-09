import models.MonthlyReport;
import models.MonthlyReportRecord;
import models.YearlyReport;
import models.YearlyReportRecord;

import java.util.ArrayList;
import java.util.List;

public class ReportCreator {

    public static YearlyReport createYearlyReport(List<List<String>> rawRecords) {
        List<YearlyReportRecord> records = new ArrayList<>();
        for (List<String> rawRecord : rawRecords) {
            int month = Integer.parseInt(rawRecord.get(0));
            int amount = Integer.parseInt(rawRecord.get(1));
            boolean isExpense = Boolean.parseBoolean(rawRecord.get(2));
            YearlyReportRecord record = new YearlyReportRecord(month, amount, isExpense);
            records.add(record);
        }
        return new YearlyReport(records);
    }

    public static MonthlyReport createMonthlyReport(List<List<String>> rawRecords, int month) {
        List<MonthlyReportRecord> records = new ArrayList<>();
        for (List<String> rawRecord: rawRecords){
            String itemName = rawRecord.get(0);
            boolean isExpens = Boolean.parseBoolean(rawRecord.get(1));
            int quantity = Integer.parseInt(rawRecord.get(2));
            int sumOfOne = Integer.parseInt(rawRecord.get(3));
            MonthlyReportRecord record = new MonthlyReportRecord(itemName,isExpens,quantity,sumOfOne);
            records.add(record);
        }
        return new MonthlyReport(records,month);
    }
}
