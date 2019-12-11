package calculator;

/**
 * This StrStack class manages a stack of strings.
 * 
 * @author Stanley Roberts
 */
public class StrStack {

  /** The stack. */
  private Stack stack = new Stack();
  
  /**
   * Pushes a string to the stack.
   *
   * @param str the string to push to the stack
   */
  public void push(String str) {
    stack.push(new Entry(str));
  }
  
  /**
   * Pops a value from the stack.
   *
   * @return the string popped from the stack
   * @throws EmptyStackException thrown if the stack is empty
   */
  public String pop() throws EmptyStackException {
    try {
      return stack.pop().getString();
    } catch (BadTypeException e) {
      //This should never be thrown since the managed stack should always only contain floats
      throw new RuntimeException("StrStack contained non-string Entries which it attempted to pop");
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
