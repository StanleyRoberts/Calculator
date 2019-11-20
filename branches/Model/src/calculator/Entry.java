package calculator;

/**
 * An Entry is a numeric value, a symbol representing
 * an operation (eg '*' or '/') or a string.
 * 
 * @author Stanley Roberts
 * 
 */
public class Entry {

  /** The float associated with the entry. */
  private float number;
  
  /** The symbol associated with the entry. */
  private Symbol symbol;
  
  /** The string associated with the entry. */
  private String string;
  
  /** The type of the associated variable. */
  private Type type;

  /**
   * Instantiates a new entry with a float value.
   *
   * @param value The number to store.
   */
  public Entry(float value) {
    type = Type.NUMBER;
    this.number = value;
  }

  /**
   * Instantiates a new entry with a Symbol value.
   *
   * @param symbol The symbol to store
   */
  public Entry(Symbol symbol) {
    type = Type.SYMBOL;
    this.symbol = symbol;
  }
  
  /**
   * Instantiates a new entry with a String value.
   *
   * @param string The string to store
   */
  public Entry(String string) {
    type = Type.STRING;
    this.string = string;
  }

  /**
   * Gets the float value associated with the entry.
   *
   * @throws BadTypeException thrown if stored value is not of type Number
   * @returns the float value associated with the entry
   */
  public float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("Expected Entry of type Type.NUMBER");
    }
    return number;
  }

  /**
   * Gets the Symbol associated with the entry.
   *
   * @throws BadTypeException thrown if stored value is not of type Symbol
   * @returns the Symbol value associated with the entry
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Expected Entry of type Type.SYMBOL");
    }
    return symbol;
  }

  /**
   * Gets the String value associated with the entry.
   *
   * @throws BadTypeException thrown if stored value is not of type String
   * @returns the String value associated with the entry
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("Expected Entry of type Type.STRING");
    }
    return string;
  }
  
  /** TODO
   * Gets the type of the stored value of the entry.
   *
   * @returns the type of the stored value of the entry
   */
  public Type getType() {
    return type;
  }
}
