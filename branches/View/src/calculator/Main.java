package calculator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class Main which runs on program launch.
 */
public class Main extends Application {
  
  /** The loader. */
  static FXMLLoader loader;
  
  /** The root. */
  static Parent root;
  
  /* (non-Javadoc)
   * @see javafx.application.Application#start(javafx.stage.Stage)
   */
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }

  /**
   * The main method which launches the correct view.
   * Launches in ASCII mode if there is a console (ie run from a command line)
   *
   * @param args the arguments the program is run with
   * @throws IOException Signals that an I/O exception has occurred in loading the FXMLLoader
   */
  public static void main(String[] args) throws IOException {
    CalcView v;
    if (System.console() == null) {
      loader = new FXMLLoader(calculator.Main.class.getResource("GuiConfig.fxml"));
      root = loader.load();
      v = loader.getController();
      new CalcController(v);
      launch(args);
    } else {
      v = new AsciiView();
      new CalcController(v);
      ((AsciiView) v).menu();
    }
  }
}
