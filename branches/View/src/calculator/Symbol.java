package calculator;

/**
 * This Enum represents the symbols in an equation.
 */
public enum Symbol {
  
  LEFT_BRACKET('('), RIGHT_BRACKET(')'), TIMES('*'),
  DIVIDE('/'),PLUS('+'), MINUS('-'), INVALID('\u0000'),
  ALTTIMES('×'), ALTDIVIDE('÷');
  
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

  /**
   * Converts a string to a Symbol.
   *
   * @param str The string to convert
   * @returns the Symbol enum
   */
  public static Symbol valueOfChar(String str) {
    for (Symbol s : values()) {
      if (s.character == (str.charAt(0)) && str.length() == 1) {
        return s;
      }
    }
    return null;
  }
}
