package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.ArithmeticOverflowException;
import calculator.CalcModel;
import calculator.DivisionByZeroException;
import calculator.InvalidException;

import org.junit.Test;



public class TestCalcModel {
  @Test
  //Test 1
  //Tests calculate for postfix and infix expressions
  public void testCalculate() throws InvalidException,
        DivisionByZeroException, ArithmeticOverflowException {
    
    CalcModel calc = new CalcModel();
    float ans = calc.evaluate("3 4 2 1 - × +", false);
    assertEquals(7.0, ans, 0);
    ans = calc.evaluate("3 + 4 × (2 - 1)", true);
    assertEquals(7.0, ans, 0);
  }

  
  @Test
  //Test 2
  //Tests calculate throws exception in correct cases
  public void testCalculateException() throws DivisionByZeroException, ArithmeticOverflowException {
    CalcModel calc = new CalcModel();
    boolean thrown = false;
    
    try {
      calc.evaluate("3 4 2 1 - ×", false);
    } catch (InvalidException e) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      calc.evaluate("3 4 × (2 - 1)", true);
    } catch (InvalidException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
}
