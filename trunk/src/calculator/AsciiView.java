package calculator;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * AsciiView is a command line user interface for a calculator.
 */
public class AsciiView implements CalcView {
  
  /** The observer that watches for when a calculation is required. */
  private Observer calc;
  
  /** The observer that watches for a change in notation (postfix/infix). */
  private Consumer<OpType> type;
  
  /** The question to be evaluated. */
  private String question;
  
  /** The answer/message to print after a command is completed. */
  private String answer;
  
  /**
   * The menu for the user interface.
   */
  public void menu() {
    boolean quit = false;
    Scanner scanner = new Scanner(System.in);
    help();
    System.out.println(answer);
    
    while (!quit) {
      String input = scanner.nextLine();
      switch (input.charAt(0)) {
        case 'e':
        case 'E':
          System.out.println("Please type your question: ");
          question = scanner.nextLine();
          calc.tell();
          break;
        case 'p':
        case 'P':
          type.accept(OpType.POSTFIX);
          break;
        case 'i':
        case 'I':
          type.accept(OpType.INFIX);
          break;
        case 'q':
        case 'Q':
          quit = true;
          answer = "Quitting...";
          break;
        default:
          answer = "Whoops! We didn't quite understand that command.\nPlease try again"
              + "\n(Type help for help)";
      }
      if (input.replaceAll("\\s+", "").toLowerCase().equals("help")) {
        help();
      }
      System.out.println(answer);
    }
    scanner.close();
  }

  private void help() {
    answer = "Welcome to the calculator!\nType E to enter a expression\n"
        + "Type P to switch to postfix\nType I to switch to infix\nType Q to quit";  
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#getExpression()
   */
  @Override
  public String getExpression() {
    return question;
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#setAnswer(java.lang.String)
   */
  @Override
  public void setAnswer(String str) {
    answer = str;
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#addCalcObserver(calculator.Observer)
   */
  @Override
  public void addCalcObserver(Observer c) {
    calc = c;
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#addTypeObserver(java.util.function.Consumer)
   */
  @Override
  public void addTypeObserver(Consumer<OpType> t) {
    type = t;
  }
}
