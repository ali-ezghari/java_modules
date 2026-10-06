
// package ex00

class Th extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}

public class Program {

    public static void main(String[] args) {
        Th t1 = new Th();

        t1.start();
    }
}
