package main.java;

public class MathEquation {
    private LogarithmManagement logarithmManagement;
    private TrigonometricFunction trigonometricFunctions;

    public MathEquation(){
        this.trigonometricFunctions = new TrigonometricFunction();
        this.logarithmManagement = new LogarithmManagement();
    }

    public MathEquation(LogarithmManagement logarithmManagement, TrigonometricFunction trigonometricFunctions){
        this.trigonometricFunctions = trigonometricFunctions;
        this.logarithmManagement = logarithmManagement;
    }
    public double getResult(double x, double accuracy) {
        double result;
        if (x > 0) {

            result = ((((logarithmManagement.getLogarithmSecondBase(x, accuracy) - logarithmManagement.getLogarithmSecondBase(x, accuracy))
                    + (logarithmManagement.getLogarithmSecondBase(x, accuracy)*logarithmManagement.getLogarithmTenthBase(x, accuracy)))
                    *logarithmManagement.getLogarithmThirdBase(x, accuracy)) - (logarithmManagement.getLogarithmThirdBase(x, accuracy)
                    *logarithmManagement.getNaturalLogarithm(x, accuracy)))
                    /logarithmManagement.getLogarithmThirdBase(x, accuracy);
        }else {
            result = ((((trigonometricFunctions.getSec(x, accuracy) - trigonometricFunctions.getSec(x, accuracy))
                    + (trigonometricFunctions.getSec(x, accuracy)*trigonometricFunctions.getSin(x, accuracy)))
                    *trigonometricFunctions.getCos(x, accuracy))
                    -(trigonometricFunctions.getSin(x, accuracy)*trigonometricFunctions.getCsc(x, accuracy)))/trigonometricFunctions.getTan(x, accuracy);
        }
        Writer.write(x, result, Modules.System);
        return result;
    }
}
