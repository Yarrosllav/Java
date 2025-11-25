import java.util.HashMap;
import java.util.Map;

class Translator {
    private final Map<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }


    public void addWord(String english, String ukrainian) {
        if (english != null && ukrainian != null) {
            dictionary.put(english.trim().toLowerCase(), ukrainian.trim().toLowerCase());
        }
    }

    public String translate(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }

        String[] words = phrase.split("\\s+");
        StringBuilder translatedSentence = new StringBuilder();
        boolean comma = false;

        for (String word : words) {
            if(word.contains(",")){
                comma = true;
            }
            String searchKey = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            String translatedWord = dictionary.get(searchKey);

            if (translatedWord != null) {
                if(comma) {
                    translatedSentence.append(translatedWord).append(",");
                }else{
                    translatedSentence.append(translatedWord).append(" ");
                }
            } else {
                if(comma) {
                    translatedSentence.append("[").append(searchKey).append("]").append(",");
                }else{
                    translatedSentence.append("[").append(searchKey).append("]").append(" ");
                }
            }
            comma = false;
        }

        return translatedSentence.toString().trim();
    }
}