package thread;

public class ThreadJoiningTest {
    //when calling 2 threads, it will executed both thread until both are completed
    //use join to wait first thread to be completed then second thread is call
    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        HisThread hisThread = new HisThread("HisThread");

        myThread.start();
        try {
            System.out.println("Current thread " + Thread.currentThread().getName() + " is running");
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hisThread.start();
    }
}
