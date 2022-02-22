package glowny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class Krzyzacy {

    BstTree<String> tree = new BstTree<>();
    String[] allWords;
    HashSet<String> hashSetAll = new HashSet<>();
    String line;
    String[] lineArr;

    public void addWordsIntoArrays(){
        File file = new File("krzyzacy.txt");

        try (BufferedReader breader = new BufferedReader(new FileReader(file))) {

            while( (line = breader.readLine() ) != null )
            {
                lineArr = line.split(" ");

                for(int i = 0; i<lineArr.length; i++)
                    hashSetAll.add(lineArr[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        allWords = new String[hashSetAll.size()];

        int k=0;
        for(String ele:hashSetAll){
            allWords[k++] = ele;
        }

        for(int i=0; i<allWords.length; i++){
            tree.add(allWords[i]);
        }
    }

    public void showAll(){

       for(int i=0; i<allWords.length; i++){
           System.out.println(allWords[i]);
      }

    }


    public void findInArray(String word){

        long nanoActualTime = System.nanoTime();
        boolean found=false;

        for(int i=0; i<allWords.length; i++){
            if(allWords[i].equals(word)) {
                System.out.println("Znaleziono");
                System.out.println("Czas wyszukiwania słowa: " + word + " w tablicy: " + (System.nanoTime() - nanoActualTime));
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Nie znaleziono");
        }
            }

    public void findInTree(String word){

        boolean found=false;
        long nanoActualTime = System.nanoTime();
        found = tree.contains(word);
        if(found) {
            System.out.println("Znaleziono");
            System.out.println("Czas wyszukiwania słowa: " + word + " w drzewie: " + (System.nanoTime() - nanoActualTime));
        }
        else
            System.out.println("Nie znaleziono");
    }

}
