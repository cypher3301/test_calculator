package main.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void run() {
        main.run("1+2");
        main.run("8+10");
        try {
            main.run("13+10");
            main.run("1+13");
            assert false;
        }catch (IllegalStateException e)
        {
            assert true;
        }

        main.run("I+II");
        main.run("I+IV");
        main.run("VII+IV");
        main.run("X+IV");
        try {
            main.run("XI+IV");
            main.run("X+XI");
            assert false;
        }catch (IllegalStateException e){
            assert true;
        }

    }
}