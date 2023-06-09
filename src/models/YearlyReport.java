package models;


import java.util.List;

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
    public void
}
