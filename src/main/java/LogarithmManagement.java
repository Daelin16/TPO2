package main.java;

public class LogarithmManagement {
    public double getNaturalLogarithm(double x, double accuracy) {
        if (x > 0) {
            int i = 1;
            double curResult = 0;
            double testResult = -1;
            while (Math.abs(curResult - testResult) > accuracy) {
                testResult = curResult;
                curResult += Math.pow((x - 1) / (x + 1), i) / i;
                i += 2;
            }
            curResult *= 2;
            Writer.write(x, curResult, Modules.Ln);
            return curResult;
        }else{
            Writer.write(x, Double.NaN, Modules.Ln);
            return Double.NaN;
        }
    }

    public double getLogarithmSecondBase(double x, double accuracy) {
        double result = getNaturalLogarithm(x, accuracy) / getNaturalLogarithm(2, accuracy);
        Writer.write(x, result, Modules.Log_2);
        return result;
    }

    public double getLogarithmThirdBase(double x, double accuracy) {
        double result = getNaturalLogarithm(x, accuracy) / getNaturalLogarithm(3, accuracy);
        Writer.write(x, result, Modules.Log_3);
        return result;
    }


    public double getLogarithmTenthBase(double x, double accuracy) {
        double result = getNaturalLogarithm(x, accuracy) / getNaturalLogarithm(10, accuracy);
        Writer.write(x, result, Modules.Log_10);
        return result;
    }

}
