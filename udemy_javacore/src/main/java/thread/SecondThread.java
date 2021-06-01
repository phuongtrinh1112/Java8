package thread;

public class SecondThread extends Thread{
    SharedData secondData;
    public SecondThread(SharedData data){
        this.secondData = data;
    }
    public void run(){
        this.secondData.printCharacter("PHUONG");
    }
}
