package calculator;

@SuppressWarnings("serial")
public class BadTypeException extends Exception {
  public BadTypeException(String errorMessage) {
    super(errorMessage);
  }
}
