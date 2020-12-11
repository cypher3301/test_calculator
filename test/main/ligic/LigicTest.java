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
        } catch (IllegalStateException e) {
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

    @Test
    void FinalArabTest() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(ligic1.calculate(String.format("%d+%d", i, j)) + ":" +
                        ligic1.calculate(String.format("%d-%d", i, j)) + ":" +
                        ligic1.calculate(String.format("%d*%d", i, j)) + ":" +
                        ligic1.calculate(String.format("%d/%d", i, j)));
                System.out.println();
            }
        }
        assert true;
    }

    @Test
    void FinalRomeTest() {
        String[] help = new String[]{
                "I",
                        "II",
                        "III",
                        "IV",
                        "V",
                        "VI",
                        "VII",
                        "VIII",
                        "IX",
                        "X"};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String sum = String.format("%s+%s",help[i],help[j]);
                String sub = String.format("%s-%s",help[i],help[j]);
                String mul = String.format("%s*%s",help[i],help[j]);
                String div = String.format("%s/%s",help[i],help[j]);
                System.out.println(
                        sum+":{"+ligic1.calculate(sum) + "}\n" +
                        sub+":{"+ligic1.calculate(sub) + "}\n" +
                        mul+":{"+ligic1.calculate(mul) + "}\n" +
                        div+":{"+ligic1.calculate(div) + "}\n");
                System.out.println();
            }
        }
        assert true;
    }

//    @Test
//    void someTest(){
//        System.out.println(ligic1.calculate("X-VII"));
//        System.out.println(ligic1.getStringResult());
//
//    }

}