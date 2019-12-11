package calculator;

import java.util.function.Consumer;

/**
 * The Interface CalcView which is an interface for a UI for a calculator.
 */
interface CalcView {
  
  /**
   * Gets the expression to evaluate.
   *
   * @return the expression
   */
  public String getExpression();
  
  /**
   * Sets the answer.
   *
   * @param str the new answer
   */
  public void setAnswer(String str);
  
  /**
   * Adds the calc observer which watches for when a calculation is required.
   *
   * @param c the calc observer
   */
  public void addCalcObserver(Observer c);
  
  /**
   * Adds the type observer which watches for when notation changes.
   *
   * @param t the type observer
   */
  public void addTypeObserver(Consumer<OpType> t);
}

