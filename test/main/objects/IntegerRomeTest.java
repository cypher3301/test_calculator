package main.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRomeTest {
    IntegerRome rome1;
    IntegerRome rome4;
    IntegerRome rome7;

    @BeforeEach
    void setUp() {
        rome1 = new IntegerRome("I");
        rome4 = new IntegerRome("IV");
        rome7 = new IntegerRome("VII");
    }

    @Test
    void getNumber() {
        rome1.getIntFromRomeNumber();
        assert rome1.getNumber()==1;
        rome4.getIntFromRomeNumber();
        assert rome4.getNumber()==4;
        rome7.getIntFromRomeNumber();
        assert rome7.getNumber()==7;
    }

    @Test
    void getNumberRome() {
        assert rome1.getNumberRome().equals("I");
        assert rome4.getNumberRome().equals("IV");
        assert rome7.getNumberRome().equals("VII");
    }

//    @Test
//    void isRomeNumber() {
//        assertTrue(IntegerRome.isRomeNumber('I'));
//        assertTrue(IntegerRome.isRomeNumber("I"));
//        assertTrue(IntegerRome.isRomeNumber("V"));
//        assertTrue(IntegerRome.isRomeNumber("X"));
//        assertFalse(IntegerRome.isRomeNumber("XI"));
//
//
//    }

    @Test
    void getIntFromRomeNumber() {
        rome1.getIntFromRomeNumber();
        assertEquals(1, rome1.getNumber());
        rome4.getIntFromRomeNumber();
        assertEquals(4, rome4.getNumber());
        rome7.getIntFromRomeNumber();
        assertEquals(7, rome7.getNumber());
    }
}