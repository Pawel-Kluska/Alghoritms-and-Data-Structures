package glowny;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        RedBlackTree<String, String> t = new RedBlackTree<>(c);

        t.add("rr", "z"); //6
        t.add("kk", "d"); //1
        t.add("hh", "n"); //4
        t.add("gg", "f"); //2
        t.add("ff", "g"); //3
        t.add("dd", "h"); //4

        t.InOrderWalk();
        System.out.println(" ");

        t.remove("z");
        t.remove("n");
        t.remove("h");

        t.InOrderWalk();
        t.getPercentage();




        Dictionary d = new Dictionary();
        d.writeIntoTree();
        d.show();
        d.percentage();
        String[] s = d.search("biesiekierski");

        for(int i=0; i<s.length; i++){
            System.out.println(s[i]);
        }


    }

}
