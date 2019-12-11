package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.ArithmeticOverflowException;
import calculator.DivisionByZeroException;
import calculator.InvalidException;
import calculator.StandardCalc;
import org.junit.Test;

public class TestStandardCalc {
  @Test
  //Test 1
  //Tests calculate returns expected value
  public void testCalculate() throws InvalidException,
        DivisionByZeroException, ArithmeticOverflowException {
    
    StandardCalc calc = new StandardCalc();
    float ans = calc.evaluate("( 5 * ( 6 + 7 ) ) - 2");
    assertEquals(63.0, ans, 0);
  }

  
  @Test
  //Test 2
  //Tests calculate throws invalid exception for incorrect expressions
  public void testCalculateException() throws DivisionByZeroException, ArithmeticOverflowException {
    StandardCalc calc = new StandardCalc();
    boolean thrown = false;
    
    try {
      calc.evaluate("5 + 5 )");
    } catch (InvalidException e) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      calc.evaluate("5 5 &");
    } catch (InvalidException e) {
      thrown = true;
    }
    assertTrue(thrown);
    
    thrown = false;
    try {
      calc.evaluate("( 5 + 5");
    } catch (InvalidException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  //Test 3
  //Tests calculate throws division by zero exception
  public void testDivisionByZero() throws InvalidException, ArithmeticOverflowException {
    StandardCalc calc = new StandardCalc();
    boolean thrown = false;
    
    try {
      calc.evaluate("5 / 0");
    } catch (DivisionByZeroException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  //Test 4
  //Tests calculate throws arithmetic overflow exception
  public void testArith() throws InvalidException, DivisionByZeroException {
    StandardCalc calc = new StandardCalc();
    boolean thrown = false;
    
    try {
      calc.evaluate("-9147483647 * 9147483647 * 9147483647 * 9147483647 * 9147483647");
    } catch (ArithmeticOverflowException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
}
