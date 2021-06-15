package lamda_expressions;

public class PrintSomethingWithParametersLamdaTest {
    public static void main(String[] args) {
        PrintSomethingWithParameters printSomethingWithParameters = (number1, number2) -> {
            System.out.println(number1 + number2);
        };

        printSomethingWithParameters.printSum(11, 12);
    }
}
