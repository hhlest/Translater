public class Main {

    public static void main(String[] args) {
        Dictionary myDictionary = new Dictionary();
        myDictionary.translate(Input.readFile());
        System.out.println(myDictionary);

        myDictionary.fillUp();
        System.out.println(myDictionary);
        myDictionary.save();

    }
}
