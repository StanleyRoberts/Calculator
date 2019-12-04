package calculator;

/**
 * This OpStack class manages a stack of symbols.
 * 
 * @author Stanley Roberts
 */
public class OpStack {

  /** The stack. */
  private Stack stack = new Stack();
  
  /**
   * Pushes a symbol to the stack.
   *
   * @param symbol the symbol to push to the stack
   */
  public void push(Symbol symbol) {
    stack.push(new Entry(symbol));
  }
  
  /**
   * Pops a value from the stack.
   *
   * @return the symbol popped from the stack
   * @throws EmptyStackException thrown if the stack is empty
   */
  public Symbol pop() throws EmptyStackException {
    try {
      return stack.pop().getSymbol();
    } catch (BadTypeException e) {
      //This should never be thrown since the managed stack should always only contain floats
      throw new RuntimeException("OpStack contained non-symbol Entries which it attempted to pop");
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
