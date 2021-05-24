package test.java;
import main.java.TrigonometricFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;

public class TrigonometricFunctionTest {

    @Test
    public void testSin() {
        TrigonometricFunction trigonometricFunctions = new TrigonometricFunction();
        Assertions.assertEquals(0, trigonometricFunctions.getSin(-Math.PI, 0.0001));
        Assertions.assertEquals(-1, BigDecimal.valueOf(trigonometricFunctions.getSin(-1.57, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, trigonometricFunctions.getSin(0, 0.01));
        Assertions.assertEquals(1, BigDecimal.valueOf(trigonometricFunctions.getSin(1.57, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.599, BigDecimal.valueOf(trigonometricFunctions.getSin(-2.5, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.462, BigDecimal.valueOf(trigonometricFunctions.getSin(-0.48, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.435, BigDecimal.valueOf(trigonometricFunctions.getSin(0.45, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.917, BigDecimal.valueOf(trigonometricFunctions.getSin(1.98, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    @Test
    public void testCos() {
        TrigonometricFunction trigonometricFunctions = Mockito.spy(TrigonometricFunction.class);
        Mockito.when(trigonometricFunctions.getSin(eq(-3.14), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getSin(eq(-1.57), anyDouble())).thenReturn(-1.0);
        Mockito.when(trigonometricFunctions.getSin(eq(0), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getSin(eq(1.57), anyDouble())).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.getSin(eq(3.14), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getSin(eq(-1.1), anyDouble())).thenReturn(-0.891);
        Mockito.when(trigonometricFunctions.getSin(eq(2.53), anyDouble())).thenReturn(0.574);
        Assertions.assertEquals(-1, trigonometricFunctions.getCos(-3.14, 0.0001));
        Assertions.assertEquals(0, trigonometricFunctions.getCos(-1.57, 0.00001));
        Assertions.assertEquals(1, trigonometricFunctions.getCos(0, 0.0001));
        Assertions.assertEquals(0, trigonometricFunctions.getCos(1.57, 0.00001));
        Assertions.assertEquals(-1, trigonometricFunctions.getCos(3.14, 0.00001));
        Assertions.assertEquals(0.454, BigDecimal.valueOf(trigonometricFunctions.getCos(-1.1, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.819, BigDecimal.valueOf(trigonometricFunctions.getCos(2.53, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void testTan() {
        TrigonometricFunction trigonometricFunctions = Mockito.spy(TrigonometricFunction.class);
        Mockito.when(trigonometricFunctions.getCos(eq(0.165), anyDouble())).thenReturn(0.98641);
        Mockito.when(trigonometricFunctions.getSin(eq(0.165), anyDouble())).thenReturn(0.16425);
        Mockito.when(trigonometricFunctions.getCos(eq(0.465), anyDouble())).thenReturn(0.893821);
        Mockito.when(trigonometricFunctions.getSin(eq(0.465), anyDouble())).thenReturn(0.448422);
        Mockito.when(trigonometricFunctions.getSin(eq(1.57), anyDouble())).thenReturn(1.0);
        Mockito.when(trigonometricFunctions.getCos(eq(1.57), anyDouble())).thenReturn(0.0);
        Mockito.when(trigonometricFunctions.getCos(eq(2.2), anyDouble())).thenReturn(-0.5885);
        Mockito.when(trigonometricFunctions.getSin(eq(2.2), anyDouble())).thenReturn(0.8084);
        Assertions.assertEquals(0.167, BigDecimal.valueOf(trigonometricFunctions.getTan(0.165, 0.000001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.502, BigDecimal.valueOf(trigonometricFunctions.getTan(0.465, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1255.766, trigonometricFunctions.getTan(1.57, 0.0001));
        Assertions.assertEquals(-1.374, BigDecimal.valueOf(trigonometricFunctions.getTan(2.2, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void testSec() {
        TrigonometricFunction functions = Mockito.spy(TrigonometricFunction.class);
        Mockito.when(functions.getCos(eq(-1.47), anyDouble())).thenReturn(0.100626);
        Mockito.when(functions.getCos(eq(-0.6), anyDouble())).thenReturn(0.8253);
        Mockito.when(functions.getCos(eq(0.9), anyDouble())).thenReturn(0.6216);
        Mockito.when(functions.getCos(eq(2.42), anyDouble())).thenReturn(-0.75075);
        Mockito.when(functions.getCos(eq(3.14), anyDouble())).thenReturn(-1.0);
        Mockito.when(functions.getCos(eq(4.2), anyDouble())).thenReturn(-0.4903);
        Assertions.assertEquals(9.938, BigDecimal.valueOf(functions.getSec(-1.47, 0.000001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.212, BigDecimal.valueOf(functions.getSec(-0.6, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.609, BigDecimal.valueOf(functions.getSec(0.9, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.332, BigDecimal.valueOf(functions.getSec(2.42, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1, functions.getSec(3.14, 0.0001));
        Assertions.assertEquals(-2.040, BigDecimal.valueOf(functions.getSec(4.2, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    @Test
    public void integrateTestCos() {
        TrigonometricFunction trigonometricFunctions = new TrigonometricFunction ();
        Assertions.assertEquals(-1, trigonometricFunctions.getCos(-Math.PI, 0.0001));
        Assertions.assertEquals(0, BigDecimal.valueOf(trigonometricFunctions.getCos(-Math.PI / 2, 0.00001)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1, trigonometricFunctions.getCos(0, 0.0001));
        Assertions.assertEquals(0, BigDecimal.valueOf(trigonometricFunctions.getCos(Math.PI / 2, 0.00001)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1, trigonometricFunctions.getCos(Math.PI, 0.00001));
        Assertions.assertEquals(0.454, BigDecimal.valueOf(trigonometricFunctions.getCos(-1.1, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.819, BigDecimal.valueOf(trigonometricFunctions.getCos(2.53, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.539, BigDecimal.valueOf(trigonometricFunctions.getCos(2.14, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.946, BigDecimal.valueOf(trigonometricFunctions.getCos(-0.33, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void integrateTestSec() {
        TrigonometricFunction functions = new TrigonometricFunction();
        Assertions.assertEquals(-1.181, BigDecimal.valueOf(functions.getSec(2.58, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-7.644, BigDecimal.valueOf(functions.getSec(1.702, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(6.486, BigDecimal.valueOf(functions.getSec(1.416, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.307, BigDecimal.valueOf(functions.getSec(0.7, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.286, BigDecimal.valueOf(functions.getSec(-0.68, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(10.455, BigDecimal.valueOf(functions.getSec(-1.475, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.382, BigDecimal.valueOf(functions.getSec(-2.38, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void integrateTestTan() {
        TrigonometricFunction trigonometricFunctions = new TrigonometricFunction();
        Assertions.assertEquals(0.2, BigDecimal.valueOf(trigonometricFunctions.getTan(-2.974, 0.001)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.165, BigDecimal.valueOf(trigonometricFunctions.getTan(-2.28, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.371, BigDecimal.valueOf(trigonometricFunctions.getTan(-1.97, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1157.86, BigDecimal.valueOf(trigonometricFunctions.getTan(-1.57, 0.0001)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-2.296, BigDecimal.valueOf(trigonometricFunctions.getTan(-1.16, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.217, BigDecimal.valueOf(trigonometricFunctions.getTan(-0.214, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.095, BigDecimal.valueOf(trigonometricFunctions.getTan(-0.095, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void integrateTestCsc() {
        TrigonometricFunction trigonometricFunctions = new TrigonometricFunction();
        Assertions.assertEquals(-6.0, BigDecimal.valueOf(trigonometricFunctions.getCsc(-2.974, 0.001)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.318, BigDecimal.valueOf(trigonometricFunctions.getCsc(-2.28, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.085, BigDecimal.valueOf(trigonometricFunctions.getCsc(-1.97, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.0, BigDecimal.valueOf(trigonometricFunctions.getCsc(-1.57, 0.0001)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.091, BigDecimal.valueOf(trigonometricFunctions.getCsc(-1.16, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-4.709, BigDecimal.valueOf(trigonometricFunctions.getCsc(-0.214, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-10.542, BigDecimal.valueOf(trigonometricFunctions.getCsc(-0.095, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void testCsc() {
        TrigonometricFunction functions = Mockito.spy(TrigonometricFunction.class);
        Mockito.when(functions.getSin(eq(-2.974), anyDouble())).thenReturn(-0.166);
        Mockito.when(functions.getSin(eq(-2.28), anyDouble())).thenReturn(-0.7588);
        Mockito.when(functions.getSin(eq(-1.97), anyDouble())).thenReturn(-0.9213);
        Mockito.when(functions.getSin(eq(-1.57), anyDouble())).thenReturn(-0.9999);
        Mockito.when(functions.getSin(eq(-1.16), anyDouble())).thenReturn(-0.9168);
        Mockito.when(functions.getSin(eq(-0.214), anyDouble())).thenReturn(-0.21237);
        Mockito.when(functions.getSin(eq(-0.095), anyDouble())).thenReturn(-0.094857);
        Assertions.assertEquals(-6.0, BigDecimal.valueOf(functions.getCsc(-2.974, 0.001)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.318, BigDecimal.valueOf(functions.getCsc(-2.28, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.085, BigDecimal.valueOf(functions.getCsc(-1.97, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.0, BigDecimal.valueOf(functions.getCsc(-1.57, 0.0001)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.091, BigDecimal.valueOf(functions.getCsc(-1.16, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-4.709, BigDecimal.valueOf(functions.getCsc(-0.214, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-10.542, BigDecimal.valueOf(functions.getCsc(-0.095, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}