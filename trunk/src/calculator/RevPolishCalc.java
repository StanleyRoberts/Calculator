package calculator;

import java.util.Scanner;

/**
 * The Class RevPolishCalc evaluates strings that are in the reverse polish notation (postfix).
 */
public class RevPolishCalc implements Calculator {

  
  /** A stack of values required for processing a postfix string. */
  private NumStack values = new NumStack();
  
  /* (non-Javadoc)
   * @see calculator.Calculator#evaluate(java.lang.String)
   */
  @Override
  public float evaluate(String str) throws InvalidException {
    Scanner scanner = new Scanner(str);
    values = new NumStack();
    
    while (scanner.hasNext()) {
      if (scanner.hasNextFloat()) {
        values.push(scanner.nextFloat());
      } else {
        String token = scanner.next();
        try {
          switch (token) {
            case "+":
              values.push(values.pop() + values.pop());
              break;
            case "-":
              float val1 = values.pop();
              values.push(values.pop() - val1);
              break;
            case "×":
            case "*":
              values.push(values.pop() * values.pop());
              break;
            case "÷":
            case "/":
              float val2 = values.pop();
              values.push(values.pop() / val2);
              break;
            default:
              scanner.close();
              throw new InvalidException();
          }
        } catch (EmptyStackException e) {
          scanner.close();
          throw new InvalidException();
        }
      }
    }
    scanner.close();
    try {
      float val = values.pop();
      if (values.isEmpty()) {
        return val;
      } else {
        throw new InvalidException();
      }
    } catch (EmptyStackException e) {
      throw new InvalidException();
    }
  }

}
