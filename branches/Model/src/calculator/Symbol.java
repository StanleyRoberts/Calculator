package calculator;

/**
 * This Enum represents the symbols in an equation.
 */
public enum Symbol {
  
  LEFT_BRACKET('('), RIGHT_BRACKET(')'), TIMES('*'),
  DIVIDE('/'),PLUS('+'), MINUS('-'), INVALID('\u0000');
  
  /** The character associated with the enum. */
  final char character;
  
  /**
   * Instantiates a new symbol.
   *
   * @param value The character of the enum
   */
  private Symbol(char character) {
    this.character = character;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  public String toString() {
    return String.valueOf(character);
  }
}
