package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.EmptyStackException;
import calculator.OpStack;
import calculator.Symbol;

import org.junit.Test;

public class TestOpStack {

  @Test
  //Test 1
  //Tests creating a new OpStack and pushing a Symbol to it
  public void testConstructorAndPush() {
    OpStack stack = new OpStack();
    stack.push(Symbol.LEFT_BRACKET);
    stack.push(Symbol.PLUS);
  }

  @Test
  //Test 2
  //Tests that pop correctly pops and returns Symbols from the stack
  public void testPop() throws EmptyStackException {
    OpStack stack = new OpStack();
    stack.push(Symbol.TIMES);
    Symbol symbol = stack.pop();
    assertEquals(Symbol.TIMES, symbol);
  }

  @Test
  //Test 3
  //Tests isEmpty method functions correctly
  public void testIsEmpty() throws EmptyStackException {
    OpStack stack = new OpStack();
    assertTrue(stack.isEmpty());
    stack.push(Symbol.RIGHT_BRACKET);
    stack.pop();
    assertTrue(stack.isEmpty());
  }
}
