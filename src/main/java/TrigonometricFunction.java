package main.java;
import static java.lang.Double.NaN;
import static java.lang.Double.doubleToLongBits;

public class TrigonometricFunction {
    public double getSin(double x, double accuracy) {
        double z = x;
//        accuracy = 0.01;
        boolean p = false;
        if(x < 0) {
            x = -x;
            p = !p;
        }
        x = x%(2*Math.PI);
        if(x > (Math.PI)){
            p = !p;
            x = x - Math.PI;
        }
        if (x % Math.PI != 0) {
            double power;
            double curSum = 0;
            double testSum = -1;
            int fact = 1;
            int i = 1;
            int sign = -1;
            while (Math.abs(curSum - testSum) > accuracy) {
                testSum = curSum;
                power = 1;
                fact = 1;
                for (int j = 1; j <= i; j++) {
                    power = power * x;
                    fact = fact * j;
                }
                sign = -1 * sign;
                curSum += sign * power / fact;
                i += 2;
            }
            Writer.write(z, curSum, Modules.Sin);
            if(p== true) curSum = -curSum;
            return curSum;
        }else{
            Writer.write(z, 0, Modules.Sin);
            return 0;
        }

    }

    public double getCos(double x, double accuracy) {
        double result = 0;
        if ((x % (Math.PI / 2) == 0) && !(x % Math.PI == 0)) {
            Writer.write(x, result, Modules.Cos);
            return result;
        }
        result = Math.sqrt(1 - Math.pow(getSin(x, accuracy), 2));
        if (Math.round(x / Math.PI) % 2 != 0)
            result = (result == 0 ? 0 : -1 * result);
        Writer.write(x, result, Modules.Cos);
        return result;
    }

    public double getSec(double x, double accuracy) {
        double result;
        if (x % Math.PI / 2 == 0) {
            result = NaN;
            Writer.write(x, result, Modules.Sec);
            return result;
        }
        result = 1 / getCos(x, accuracy);
        Writer.write(x, result, Modules.Sec);
        return result;
    }

    public double getTan(double x, double accuracy) {
        double result;
        if (x % Math.PI/2 == 0) {
            result =  NaN;
            Writer.write(x, result, Modules.Tan);
            return result;
        }
        result = getSin(x, accuracy) / getCos(x, accuracy);
        Writer.write(x, result, Modules.Tan);
        return result;
    }

    public double getCsc(double x, double accuracy){
        double result;
        if (x % Math.PI == 0) {
            result = NaN;
            Writer.write(x, result, Modules.Csc);
            return result;
        }
        result = 1 / getSin(x, accuracy);
        Writer.write(x, result, Modules.Csc);
        return result;
    }

}
