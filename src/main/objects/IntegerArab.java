package main.objects;

public class IntegerArab {
    private Integer number;

    public IntegerArab(Object number) {
        this.number = Integer.parseInt((String) number);//преобразуем в тип Int
    }

    public Integer getNumber() {
        return number;
    }

    public static boolean isInRange(int number){
        //проверить диапазон
        return (number<=10)&&(number>=1);
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }
}
