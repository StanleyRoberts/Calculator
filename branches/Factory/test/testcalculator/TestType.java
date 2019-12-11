package testcalculator;

import calculator.Type;

import org.junit.Test;

public class TestType {

  @SuppressWarnings("unused")
  @Test
  //Test 1
  //Tests that an enum type exists for all required types
  public void testEnumValueExistance() {
    Type number = Type.NUMBER;
    Type symbol = Type.SYMBOL;
    Type string = Type.STRING;
    Type invald = Type.INVALD;
  }
}
