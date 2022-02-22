package glowny;

public class Main {

    public static void main(String[] args) {

        OneWayLinkedList<Integer> list = new OneWayLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(1,4);
        list.add(7);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        list.remove(0);
        list.remove(new Integer(7));


        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
