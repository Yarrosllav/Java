
import java.util.*;

public class SimpleTask {

    public static void main(String[] args) {

        String message = "JavA zwei vier test123 lane! Чай Sky Zoo ABCD";

        System.out.println("Latin words with equal vowels and consonants - " + Arrays.toString(isLatinAndEqual(message)));

    }

    static String[] isLatinAndEqual(String sentence){

        String[] words = sentence.split(" ");

        List<String> latins = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(String word: words){
            if (charsCheck(word)){
                latins.add(word);
            }
        }

        for(String word: latins){
            if (vowelCheck(word)){
                result.add(word);
            }
        }

        return result.toArray(new String[0]);


    }

    static boolean charsCheck(String word){
        for(char ch: word.toCharArray()){
            if(!((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z'))){
                return false;
            }
        }
        return true;
    }

    static boolean vowelCheck(String word) {

        Set<Character> vowels = new HashSet<>(Set.of('a','e','i','o','u'));

        int v = 0;
        int c = 0;

        for (char ch: word.toCharArray()){
            if(vowels.contains(Character.toLowerCase(ch))){
                v++;
            }else{
                c++;
            }
        }

        return v == c;

    }

}