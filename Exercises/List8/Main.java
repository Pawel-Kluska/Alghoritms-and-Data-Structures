package glowny;


public class Main {

    public static void main(String[] args) {

      Krzyzacy k = new Krzyzacy();
      k.addWordsIntoArrays();

      k.findInArray("chcieli");
      k.findInTree("chcieli");

   /*  BstTree<Integer> tree = new BstTree<>();

      tree.add(5);
      tree.add(3);
      tree.add(9);
      tree.add(0);
      tree.add(4);
      tree.add(5);

      tree.InOrderWalk();

      tree.remove(9);
      tree.remove(0);

      tree.InOrderWalk();
        System.out.println(tree.contains(5));

    */


    }
}
