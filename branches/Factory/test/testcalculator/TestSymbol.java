package testcalculator;

import static org.junit.Assert.assertEquals;

import calculator.Symbol;

import org.junit.Test;

public class TestSymbol {

  @SuppressWarnings("unused")
  @Test
  //Test 1
  //Tests that an enum type exists for all required symbols
  public void testEnumValueExistance() {
    Symbol leftbracket = Symbol.LEFT_BRACKET;
    Symbol rightbracket = Symbol.RIGHT_BRACKET;
    Symbol times = Symbol.TIMES;
    Symbol divide = Symbol.DIVIDE;
    Symbol plus = Symbol.PLUS;
    Symbol minus = Symbol.MINUS;
    Symbol invalid = Symbol.INVALID;
  }
  
  @Test
  //Test 2
  //Tests that the enum value for each type is the appropriate unicode character
  //and that that the toString method uses this value
  public void testEnumToString() {
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")");
    assertEquals(Symbol.TIMES.toString(), "*");
    assertEquals(Symbol.DIVIDE.toString(), "/");
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.MINUS.toString(), "-");
    assertEquals(Symbol.INVALID.toString(), "\u0000");
  }
}
