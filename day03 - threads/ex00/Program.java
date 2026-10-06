
// package ex00

class EggThread extends Thread {
    int count;

    public EggThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Egg");
        }
    }
}

class HenThread implements Runnable {
    int count;

    public HenThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hen");
        }
    }
}

public class Program {

    public static void main(String[] args) {
        try {
            int count = Integer.parseInt(args[0].split("=")[1]);

            EggThread egg = new EggThread(count);
            Thread henT = new Thread(new HenThread(count)); // creating threads

            egg.start();
            henT.start();

            egg.join();
            henT.join(); // forcing the main thread to wait for both threads to finish

            for (int i = 0; i < count; i++) {
                System.out.println("Human");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

// oop
// file oi

// 