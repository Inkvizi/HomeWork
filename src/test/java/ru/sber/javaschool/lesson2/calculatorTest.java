package ru.sber.javaschool.lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sber.javaschool.lesson2.Calculator;

public class calculatorTest {
    private Calculator testObject;
    @Before
    public void setUp() {
        testObject = new Calculator();
    }

    @Test
    public void addition() {
        int result = testObject.addition(-2, 7);
        Assert.assertEquals(5, result);
    }

    @Test
    public void subtraction() {
        int result = testObject.subtraction(0, 9);
        Assert.assertEquals(-9, result);
    }

    @Test
    public void multiplication() {
        double result = testObject.multiplication(0, 23);
        Assert.assertEquals(0, Double.compare(0, result));
        result = testObject.multiplication(-1, 23);
        Assert.assertEquals(0, Double.compare(-23, result));
    }

    @Test
    public void division() {
        double result = testObject.division(0, 17);
        Assert.assertEquals(0, Double.compare(0, result));
        result = testObject.division(9, 3);
        Assert.assertEquals(0, Double.compare(3, result));
    }

    @Test
    public void getModulus() {
        int result = testObject.getModulus(0);
        Assert.assertEquals(0, result);
        result = testObject.getModulus(5);
        Assert.assertEquals(5, result);
        result = testObject.getModulus(-2);
        Assert.assertEquals(2, result);
    }

    @Test
    public void getMod() {
        int result = testObject.getMod(0, 3);
        Assert.assertEquals(0, result);
        result = testObject.getMod(5, 9);
        Assert.assertEquals(5, result);
        result = testObject.getMod(17, 5);
        Assert.assertEquals(2, result);
        result = testObject.getMod(15, 3);
        Assert.assertEquals(0, result);
    }

    @Test
    public void getPercentValue() {
        double result = testObject.getPercentValue(100, 0);
        Assert.assertEquals(0, Double.compare(0, result));
        result = testObject.getPercentValue(200, 15);
        Assert.assertEquals(0, Double.compare(30, result));
    }
}