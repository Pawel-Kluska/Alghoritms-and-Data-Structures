package glowny;

public class Main {

    public static void main(String[] args) {
        int[] a = {1,8,2,7,3,7,1,6,4,5,6,8,7,6,5,2,5};
        System.out.println("Kwiaty przestana obumierac w " + Algorithms.Garden(a) + " dniu");

        char[] tab = {'c', 'a', 'b', 'b','d'};
        System.out.println("Najmniejsza dlugosc tablicy " + Algorithms.minLength(tab));
    }
}
