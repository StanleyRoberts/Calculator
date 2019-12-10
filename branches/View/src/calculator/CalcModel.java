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
   * @throws ArithmeticOverflowException thrown if arithmetic overflow occurs
   * @throws DivisionByZeroException thrown if division by zero is attempted
   */
  public float evaluate(String str, boolean isInfix) throws InvalidException,
        DivisionByZeroException, ArithmeticOverflowException {
    
    str = addSpaces(str);
    
    if (isInfix) {
      return infix.evaluate(str);
    } else {
      return postfix.evaluate(str);
    }
  }
  
  /**
   * Takes a string and puts space around all the operators.
   * Takes care to check if minus sign is indication of negative number or is an operator
   *
   * @param str the string to add spaces to
   * @return the final string with spaces around operators
   */
  private String addSpaces(String str) {
    String newstring = "";
    boolean previouscharisnum = false;
    for (int i = 0; i < str.length(); i++) { 
      if (Symbol.valueOfChar(String.valueOf(str.charAt(i))) != null) {
        if (str.charAt(i) == '-' && previouscharisnum == false) {
          newstring += " " + str.charAt(i);
        } else {
          newstring += " " + str.charAt(i) + " ";
        }
        if (str.charAt(i) != '(' && str.charAt(i) != ')') {
          previouscharisnum = false;
        }
      } else {
        newstring += str.charAt(i);
        if (Character.isDigit(str.charAt(i))) {
          previouscharisnum = true;
        }
      }
    }
    return newstring;
  }
}
