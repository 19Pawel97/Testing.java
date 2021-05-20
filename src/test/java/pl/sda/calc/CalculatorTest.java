package pl.sda.calc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        // when
        double result = calculator.add(1, 10);

        // then
        assertThat(result).isEqualTo(11);
    }


    @Test
    public void testSubtract() {
        // when
        double result = calculator.subtract(10, 3);

        // then
        assertEquals(7, result, 0);
    }

    @Test
    public void testMultiple() {
        // when
        double result = calculator.multiple(2, 8);

        // then
        assertEquals(16, result, 0);
    }

    @Test
    public void testDivide() {
        // when
        double result = calculator.divide(10, 5);

        // then
        assertEquals(2, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        double result = calculator.divide(30, 0);
    }

    @Test
    public void testPower() {
        // when
        double result = calculator.power(2, 3);

        // then
        assertEquals(8, result, 0);
    }

    @Test
    public void testRoot() {
        // when
        double result = calculator.root(9);

        // then
        assertEquals(3, result, 0);
    }

    @Test
    public void testIsDividable() {
        // when
        boolean result = calculator.isDividable(21, 4);

        // then
        assertEquals(result, false);
    }

    @Test
    public void testIsNotDividable() {
        // when
        boolean result = calculator.isDividable(21, 7);

        // then
        assertEquals(result, true);
    }

    @Test
    public void testSumArray() {
        // when
        Double sum = calculator.sumArrayOfNumbers(1,2,3,4,5,6,7,8,9,10);

        // then
        assertEquals(java.util.Optional.of(sum), Optional.of(55d));
    }
}