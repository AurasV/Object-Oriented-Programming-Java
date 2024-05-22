import java.util.Date;

class TimeTelling extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println("Current time in seconds: " + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Ex1a {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TimeTelling().start();
        }
    }
}
