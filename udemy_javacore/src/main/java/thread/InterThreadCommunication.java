package thread;

public class InterThreadCommunication {
    private int baseNumber;
    private boolean flag = false;

    synchronized public void set(int number){
        while (flag != true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.baseNumber = number;
        flag = false;
        notify();
    }

    synchronized public int get(){
        while (flag != false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        notify();
        return this.baseNumber;
    }
}
