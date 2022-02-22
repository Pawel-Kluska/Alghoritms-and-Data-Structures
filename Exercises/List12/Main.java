package glowny;

import static glowny.Algorithms.getNumberOfWays;
import static glowny.Algorithms.getTab;

public class Main {

    public static void main(String[] args) {
        int arr[] = {1, 2,5};
        int n = 20;
        System.out.println(getNumberOfWays(n, arr));

        int arr2[] = {1, 4, 7, 2};
        int l = 2;
        System.out.println(getTab(l, arr2));
    }
}
