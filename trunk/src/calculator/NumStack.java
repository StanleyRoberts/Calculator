package calculator;

/**
 * This NumStack class manages a stack of floats.
 * 
 * @author Stanley Roberts
 */
public class NumStack {

  /** The stack. */
  private Stack stack = new Stack();
  
  /**
   * Pushes a value to the stack.
   *
   * @param value the float to push to the stack
   */
  public void push(float value) {
    stack.push(new Entry(value));
  }
  
  /**
   * Pops a value from the stack.
   *
   * @return the float popped from the stack
   * @throws EmptyStackException thrown if the stack is empty
   */
  public float pop() throws EmptyStackException {
    try {
      return stack.pop().getValue();
    } catch (BadTypeException e) {
      //This should never be thrown since the managed stack should always only contain floats
      throw new RuntimeException("NumStack contained non-float Entries which it attempted to pop");
    }
  }

  /**
   * Checks if the stack is empty.
   *
   * @return if the stack is empty
   */
  public boolean isEmpty() {
    return stack.size() == 0;
  }

}
