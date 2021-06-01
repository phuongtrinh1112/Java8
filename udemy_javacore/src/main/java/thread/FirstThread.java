package thread;

public class FirstThread extends Thread{
    SharedData firstData;
    public FirstThread(SharedData data){
        this.firstData = data;
    }
    public void run(){
        this.firstData.printCharacter("Hello World");
    }
}
