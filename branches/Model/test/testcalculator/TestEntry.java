package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.BadTypeException;
import calculator.Entry;
import calculator.Symbol;
import calculator.Type;

import org.junit.Test;


public class TestEntry {


  @Test
  //Test 1
  //Tests creating a new entry with a float value and testing the getValue method of entry
  public void testFloatConstructorAndGetValue() throws BadTypeException  {
    Entry test = new Entry(1);
    assertEquals(1, test.getValue(), 0f);
  }

  @Test
  //Test 2
  //Tests creating a new entry with a symbol value and testing the getSymbol method of entry
  public void testSymbolConstructorAndGetSymbol() throws BadTypeException {
    Entry test = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(Symbol.LEFT_BRACKET, test.getSymbol());
  }
  
  @Test
  //Test 3
  //Tests creating a new entry with a string value and testing the getString method of entry
  public void testStringConstructorAndGetString() throws BadTypeException {
    Entry test = new Entry("test");
    assertEquals("test", test.getString());
  }
  
  @Test
  //Test 4
  //Tests that the getType method returns the correct type for each entry
  public void testGetType() throws BadTypeException {
    Entry str = new Entry("test");
    assertEquals(Type.STRING, str.getType());
    Entry num = new Entry(5);
    assertEquals(Type.NUMBER, num.getType());
    Entry sym = new Entry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, sym.getType());
    
  }
  
  @Test
  //Test 5
  //Tests that the getValue method throws a BadTypeException when the
  //Entry does not have a value (incorrect type)
  public void testGetValueException()  {
    Entry test = new Entry("");
    boolean thrown = false;
    try {
      test.getValue();
    } catch (BadTypeException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  //Test 6
  //Tests that the getSymbol method throws a BadTypeException when the
  //Entry does not have a symbol (incorrect type)
  public void testGetSymbolException()  {
    Entry test = new Entry("");
    boolean thrown = false;
    try {
      test.getSymbol();
    } catch (BadTypeException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  //Test 7
  //Tests that the getString method throws a BadTypeException when
  //the Entry does not have a string (incorrect type)
  public void testGetStringException()  {
    Entry test = new Entry(1);
    boolean thrown = false;
    try {
      test.getString();
    } catch (BadTypeException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
}
