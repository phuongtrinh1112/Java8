package exception_handling;

import java.util.Scanner;

public class AreaCalculation {
    public static int enterNumber(){
        Scanner sc = new Scanner(System.in);
        int number;
        while (true){
            System.out.println("Enter a number: ");
            String enterValue = sc.next();
            try {
                int enteredData = Integer.parseInt(enterValue);
                if (enteredData < 0) throw new NegativeNumberException("Can not enter a negative number");
                number = enteredData;
                break;
            } catch (NegativeNumberException e) {
                e.toString();
            } catch (NumberFormatException e){
                System.out.println("Need enter a number!");
            }
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println((enterNumber() * enterNumber()));
    }
}
