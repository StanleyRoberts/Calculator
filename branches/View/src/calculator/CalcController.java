package calculator;

import calculator.CalcView;

/**
 * The Class CalcController oberseves a view and
 * provides interaction with the CalcModel for that view.
 */
public class CalcController {
  
  /** The model that provides the ability to evaluate expression. */
  private CalcModel model = new CalcModel();
  
  /** The view to observe. */
  private CalcView view = null;
  
  /** If the view is currently in infix notation or not. */
  private boolean isInfix = true;
  
  /**
   * Evaluates an expression using the CalcModel and
   * then sets the answer of the view to the correct answer.
   */
  private void calculate() {
    try {
      view.setAnswer(Float.toString(model.evaluate(view.getExpression(), isInfix)));
    } catch (InvalidException e) {
      view.setAnswer("Whoops! We didn't quite understand that expression. "
          + "Please make sure you are using the correct notation and try again");
    }
  }
  
  /**
   * Expression type changes the notation used to evaluate the expression.
   *
   * @param type the notation to change to (infix/postfix)
   */
  private void expressionType(OpType type) {
    if (type == OpType.INFIX) {
      isInfix = true;
    } else {
      isInfix = false;
    }
    view.setAnswer("Changed to " + type);
  }
  
  /**
   * Instantiates a new calc controller and creates observers for the view.
   *
   * @param view the view to create observers for
   */
  public CalcController(CalcView view) {
    this.view = view;
    view.addCalcObserver(this::calculate);
    view.addTypeObserver(this::expressionType);
  }
}
