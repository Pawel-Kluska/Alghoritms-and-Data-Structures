package glowny;


public class CheckLetters {

    HashTable<String> tab2;
    HashTable<String> tab1;
    String[] s1;
    String[] s2;

    public CheckLetters() {
        tab2 = new HashTable<>();
        tab1 = new HashTable<>();
    }

    public void writeIntoHashArray(String w1, String w2){

      s2 = w2.split("");
      s1 = w1.split("");

        for(int i=0; i<s2.length; i++){
            tab2.add(s2[i]);
        }
        for(int i=0; i<s1.length; i++){
            tab1.add(s1[i]);
        }
    }

    public void checkWords(String w1, String w2){

        writeIntoHashArray(w1, w2);
        boolean s1Has=true;
        boolean s2Has=true;

        for(int i=0; i<s1.length; i++) {

            if (!tab2.contains(s1[i])) {
                s1Has=false;
            }
        }

        for(int i=0; i<s2.length; i++) {
            if(!tab1.contains(s2[i])){
              s2Has=false;
            }
        }

        if(s1Has && s2Has)
        System.out.println("Slowa skladaja sie z tych samych liter");

        else if(s1Has)
            System.out.println("Wszystkie litery ze slowa 1 sa rowniez w slowie 2");
        else if(s2Has)
            System.out.println("Wszystkie litery ze slowa 2 sa rowniez w slowie 1");
        else
            System.out.println("Slowa skladaja sie z roznych zbiorow liter");
    }

}
