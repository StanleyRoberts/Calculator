package calculator;

import java.util.function.Consumer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 * The Class GuiView which is a GUI for a calculator.
 */
public class GuiView implements CalcView {

  /** The answer to the expression. */
  @FXML
  private Text answer;

  /** The question to evaluate. */
  @FXML
  private TextField question;

  /** The calculate button. */
  @FXML
  private Button calcbutton;

  /** The infix button. */
  @FXML
  private RadioButton infixbutton;

  /** The notation group which contains both infix and postfix buttons. */
  @FXML
  private ToggleGroup notation;

  /** The postfix button. */
  @FXML
  private RadioButton postfixbutton;

  /* (non-Javadoc)
   * @see calculator.CalcView#getExpression()
   */
  @Override
  public String getExpression() {
    return question.getText();
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#setAnswer(java.lang.String)
   */
  @Override
  public void setAnswer(String str) {
    answer.setText(str);
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#addCalcObserver(calculator.Observer)
   */
  @Override
  public void addCalcObserver(Observer c) {
    /* Calls calculate when calculate button pressed */
    calcbutton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        c.tell();
      }
    });
    /* Calls calculate when enter pressed while typing expression */
    question.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        c.tell();
      }
    });
  }

  /* (non-Javadoc)
   * @see calculator.CalcView#addTypeObserver(java.util.function.Consumer)
   */
  @Override
  public void addTypeObserver(Consumer<OpType> t) {
    notation.selectedToggleProperty().addListener(
        new ChangeListener<Toggle>() {
          @Override
          public void changed(ObservableValue<? extends Toggle> observable,
              Toggle from, Toggle to) {
            t.accept(to == infixbutton ? OpType.INFIX : OpType.POSTFIX);
          }
        });
  }
}
