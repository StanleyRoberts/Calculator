package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.InvalidException;
import calculator.RevPolishCalc;
import org.junit.Test;

public class TestRevPolishCalc {
  @Test
  //Test 1
  //Tests calculate returns expected value
  public void testCalculate() throws InvalidException {
    RevPolishCalc calc = new RevPolishCalc();
    float ans = calc.evaluate("5 6 7 + * 2 -");
    assertEquals(63.0, ans, 0);
  }

  
  @Test
  //Test 2
  //Tests calculate throws exception
  public void testCalculateException() {
    RevPolishCalc calc = new RevPolishCalc();
    boolean thrown = false;
    
    try {
      calc.evaluate("+ 5 5");
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
  }
}
