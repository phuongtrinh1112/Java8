package thread;

public class SynchonizeTest {

    public static void main(String[] args) {
        SharedData data = new SharedData();
        FirstThread firstThread = new FirstThread(data);
        SecondThread secondThread = new SecondThread(data);

        firstThread.start();
        secondThread.start();
    }
}
