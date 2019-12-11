package calculator;

import java.util.LinkedList;
import java.util.List;


/**
 * This Stack class manages a stack of Entries.
 * 
 * @author Stanley Roberts
 */
public class Stack {
  
  /** The number of items in the stack. */
  private int size;
  
  /** The list of entries in the stack. */
  private List<Entry> list = new LinkedList<>();
  
  /**
   * Instantiates a new empty stack.
   */
  public Stack() {
    size = 0;
  }
  
  /**
   * Pushes an entry to the stack.
   *
   * @param entry The entry to push onto the stack
   */
  public void push(Entry entry) {
    list.add(entry);
    size += 1;
  }
  
  /**
   * Gets the size of the stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return size;
  }
  
  /**
   * Pops a entry off the stack.
   *
   * @return The entry that was popped
   * @throws EmptyStackException thrown if the stack is empty
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return list.remove(--size);
  }

  /**
   * Returns the top entry of the stack.
   *
   * @return The top entry of the stack
   * @throws EmptyStackException thrown if the stack is empty
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry copy = list.get(size - 1);
    return copy;
  }
}
