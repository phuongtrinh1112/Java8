package thread;

public class HisThread extends Thread{
    public HisThread(){}
    public HisThread(String name){
        super(name);
    }
    public void run(){
        int i = 0;
        while (i < 1000){
            System.out.println("This is his " + i + " thread!");
            i++;
            System.out.println("Current thread " + Thread.currentThread().getName() + " is running");
        }
    }
}
