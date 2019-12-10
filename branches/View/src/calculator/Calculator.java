package calculator;

/**
 * The Interface Calculator.
 */
interface Calculator {
  
  /**
   * Evaluates a string and returns the calculated value.
   *
   * @param str the string to evaluate
   * @return the calculated value
   * @throws InvalidException thrown when the string given is in an incorrect form
   */
  public float evaluate(String str) throws InvalidException,
        DivisionByZeroException, ArithmeticOverflowException;
}
