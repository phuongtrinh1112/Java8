package thread;

public class SharedData {
//    synchronized is a monitor which allow 1 thread is executed after the other thread is completed. Thread is called and run one by one
    synchronized public void printCharacter(String s){
        for(int i = 0; i < s.length(); i++){
            System.out.print(s.charAt(i) + " ");
        }
    }
}
