import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {

    public static String[] readFile() {
        String str = "";
        String[] line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ac/IdeaProjects/Translater/src/EnglishIn.txt"))) {
            while((str = br.readLine()) != null) {
                line = str.split(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
