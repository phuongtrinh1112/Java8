package lamda_expressions;

public class PrintSomethingLamdaTest {
    public static void main(String[] args) {
        PrintSomething printSomething = () -> {
                System.out.println("Print something here!");
        };

        printSomething.display();
    }
}
