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

    //заполнить значениями соответствий римских и арабских чисел
    private static Map<String, Integer> mapRomeNumber() {
        Map<String, Integer> romeData = new HashMap<>();
        romeData.put("", 0);
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
        romeData.put("XX", 20);
        romeData.put("XXX", 30);
        romeData.put("XL", 40);
        romeData.put("L", 50);
        romeData.put("LX", 60);
        romeData.put("LXX", 70);
        romeData.put("LXXX", 80);
        romeData.put("XC", 90);
        romeData.put("C", 100);
        return romeData;
    }

    //получить число в виде римского числа
    public static String getRome(int num){
        for (Map.Entry<String, Integer> item: romeData.entrySet()){
            if (item.getValue()==num){
                return item.getKey();
            }
        }
        return null;
    }

    //являеться ли число римским
    public static boolean isRomeNumber(Object i) {
        for (Map.Entry<String, Integer> item: romeData.entrySet()){
            if (item.getKey().equals(i)){
                return true;
            }
        }
        return false;
    }

    //получить арабское число из римского для расчета
    public void getIntFromRomeNumber() {
        if (romeData.get(this.numberRome) == null) {
            Ligic.dropException();
        }
        this.number = romeData.get(this.numberRome);
    }

    //вернуть арабское число из римского
    public Integer getNumber() {
        getIntFromRomeNumber();
        return number;
    }

    //получить римское число
    public String getNumberRome() {
        return numberRome;
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }
}
