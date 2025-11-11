package iostream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagCounter {
    public static Map<String, Integer> countTags(String urlString) throws Exception {
        Map<String, Integer> tagFrequencies = new HashMap<>();
        URL url = new URL(urlString);
        Pattern tagPattern = Pattern.compile("<([a-zA-Z0-9]+)");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = tagPattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(1).toLowerCase();
                    tagFrequencies.put(tag, tagFrequencies.getOrDefault(tag, 0) + 1);
                }
            }
        }
        return tagFrequencies;
    }
}