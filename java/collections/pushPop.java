import java.util.ArrayList;
import java.util.List;

class practice {
    private List<Integer> list = new ArrayList<>();
    private final static int capacity = 3;
    public static void main(String args[]) {
        practice practice = new practice();

        Runnable r1 = () -> {
            for (int x = 0; x <= capacity; x++) {//0<=3t,1<=3t,2<=3t,3<=3t
                practice.push(x);//0 1 2 
            }
        };

        Runnable r2 = () -> {
            for (int x = 0; x <= capacity; x++) {
                practice.pop();
            }
        };

        Thread t1 = new Thread(r1, "One");
        Thread t2 = new Thread(r2, "Two");

        t1.start();
        t2.start();
    }

    public synchronized void push(int addItem) {
        while (list.size() == capacity) {//0==3f,1==3f,2==3f,3==3t
            try {
                System.out.println("Push waiting, list is full: " + list);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        list.add(addItem);//0 1 2
        System.out.println("Pushed Item: " + addItem);//0 1 2
        notify();
    }

    public synchronized void pop() {
        while (list.size() == 0) {//3==0f,2==0f,1==0f,0==0t
            try {
                System.out.println("Pop waiting, list is empty: " + list);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int removedItem = list.remove(0);//0 1 2
        System.out.println("Popped Item: " + removedItem);
        notify();
    }
}
