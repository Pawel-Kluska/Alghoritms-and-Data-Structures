package glowny;

public class Main {

    public enum choose{
        MacierzIncydencji,
        ListaSasiedztwa,
        MacierzSasiedztwa
    }


    public static void main(String[] args) {

        choose c = choose.ListaSasiedztwa;

        Graph<Integer> s = new Graph<>(c);
        s.addNode(2);
        s.addNode(4);
        s.addNode(7);
        s.addNode(9);


        s.addEdge(9, 2);
        s.addEdge(4, 2);
        s.addEdge(4, 9);
        s.addEdge(2, 9);
        s.addEdge(2, 7);
        s.addEdge(7, 2);

        s.show();
        System.out.println(" ");
        s.removeNode(7);
        s.show();
        System.out.println(" ");
        s.removeEdge(2,9);
        s.show();
    }
}
