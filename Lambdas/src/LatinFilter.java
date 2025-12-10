import java.util.Arrays;
import java.util.regex.Pattern;

public class LatinFilter {
    public static void main(String[] args) {
        String text = "Hello World! Code is working, maybe, I hope. Якісь слова, сова соva Auto, 1234, data, привіт.";

        System.out.println("Вхідний рядок: " + text);

        String[] result = find(text);

        System.out.println("Результат: " + Arrays.toString(result));
    }

    public static String[] find(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        return Arrays.stream(text.split("[^a-zA-Z0-9а-яА-Яіїєґ]+"))
                .filter(word -> Pattern.matches("^[a-zA-Z]+$", word))
                .filter(word -> isBalanced(word))
                .toArray(String[]::new);
    }

    private static boolean isBalanced(String word) {
        long vowelsCount = countVowels(word);
        long consonantsCount = word.length() - vowelsCount;

        return vowelsCount == consonantsCount;
    }

    private static long countVowels(String word) {
        String vowels = "aeiouAEIOU";

        return word.chars()
                .filter(c -> vowels.indexOf(c) != -1)
                .count();
    }
}
