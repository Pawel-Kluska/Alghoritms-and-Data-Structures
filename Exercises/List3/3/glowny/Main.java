package glowny;

import LinkedLists.IList;
import LinkedLists.Iterator;
import LinkedLists.OneWayLinkedList;
import LinkedLists.TwoWayCycledList;

public class Main {

    public static void main(String[] args) {

        OneWayLinkedList<Integer> on = new OneWayLinkedList<>();
        TwoWayCycledList<Integer> tw = new TwoWayCycledList<>();

     /*   for(int i=0; i<10; i++){
            on.add(i);
            tw.add(i);
        }

        Iterator it = on.iterator();
        System.out.println(it.next());
        System.out.println(it.remove());

        it = on.iterator();

        for(; it.hasNext();){
            System.out.println(it.next());
        }
*/
        System.out.println(hasCycle(on));
        System.out.println(hasCycle(tw));

    }

    public static <E> boolean hasCycle(IList<E> list) {

        Iterator<E> it = list.iterator();
        if (list.size() > 0) {
            E value1 = list.get(0);
            while (it.hasNext()) {
                it.next();
            }
            try {
                if (it.next() == value1) return true;
                if (it.next() == value1) return true;
            } catch (NullPointerException e) {
                return false;
            }
            return false;
        }
    else{
        try{
            it.next();
            return true;
        }
        catch(NullPointerException e){
            return false;
            }
      }
    }
}
