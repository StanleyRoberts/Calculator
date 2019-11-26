package calculator;

import java.util.Scanner;

public class RevPolishCalc implements Calculator {

  NumStack values = new NumStack();
  
  @Override
  public float evaluate(String str) throws InvalidException {
    Scanner scanner = new Scanner(str);
    
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
            case "*":
              values.push(values.pop() * values.pop());
              break;
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
      return values.pop();
    } catch (EmptyStackException e) {
      throw new InvalidException();
    }
  }

}
