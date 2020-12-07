package main.ligic;

import main.objects.IntegerArab;
import main.objects.IntegerRome;
import main.objects.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;


public class Ligic {
    static int flag = 0;//1 arab, -1 roume
    /*
    * Класс для реализации логики калькулятора арабских или римских чисел в диапазоне
    * от (1,I) до (10,X)
    * */
    int result;

    public Ligic() {
    }

    //вычислить результат выражения
    public String calculate(String inputString) {
        flag = 0;//флаг для понимания какой вид чилес используеться (арабские или римские)
        List<Integer> integers = new ArrayList<>();//список чисел
        List<IntBinaryOperator> operators = new ArrayList<>();//список операторов
        int sum = 0;//сума
        String[] parse = parseString(inputString);//масив строк, содержит числа и операторы
        for (int i = 0; i < parse.length; i++) {
            String simbol = parse[i];//получаем число или оператор
            if (String.valueOf(simbol).equals(" ")) continue;//если пробел то пропустить
            if (isDigit(simbol) && flag != -1) {//проверяем наше число являеться арабским
                if (IntegerArab.isInRange(Integer.parseInt(simbol))) {//проверяем диапазон
                    integers.add(new IntegerArab(simbol).getNumber());//создаем обьект числа
                    flag = 1;//ставим флаг на арабские числа
                } else //если не в диапазоне то кидаем исключение
                    dropException();
            } else if (IntegerRome.isRomeNumber(simbol) && flag != 1) {//проверка являеться число римским
                integers.add(new IntegerRome(simbol).getNumber());//создаем обьект числа
                flag = -1;//ставим флаг на римские числа
            } else if (Operator.isOperator(simbol)) {//проверка являеться ли символ оператором
                operators.add(new Operator(simbol).getOperator());//созлаем обьект оператора
            } else {//если ни один вариант не подошел то выкидываем исключение
                dropException();
            }
        }
        sum = integers.get(0);
        for (int i = 0, j = 1; i < operators.size(); i++, j++) {
            sum = operators.get(i).applyAsInt(sum, integers.get(j));
        }
        this.result = sum;
        return getStringResult();
    }

    //выбросить исключение
    public static void dropException() {
        throw new IllegalStateException("Expression not correct");
    }

    // функци преобразование из арабских в римские
    private String convertNumberToRome(int number) {
        int[] numb = new int[]{100,50,10,5,1};
        StringBuffer s = new StringBuffer("");
        int num = number;

        if (flag == -1) {
            int i = 0;
            while (num!=0){
                int buff = num/numb[i];
                num%=numb[i];
                s.append(IntegerRome.getRome(buff*numb[i]));
                if(num==9||num==90){
                    s.append(IntegerRome.getRome(num));
                    break;
                }
                i++;
            }
        }

//        if (flag == -1) {
//            while (num != 0) {
//                if (num > 10) {
//                    s = String.format("X%s", s);
////                    if (s.equals("XXXXX")) s="L";
////                    else if(s.equals("XXXX")) s="XL";
////                    s.sta
//                } else {
//                    s += IntegerRome.getRome(num);
//                    return s;
//                }
//                num = num - 10;
//            }
//        }

        return String.valueOf(s);
    }

    //являеться ли символ числом
    private boolean isDigit(String simbol) {
        try {
            Integer.parseInt(simbol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //разбиение строки в масив символов разделенным мат. знаком
    private String[] parseString(String s) {
        String pattern = "((?<=[+\\-*/])|(?=[+\\-*/]))";
        return s.split(pattern);
    }

    //получить результат в виде чила типа Int
    public int getResult() {
        return result;
    }

    //получить результат в виде строки
    public String getStringResult() {
        return convertNumberToRome(result);
    }
}
