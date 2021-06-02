package thread;

public class InterThreadCommunicationTest {
    public static void main(String[] args) {
        InterThreadCommunication data = new InterThreadCommunication();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        producer.start();
        consumer.start();
    }
}
