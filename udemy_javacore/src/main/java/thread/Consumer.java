package thread;

public class Consumer extends Thread{
    InterThreadCommunication data;
    public Consumer(InterThreadCommunication data){
        this.data = data;
    }
    public void run(){
        int count = 0;
        while (count < 10000){
            int number = this.data.get();
            System.out.println("Consumer get " + number);
            count++;
        }
    }
}
