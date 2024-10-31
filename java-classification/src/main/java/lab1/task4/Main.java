package lab1.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add("java-classification/src/main/java/lab1/resources/test.txt");
        filePaths.add("java-classification/src/main/java/lab1/resources/test1.txt");
        filePaths.add("java-classification/src/main/java/lab1/resources/test2.txt");
        
        FileReader reader = new FileReader();
        List<TextData> analyses = new ArrayList<>();
        
        // analyze each file
        for (String path : filePaths) {
            String text = reader.readFileIntoString(path);
            if (!text.isEmpty()) {
                // extract filename from path for display
                String fileName = path.substring(path.lastIndexOf('/') + 1);
                analyses.add(new TextData(fileName, text));
            }
        }
        
        System.out.println("Analysis Results for All Files:");
        for (TextData analysis : analyses) {
            System.out.println(analysis);
            System.out.println("------------------------------");
        }
    }
}