import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
        dictionary.put("walk", "ходити");
        dictionary.put("mile", "миля");
        dictionary.put("in", "в");
        dictionary.put("my", "мій");
        dictionary.put("shoes", "черевики");
    }

    public Dictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
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

    public void fillUp() {
        Scanner sc = new Scanner(System.in);
        String entry = "exit";
        while (!entry.equalsIgnoreCase("s")) {
            System.out.println("Please, enter new entry: ");
            System.out.print("Eng: ");
            String eng = sc.next();
            System.out.print("Ukr: ");
            String ukr = sc.next();
            dictionary.put(eng, ukr);
            System.out.println("Add one more entry, press: Y");
            System.out.println("Save updated dictionary, press: S");
            entry = sc.next();
        }
    }

    public String sort() {
        StringBuilder dictionarySorted = new StringBuilder();
        Set<Map.Entry<String, String>> set = dictionary.entrySet();
        for(Map.Entry<String, String> s : set) {
            dictionarySorted.append(s.getKey()).append(": " + "\t").append(s.getValue()).append("\n");
        }
        return dictionarySorted.toString();
    }

    public void save() {
        String dictionaryToSave = sort();
        try (PrintWriter pw = new PrintWriter("/Users/ac/IdeaProjects/Translater/src/Dictionary.txt")){
            pw.println(dictionaryToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dictionary saved in Dictionary.txt ");

    }

    @Override
    public String toString() {
        return "Dictionary:\n" + sort();
    }
}
