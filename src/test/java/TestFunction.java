package test.java;
import main.java.LogarithmManagement;
import main.java.MathEquation;
import main.java.TrigonometricFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;

public class TestFunction {
    @Test
    public void testFunction(){
        LogarithmManagement logarithmManagement = Mockito.spy(LogarithmManagement.class);
        TrigonometricFunction trigonometricFunctions = Mockito.spy(TrigonometricFunction.class);

        Mockito.when(logarithmManagement.getNaturalLogarithm(eq(0.6), anyDouble())).thenReturn(-0.51082);
        Mockito.when(logarithmManagement.getNaturalLogarithm(eq(1.0), anyDouble())).thenReturn(0.0);
        Mockito.when(logarithmManagement.getNaturalLogarithm(eq(1.6), anyDouble())).thenReturn(0.47000);

        Mockito.when(logarithmManagement.getLogarithmSecondBase(eq(0.6), anyDouble())).thenReturn(-0.73696);
        Mockito.when(logarithmManagement.getLogarithmSecondBase(eq(1.0), anyDouble())).thenReturn(0.0);
        Mockito.when(logarithmManagement.getLogarithmSecondBase(eq(1.6), anyDouble())).thenReturn(0.67807);

        Mockito.when(logarithmManagement.getLogarithmThirdBase(eq(0.6), anyDouble())).thenReturn(-0.46497);
        Mockito.when(logarithmManagement.getLogarithmThirdBase(eq(1.0), anyDouble())).thenReturn(0.0);
        Mockito.when(logarithmManagement.getLogarithmThirdBase(eq(1.6), anyDouble())).thenReturn(0.42781);

        Mockito.when(logarithmManagement.getLogarithmTenthBase(eq(0.6), anyDouble())).thenReturn(-0.22184);
        Mockito.when(logarithmManagement.getLogarithmTenthBase(eq(1.0), anyDouble())).thenReturn(0.0);
        Mockito.when(logarithmManagement.getLogarithmTenthBase(eq(1.6), anyDouble())).thenReturn(0.20412);

        Mockito.when(trigonometricFunctions.getSin(eq(0), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getSin(eq(-1.4), anyDouble())).thenReturn(-0.98544);
        Mockito.when(trigonometricFunctions.getSin(eq(-Math.PI/2), anyDouble())).thenReturn(-1.0);

        Mockito.when(trigonometricFunctions.getCos(eq(0), anyDouble())).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.getCos(eq(-1.4), anyDouble())).thenReturn(0.16996);
        Mockito.when(trigonometricFunctions.getCos(eq(-Math.PI/2), anyDouble())).thenReturn(0.0);

        Mockito.when(trigonometricFunctions.getCsc(eq(0), anyDouble())).thenReturn(Double.NaN);
        Mockito.when(trigonometricFunctions.getCsc(eq(-1.4), anyDouble())).thenReturn(-1.01476);
        Mockito.when(trigonometricFunctions.getCsc(eq(-Math.PI/2), anyDouble())).thenReturn(-1.0);

        Mockito.when(trigonometricFunctions.getSec(eq(0), anyDouble())).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.getSec(eq(-1.4), anyDouble())).thenReturn(5.88349);
        Mockito.when(trigonometricFunctions.getSec(eq(-Math.PI/2), anyDouble())).thenReturn(Double.NaN);

        Mockito.when(trigonometricFunctions.getTan(eq(0), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getTan(eq(-1.4), anyDouble())).thenReturn(-5.798);
        Mockito.when(trigonometricFunctions.getTan(eq(-Math.PI/2), anyDouble())).thenReturn(Double.NaN);

        MathEquation mathEquation = new MathEquation(logarithmManagement, trigonometricFunctions);
        Assertions.assertEquals(Double.NaN, mathEquation.getResult(0, 0.0001));
        Assertions.assertEquals(0.342, BigDecimal.valueOf(mathEquation.getResult(-1.4, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, mathEquation.getResult(-Math.PI/2, 0.0001));
        Assertions.assertEquals(0.674,BigDecimal.valueOf(mathEquation.getResult(0.6, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, mathEquation.getResult(1.0, 0.0001));
        Assertions.assertEquals(-0.332,BigDecimal.valueOf(mathEquation.getResult(1.6, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}