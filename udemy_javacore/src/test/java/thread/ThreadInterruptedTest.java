package thread;


public class ThreadInterruptedTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("Koong");

        //Print some basic information
        System.out.println("Thread ID: " + myThread.getId());
        System.out.println("Thread name: " + myThread.getName());
        //state will be NEW and alive is False when not start the thread
        System.out.println("Thread state: " + myThread.getState());
        System.out.println("Thread active state: " + myThread.isAlive());

        //state will be RUNNABLE when start the thread
        myThread.start();
        System.out.println("Thread state after starting: " + myThread.getState());

        //call the interrupt method, console log will show The Interrupted exception is called which is defined in try catch of MyThread class
        myThread.interrupt();
    }
}
