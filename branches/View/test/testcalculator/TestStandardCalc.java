package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.InvalidException;
import calculator.StandardCalc;
import org.junit.Test;

public class TestStandardCalc {
  @Test
  //Test 1
  //Tests calculate returns expected value
  public void testCalculate() throws InvalidException {
    StandardCalc calc = new StandardCalc();
    float ans = calc.evaluate("( 5 * ( 6 + 7 ) ) - 2");
    assertEquals(63.0, ans, 0);
  }

  
  @Test
  //Test 2
  //Tests calculate throws exception
  public void testCalculateException() {
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
}
