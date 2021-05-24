package test.java;

import main.java.LogarithmManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;

public class LogarithmTest {
    @Test
    public void testNaturalLogarithm() {
        LogarithmManagement logarithms = new LogarithmManagement();
        Assertions.assertEquals(0, logarithms.getNaturalLogarithm(1, 0.00001));
        Assertions.assertEquals(Double.NaN, logarithms.getNaturalLogarithm(0, 0.00001));
        Assertions.assertEquals(-1.347, BigDecimal.valueOf(logarithms.getNaturalLogarithm(0.26, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.288, BigDecimal.valueOf(logarithms.getNaturalLogarithm(0.75, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.548, BigDecimal.valueOf(logarithms.getNaturalLogarithm(1.73, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.347,  BigDecimal.valueOf(logarithms.getNaturalLogarithm(10.45, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void testModuleLogarithmSecondBase(){
        LogarithmManagement logarithms = Mockito.spy(LogarithmManagement.class);
        Mockito.when(logarithms.getNaturalLogarithm(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(logarithms.getNaturalLogarithm(eq(0), anyDouble())).thenReturn(Double.NaN);
        Mockito.when(logarithms.getNaturalLogarithm(eq(0.44), anyDouble())).thenReturn(-0.821);
        Mockito.when(logarithms.getNaturalLogarithm(eq(0.67), anyDouble())).thenReturn(-0.4);
        Mockito.when(logarithms.getNaturalLogarithm(eq(5.33), anyDouble())).thenReturn(1.673);
        Assertions.assertEquals(0,logarithms.getLogarithmSecondBase(1, 0.00001));
        Assertions.assertEquals(Double.NaN, logarithms.getLogarithmSecondBase(0, 0.01));
        Assertions.assertEquals(-1.184, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(0.44, 0.0001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.577, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(0.67, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.414, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(5.33, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }


    @Test
    public void integrateTestLogarithms(){
        LogarithmManagement logarithms = new LogarithmManagement();
        Assertions.assertEquals(Double.NaN, logarithms.getLogarithmSecondBase(0.0, 0.00001));
        Assertions.assertEquals(-2.737, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(0.15, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.862, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(0.55, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.044, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(0.97, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, logarithms.getLogarithmSecondBase(1, 0.00001));
        Assertions.assertEquals(0.705, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(1.63, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(4, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(3.134, BigDecimal.valueOf(logarithms.getLogarithmSecondBase(8.78, 0.000001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}