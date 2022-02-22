package glowny;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Algorithms {

    public static int Garden(int[] tab2){
        int days=0;
        ArrayList<Integer> tab = getArray(tab2);
        Stack<Integer> stack = new Stack<>();
        int left;
        int right;
        boolean changed;

        do {
            changed = false;
            for (int i = tab.size() - 1; i > 0; i--) {
                left = tab.get(i - 1);
                right = tab.get(i);
                if (left < right) {
                    tab.remove(i);
                    changed = true;
                } else
                    stack.push(right);
            }
            stack.push(tab.get(0));
            days++;
            tab = new ArrayList<>();
            while(!stack.empty()) {
                tab.add(stack.pop());
            }
        } while(changed);
        return days;
    }

    private static ArrayList getArray(int[] a){
        ArrayList<Integer> intList = new ArrayList<>(a.length);
        for (int i : a)
            intList.add(i);
        return intList;
    }

    public static int minLength(char[] tab){
        int min = tab.length;
        boolean minLength = false;
        HashSet<Character> hashSet = new HashSet<>();
        ArrayList<Character> arrayList = new ArrayList<>();

        for(int i=0;i< tab.length;i++){
            hashSet.add(tab[i]);
            arrayList.add(tab[i]);
        }

        while(!minLength){
            minLength = true;
            loop:
            for(int i=0,j=1;j<arrayList.size();i++,j++){
                int x = Character.compare(arrayList.get(i),arrayList.get(j));
                if(x != 0){
                    if(hashSet.size()>2){
                        min -= 1;
                        for(Character c : hashSet){
                            if(c != arrayList.get(i) && c != arrayList.get(j)){
                                arrayList.set(i,c);
                                arrayList.remove(j);
                                minLength = false;
                                break loop;
                            }
                        }
                    }else{
                        minLength = true;
                        break loop;
                    }
                }
            }
            if(arrayList.size()==1){
                minLength = true;
            }
        }
        return min;
    }

}
