package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.EmptyStackException;
import calculator.NumStack;
import org.junit.Test;

public class TestNumStack {

  @Test
  //Test 1
  //Tests creating a new NumStack and pushing a float to it
  public void testConstructorAndPush() {
    NumStack stack = new NumStack();
    stack.push(5);
    stack.push((float) 13.2);
  }

  @Test
  //Test 2
  //Tests that pop correctly pops and returns floats from the stack
  public void testPop() throws EmptyStackException {
    NumStack stack = new NumStack();
    stack.push(7);
    float value = stack.pop();
    assertEquals(7, value, 0);
  }

  @Test
  //Test 3
  //Tests isEmpty method functions correctly
  public void testIsEmpty() throws EmptyStackException {
    NumStack stack = new NumStack();
    assertTrue(stack.isEmpty());
    stack.push(3);
    stack.pop();
    assertTrue(stack.isEmpty());
  }
}
