package glowny;

import Stack.EmptyStackException;


public class Main {

    public static void main(String[] args) {

        // Dla ((2+7)/3+(14-3)*4)
        String[] tab = {"2","7","+","3","/","14","3","-","4","*","+"};
        double result = 0;
        try {
             result = ONP.calculateONP(tab);
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
