package thread;

public class Producer extends Thread{
    InterThreadCommunication data;
    public Producer(InterThreadCommunication data){
        this.data = data;
    }
    public void run(){
        int count = 0;
        while(count < 10000)
        {
            this.data.set(count);
            System.out.println("Producer set " + count);
            count++;
        }

    }
}
