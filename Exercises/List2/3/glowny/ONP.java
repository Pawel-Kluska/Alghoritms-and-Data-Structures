package glowny;

import Stack.ArrayStack;
import Stack.EmptyStackException;
import Stack.IStack;

public class ONP {

    public static double calculateONP(String[] tab) throws EmptyStackException{

        IStack<Double> stack = new ArrayStack<>();

        for(int i=0; i<tab.length; i++) {

            if (isNumeric(tab[i])) {
                stack.push(Double.parseDouble(tab[i]));

            }

            if (isOperator(tab[i])) {

                double a=stack.pop();
                double b=stack.pop();

                if (tab[i].equals("+")) {
                    stack.push(b+a);
                }
                else if (tab[i].equals("-")) {
                    stack.push(b-a);
                }
                else if (tab[i].equals("*")) {
                    stack.push(b*a);
                }
                else if (tab[i].equals("/")) {
                    stack.push(b/a);
                }
            }

        }
        return stack.pop();

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isOperator(String str) {

        return str.equals("+")|| str.equals("-")|| str.equals("*")|| str.equals("/");
    }

}
