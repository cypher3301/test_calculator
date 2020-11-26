package main.ligic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LigicTest {
Ligic ligic1;
Ligic ligic2;
    @BeforeEach
    void setUp() {
        ligic1 = new Ligic();
        ligic2 = new Ligic();
    }

    @Test
    void getResult() {
//        ligic1.calculate("1+2+3");
//        System.out.println(ligic1.getStringResult());
//        assert ligic1.getResult()==6;
        ligic2.calculate("VI+X");
        System.out.println(ligic2.getStringResult());
//        assert ligic2.getResult()==3;
    }

//    @Test
//    void parseString() {
//        String[] strings = ligic2.parseString("I+II");
//        Arrays.stream(strings).forEach(System.out::println);
//        strings = ligic2.parseString("I-II");
//        Arrays.stream(strings).forEach(System.out::println);
//        strings = ligic2.parseString("I*II");
//        Arrays.stream(strings).forEach(System.out::println);
//        strings = ligic2.parseString("I/II");
//        Arrays.stream(strings).forEach(System.out::println);
//    }

    @Test
    void isDigit() {
//        System.out.println(ligic2.isDigit("s"));
    }

    @Test
    void calculate() {
        ligic1.calculate("2+5");
        ligic1.calculate("IV-II");
        try {
            ligic1.calculate("IV-2");
        }catch (IllegalStateException e){
            System.out.println(e);
            assert true;
        }
//        assert false;
    }

    @Test
    void convertNumber() {
        Ligic ligic = new Ligic();
        ligic.calculate("VI+X");
//        System.out.println(ligic.getStringResult());
    }

    //правильно распарсить строку//
    //проблема вывода римских чисел//
    //проблема преобразования римских в арабские, правильный парсинг риских//
    //учет следующего числа в римских знаках//

    //...// означает что проблема решена
    //... означает актуальную проблему
}