package thread;

public class HisRunnable implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(i < 1000){
            System.out.println("His " + i + " runnable!");
            i++;
        }
    }
}
