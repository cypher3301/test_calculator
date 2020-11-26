package main.main;

import main.ligic.Ligic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run("");
    }

    public void run(String input) {
        Ligic ligic = new Ligic();
        if (input.isEmpty()) {//проверяем переменную на пустоту
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter expression: \n-->: ");
            String inputString = scanner.nextLine();//ввод выражения
            ligic.calculate(inputString);//вычисление выражения
        } else {
            ligic.calculate(input);//вычисление выражения если переменная не пустая
        }
        System.out.println("Result: " + ligic.getStringResult());//получить и вывести результат
    }
}
