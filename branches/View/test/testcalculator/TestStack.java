package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calculator.EmptyStackException;
import calculator.Entry;
import calculator.Stack;
import calculator.Symbol;

import org.junit.Test;

public class TestStack {

  @Test
  //Test 1
  //Tests creating a new stack and pushing an entry to it
  public void testConstructorAndPush() {
    Stack stack = new Stack();
    Entry entry = new Entry(5);
    stack.push(entry);
  }
  
  @Test
  //Test 2
  //Tests the size function return the expected values and
  //that pop correctly pops and returns entries from the stack
  public void testPopAndSize() throws EmptyStackException {
    Stack stack = new Stack();
    Entry entrynum = new Entry(5);
    Entry entrysym = new Entry(Symbol.DIVIDE);
    Entry entrystr = new Entry("test");
    stack.push(entrynum);
    stack.push(entrysym);
    stack.push(entrystr);
    assertEquals(3, stack.size());
    Entry newentry = stack.pop();
    assertEquals(newentry, entrystr);
    assertEquals(2, stack.size());
  }
  
  @Test
  //Test 3
  //Tests that the top function correctly returns the top entry on the stack
  public void testTop() throws EmptyStackException {
    Stack stack = new Stack();
    Entry entryone = new Entry(5);
    Entry entrytwo = new Entry(3);
    stack.push(entryone);
    stack.push(entrytwo);
    assertEquals(entrytwo, stack.top());
  }
  
  @Test
  //Test 4
  //Tests that the pop function will throw an EmptyStackException if the stack is empty
  public void testPopException() {
    Stack stack = new Stack();
    boolean thrown = false;
    try {
      stack.pop();
    } catch (EmptyStackException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  
  @Test
  //Test 5
  //Tests that the top function will throw an EmptyStackException if the stack is empty
  public void testTopException() {
    Stack stack = new Stack();
    boolean thrown = false;
    try {
      stack.top();
    } catch (EmptyStackException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
  

}
