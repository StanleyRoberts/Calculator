package calculator;

import java.util.Scanner;

public class StandardCalc implements Calculator {
  OpStack values;
  RevPolishCalc rpCalc;
  
  @Override
  public float evaluate(String str) throws InvalidException {
    String output = "";
    Scanner scanner = new Scanner(str);
    values = new OpStack();
    
    while (scanner.hasNext()) {
      if (scanner.hasNextFloat()) {
        output += " " + scanner.nextFloat();
      } else {
        String token = scanner.next();
        try {
          switch (token) {
            case "(":
              values.push(Symbol.LEFT_BRACKET);
              break;
            case ")":
              Symbol val = Symbol.INVALID;
              while (val != Symbol.LEFT_BRACKET) {
                val = values.pop();
                if (val != Symbol.LEFT_BRACKET) {
                  output += " " + val;
                }
              }
              break;
            case "*":
            case "/":
              Symbol val1 = Symbol.INVALID;
              while (val1 != Symbol.LEFT_BRACKET && val1 != Symbol.PLUS
                     && val1 != Symbol.MINUS && !values.isEmpty()) {
                val1 = values.pop();
                if (val1 == Symbol.LEFT_BRACKET) {
                  values.push(val1);
                } else {
                  output += " " + val1;
                }
              }
              values.push(Symbol.valueOfChar(token));
              break;
            case "+":
            case "-":
              Symbol val2 = Symbol.INVALID;
              while (val2 != Symbol.LEFT_BRACKET && !values.isEmpty()) {
                val2 = values.pop();
                if (val2 == Symbol.LEFT_BRACKET) {
                  values.push(val2);
                } else {
                  output += " " + val2;
                }
              }
              values.push(Symbol.valueOfChar(token)); 
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
    while (!values.isEmpty()) {
      try {
        Symbol val = values.pop();
        if (val != Symbol.LEFT_BRACKET && val != Symbol.RIGHT_BRACKET) {
          output += " " + val;
        } else {
          throw new InvalidException();
        }
      } catch (EmptyStackException e) {
        scanner.close();
        throw new InvalidException();
      }
    }
    scanner.close();
    rpCalc = new RevPolishCalc();
    return rpCalc.evaluate(output);
  }
}
