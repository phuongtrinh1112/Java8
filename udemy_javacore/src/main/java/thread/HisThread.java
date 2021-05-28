package thread;

public class HisThread extends Thread{
    public void run(){
        int i = 0;
        while (i < 1000){
            System.out.println("This is his " + i + " thread!");
            i++;
        }
    }
}
