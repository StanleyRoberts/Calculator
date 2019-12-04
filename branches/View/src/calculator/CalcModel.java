package calculator;

/**
 * The Class CalcModel manages multiples calculators
 * (postfix and infix) and evaluates expression using them.
 */
public class CalcModel {
  
  /** The postfix calculator implementation. */
  private RevPolishCalc postfix = new RevPolishCalc();
  
  /** The infix calculator implementation. */
  private StandardCalc infix = new StandardCalc();
  
  /**
   * Evaluates a string, in either postfix or infix notation, and returns the result.
   *
   * @param str the string to evaluate
   * @param isInfix if the string is in infix notation (false means postfix)
   * @return the result of the evaluated string
   * @throws InvalidException if the string is not a correct notation throws an InvalidException
   */
  public float evaluate(String str, boolean isInfix) throws InvalidException {
    String newstring = "";
    for (int i = 0; i < str.length(); i++) {
      newstring += " " + str.charAt(i);
    }
    if (isInfix) {
      return infix.evaluate(newstring);
    } else {
      return postfix.evaluate(newstring);
    }
  }
}
