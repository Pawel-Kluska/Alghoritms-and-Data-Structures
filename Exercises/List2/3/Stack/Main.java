package Stack;

public class Main {

    public static void main (String[] args){

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i=0; i<25; i++){

            stack.push(i);
        }

        for(int i=0; i<23; i++){

            try {
                System.out.println(stack.pop());
            } catch (EmptyStackException e) {
                e.printStackTrace();
            }
        }

            try {
                stack.push(33);
                stack.push(44);
                stack.push(55);

                System.out.println(stack.pop());
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }



    }
}
