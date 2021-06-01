package thread;

public class MyThread extends Thread{
    public MyThread(){}
    public MyThread(String threadName){
        super(threadName);
    }
    public void run(){
        int i = 0;
        while (i < 100){
            System.out.println("This is my " + i + " thread!");
            i++;
            try {
                Thread.sleep(100);
                System.out.println("Current thread " + Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception is called!");
            }
        }
    }
}
