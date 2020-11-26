package main.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    Operator operatorSum;
    Operator operatorSub;
    Operator operatorMul;
    Operator operatorDiv;

    @BeforeEach
    void setUp() {
        operatorSum = new Operator("+");
        operatorSub = new Operator("-");
        operatorMul = new Operator("*");
        operatorDiv = new Operator("/");
    }

    @Test
    void getOperator() {
//        assert operatorSum.getOperator().applyAsInt(1, 4) == 5;
        assert operatorSum.getOperator().applyAsInt(6, 2)==8;
        assert operatorSub.getOperator().applyAsInt(6, 2)==4;
        assert operatorMul.getOperator().applyAsInt(6, 2)==12;
        assert operatorDiv.getOperator().applyAsInt(6, 2)==3;
    }
}