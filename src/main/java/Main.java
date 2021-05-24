package main.java;

public class Main {
    public static void main(String[] args) {
        MathEquation systems = new MathEquation();
        double limit = Math.PI/2 - 0.1;
        for (double i = limit; i > -limit; i -= 0.5) {
            systems.getResult(i, 0.01);
        }
        Writer.close();
    }

}
