package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.EmptyStackException;
import calculator.StrStack;

import org.junit.Test;

public class TestStrStack {

  @Test
  //Test 1
  //Tests creating a new StrStack and pushing a string to it
  public void testConstructorAndPush() {
    StrStack stack = new StrStack();
    stack.push("test");
  }

  @Test
  //Test 2
  //Tests that pop correctly pops and returns strings from the stack
  public void testPop() throws EmptyStackException {
    StrStack stack = new StrStack();
    stack.push("TestString");
    String str = stack.pop();
    assertEquals("TestString", str);
  }

  @Test
  //Test 3
  //Tests isEmpty method functions correctly
  public void testIsEmpty() throws EmptyStackException {
    StrStack stack = new StrStack();
    assertTrue(stack.isEmpty());
    stack.push("Test string");
    stack.pop();
    assertTrue(stack.isEmpty());
  }
}
