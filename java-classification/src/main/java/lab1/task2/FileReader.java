package lab1.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    // read file from known path
    public String readFileIntoString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("error reading file: " + e.getMessage());
            return "";
        }
    }
}