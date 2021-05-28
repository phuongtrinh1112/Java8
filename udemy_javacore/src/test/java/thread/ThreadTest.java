package thread;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        HisThread hisThread = new HisThread();
        hisThread.start();
    }
}
