package pl.sda.calc;

import java.util.Arrays;

public class Calculator { // ctrl + shift + t - creates a test
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiple(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("One cannot divide by zero!");
        }
        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double root(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("No complex numbers allowed, ur number must be > 0");
        }
        return Math.sqrt(a);
    }

    public boolean isDividable(double a, double b) {
        if (a % b == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double sumArrayOfNumbers(double... numbers) {
        double sum = Arrays.stream(numbers)
                .sum();
        return sum;
    }
}

