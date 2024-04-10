import java.util.Date;

class TimeTelling2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Current time in seconds: " + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Ex1b {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new TimeTelling2()).start();
        }
    }
}
