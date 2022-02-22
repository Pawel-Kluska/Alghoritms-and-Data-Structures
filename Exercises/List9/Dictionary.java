package glowny;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Dictionary {

    Map<String, String[]> map;
    RedBlackTree<String, String[]> tree;
    Comparator<String> com;

    public Dictionary() {

        try {
            map = Files.readAllLines(Paths.get("odmiany.txt"), Charset.defaultCharset())
                    .stream()
                    .collect(Collectors.toMap(
                            (s) -> s.split(",")[0].trim(),
                            (s) -> Arrays.stream(s.split(",")).skip(1).map((s2) ->
                                    s2.trim()).toArray(String[]::new),
                            (oldValue, newValue) -> oldValue)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }

        com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        tree = new RedBlackTree<>(com);
    }

    public void writeIntoTree(){
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            tree.add(entry.getValue(), entry.getKey());
            }
        }

        public String[] search(String key){
            String[] tab = tree.getValue(key);
            if(tab!=null) {
                System.out.println("Znaleziono");
                return tab;
            }
            else
                throw new NoSuchElementException();
        }

        public void show(){

        tree.InOrderWalk();
        }

        public void percentage(){
        tree.getPercentage();
        }

    }