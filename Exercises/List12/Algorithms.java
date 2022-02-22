package glowny;

import java.util.Arrays;

public class Algorithms {

    static int getNumberOfWays(int N, int[] Coins)
    {

        int[] ways = new int[N + 1];

        ways[0] = 1;

        for (int i = 0; i < Coins.length; i++) {

            for (int j = 0; j < ways.length; j++) {
                if (Coins[i] <= j) {

                    ways[j] += ways[(j - Coins[i])];
                }
            }
        }
        return ways[N];
    }

    static int getTab(int l, int[]  T){

        Arrays.sort(T);
        int[] R = new int[l];

        int minInd = 0;
        int maxInd = l-1;
        int bestSub= Integer.MAX_VALUE;
        int Sub;

        while(maxInd < T.length){
            for(int i=0; i<l; i++){
                R[i] = T[i+minInd];
            }
            Sub = R[R.length-1] - R[0];

            if(bestSub> Sub){
                bestSub = Sub;
            }
            minInd++;
            maxInd++;
        }
        return bestSub;
    }
}
