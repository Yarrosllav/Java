package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineReader{
    public static String findLine(String filePath) throws IOException {
        String lineWithMostWords = null;
        int maxWordCount = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.trim().isEmpty()) continue;
                String[] words = currentLine.trim().split("\\s+");
                if (words.length > maxWordCount) {
                    maxWordCount = words.length;
                    lineWithMostWords = currentLine;
                }
            }
        }
        return lineWithMostWords;
    }
}
