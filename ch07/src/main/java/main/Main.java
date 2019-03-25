package main;

import ch07.ExeTimeCalculator;
import ch07.ImpeCalculator;
import ch07.RecCalculator;

public class Main {
    public static void main(String[] args) {
        ExeTimeCalculator calculator = new ExeTimeCalculator(new ImpeCalculator());
        long result = calculator.factorial(20);

        ExeTimeCalculator calculator1 = new ExeTimeCalculator(new RecCalculator());
        long result1 = calculator1.factorial(20);
    }
}
