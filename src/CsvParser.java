import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvParser {

    public static List<List<String>> readRawRecords(String path) {
        List<List<String>> contents = new ArrayList<>();
        List<String> lines = readLines(path);
        for (int i = 1; i < lines.size(); i++) {
            List<String> lineContent = List.of(lines.get(i).split(",")); // lineContent = "01,1593150,false
            contents.add(lineContent);
        }
        return contents;
    }

    private static List<String> readLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}

