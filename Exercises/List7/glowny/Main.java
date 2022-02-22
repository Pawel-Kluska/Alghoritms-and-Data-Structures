package glowny;

public class Main {

    public static void main(String[] args) {

        HashTable<String> hash = new HashTable<>();

       /* hash.add("test1");
        hash.add("test2");
        hash.add("test3");
        hash.showArray();
        hash.remove("test2");
        hash.showArray();
*/

        String word1 = "Test";
        String word2 = "Testt";

        CheckLetters c = new CheckLetters();
        c.checkWords(word1, word2);
    }
}
