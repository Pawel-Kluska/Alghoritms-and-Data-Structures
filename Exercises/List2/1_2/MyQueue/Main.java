package MyQueue;


public class Main {

    public static void main(String[] args) {

        ArrayQueue<Integer> que = new ArrayQueue<>();

        for (int i = 0; i < 25; i++) {

            que.enqueue(i);
        }

        for (int i = 0; i < 24; i++) {

            try {
                System.out.println(que.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        try {
            que.enqueue(33);
            que.enqueue(44);
            que.enqueue(55);

            System.out.println(que.dequeue());
            System.out.println(que.dequeue());
            System.out.println(que.dequeue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
