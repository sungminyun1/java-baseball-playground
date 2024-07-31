import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    public int result = 0;
    public String operation = "";

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        int result = calculator.calculate(scanner.nextLine());
        System.out.println(result);
    }

    public int calculate(String input) {
        String[] parsed = input.split(" ");
        for(String token : parsed){
            evaluate(token);
        }

        return result;
    }

    public void evaluate(String input) {
        if(isOperator(input)){
            setOperation(input);
            return;
        }

        calcNum(Integer.parseInt(input));
    }

    public boolean isOperator(String token) {
        return Arrays.asList("+", "-", "*", "/").contains(token);
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void calcNum(int num){
        if(isFirst()){
            result = num;
            return;
        }

        if(operation.equals("+")){
            result += num;
            return;
        }
        if(operation.equals("-")){
            result -= num;
            return;
        }
        if(operation.equals("*")){
            result *= num;
            return;
        }
        if(operation.equals("/")){
            result /= num;
            return;
        }
    }

    public boolean isFirst(){
        return operation.isEmpty();
    }

    public int getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
