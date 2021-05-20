package pl.sda.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CalculatorTestMatchers {
    private Calculator calculator;

    @Before
    public void Calculator() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        // when
        double result = calculator.add(3, 8);

        // then
        assertThat(result)
                .as("3 + 8 should be 11")
                .isEqualTo(11);
    }

    @Test
    public void testSubtract() {
        // when
        double result = calculator.subtract(10, 2);

        // then
        assertThat(result)
                .as("10 - 2 should equal 8")
                .isEqualTo(8);
    }

    @Test
    public void testMultiple() {
        // when
        double result = calculator.multiple(2, 30);

        // then
        assertThat(result)
                .as("2 * 30 should be 60")
                .isEqualTo(60);
    }

    @Test
    public void testDivide() {
        // when
        double result = calculator.divide(27, 9);

        // then
        assertThat(result)
                .as("27 / 9 should be 3")
                .isEqualTo(3);
    }

    @Test
    public void testPow() {
        // when
        double result = calculator.power(3, 3);

        // then
        assertThat(result)
                .as("3 to 3 should be 27")
                .isEqualTo(27);
    }

    @Test
    public void testRoot() {
        // when
        double result = calculator.root(9);

        // then
        assertThat(result)
                .as("The root from 9 should be 3")
                .isEqualTo(3);
    }

    @Test
    public void testIsDividable() {
        // when
        boolean result = calculator.isDividable(21, 5);

        // then
        assertThat(result)
                .isFalse();
    }

    @Test
    public void testIsNotDividable() {
        // when
        boolean result = calculator.isDividable(21,7);

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    public void testSumArray() {
        // when
        Double sum = calculator.sumArrayOfNumbers(1,2,3,4,5,6,7,8,9);

        // then
        assertThat(sum)
                .isEqualTo(45);
    }
}
