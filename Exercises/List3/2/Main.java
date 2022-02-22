package glowny;

public class Main {

    public static void main(String[] args) {

        TwoWayCycledList<String> list = new TwoWayCycledList<>();
        list.add("test1");
        list.add("test2");
        list.add(0,"test3");
        list.add(2,"test4");
        list.add(0,"test5");

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        list.remove(0);
        list.remove("test4");

        System.out.println();

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());

        }

        it.last();
        System.out.println();

     while(it.hasPrevious()){
         System.out.println(it.previous());
       }


    }
}
