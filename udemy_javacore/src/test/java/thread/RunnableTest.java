package thread;

public class RunnableTest {

    public static void main(String[] args) {
//        myRunnable is not a thread. If a thread is a horse then myRunnable is a box that is tie beside that horse. When horse run, the box is run
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        HisRunnable hisRunnable = new HisRunnable();
        Thread hisThread = new Thread(hisRunnable);
        hisThread.start();
    }
}
