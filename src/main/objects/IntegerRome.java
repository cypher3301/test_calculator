package main.objects;

import main.ligic.Ligic;

import java.util.HashMap;
import java.util.Map;

public class IntegerRome {
    static Map<String, Integer> romeData = mapRomeNumber();//данные римских чисел
    private final String numberRome;//виде римкого числа
    private Integer number;//виде арабского числа


    public IntegerRome(Object number) {
        this.numberRome = String.valueOf(number);
    }

    private static Map<String, Integer> mapRomeNumber() {
        //заполнить значениями соответствий римских и арабских чисел
        Map<String, Integer> romeData = new HashMap<>();
        romeData.put("I", 1);
        romeData.put("II", 2);
        romeData.put("III", 3);
        romeData.put("IV", 4);
        romeData.put("V", 5);
        romeData.put("VI", 6);
        romeData.put("VII", 7);
        romeData.put("VIII", 8);
        romeData.put("IX", 9);
        romeData.put("X", 10);
        return romeData;
    }

    public static String getRome(int num){
        //получить число в виде римского числа
        for (Map.Entry<String, Integer> item: romeData.entrySet()){
            if (item.getValue()==num){
                return item.getKey();
            }
        }
        return null;
    }

    public static boolean isRomeNumber(Object i) {
        //являеться ли число римским
        for (Map.Entry<String, Integer> item: romeData.entrySet()){
            if (item.getKey().equals(i)){
                return true;
            }
        }
        return false;
    }

    public void getIntFromRomeNumber() {
        //получить арабское число из римского для расчета
        if (romeData.get(this.numberRome) == null) {
            Ligic.dropException();
        }
        this.number = romeData.get(this.numberRome);
    }

    public Integer getNumber() {
        //вернуть арабское число из римского
        getIntFromRomeNumber();
        return number;
    }

    public String getNumberRome() {
        //получить римское число
        return numberRome;
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }
}
