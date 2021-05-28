package thread;

public class MyRunnable implements Runnable{
//    Runnable interface is the primary template for any object that is intended to be executed by a thread
    @Override
    public void run() {
        int i = 0;
        while(i < 1000){
            System.out.println("My " + i + " runnable!");
            i++;
        }
    }
}
