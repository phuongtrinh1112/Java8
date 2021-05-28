package thread;

public class MyThread extends Thread{
    public void run(){
        int i = 0;
        while (i < 1000){
            System.out.println("This is my " + i + " thread!");
            i++;
        }
    }
}
