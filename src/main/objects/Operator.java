package main.objects;

import java.util.List;
import java.util.function.IntBinaryOperator;

public class Operator {
    static List<String> operators = List.of("+","-","*","/");//база операторов
    private String op;

    public Operator(Object op) {
        this.op = String.valueOf(op);
    }

    public static boolean isOperator(Object operator){
        //являеться ли симол оператором
        return operators.stream().anyMatch(n->n.equals(String.valueOf(operator)));
    }

    private static int sum(int a, int b){
        return a+b;
    }

    private static int sub(int a, int b){
        return a-b;
    }

    private static int mul(int a, int b){
        return a*b;
    }

    private static int div(int a, int b){
        return a/b;
    }

    public IntBinaryOperator getOperator() {
        //вернуть ссылку на метод вычисления
        return switch (this.op) {
            case "+" -> Operator::sum;
            case "-" -> Operator::sub;
            case "*" -> Operator::mul;
            case "/" -> Operator::div;
            default -> throw new IllegalStateException("Unexpected value: " + this.op);
        };
    }
}
