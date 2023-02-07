import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
        dictionary.put("walk", "ходити");
        dictionary.put("mile", "миля");
        dictionary.put("in", "в");
        dictionary.put("my", "мій");
        dictionary.put("shoes", "черевики");
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void translate(String[] readInput) {
        String translation = "";

        for (String it: readInput) {
            translation += dictionary.get(it) + " ";
        }

        try (PrintWriter pw = new PrintWriter("/Users/ac/IdeaProjects/Translater/src/UkrainianOut.txt")){
            pw.println(translation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Translation saved in UkrainianOut.txt ");
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}
