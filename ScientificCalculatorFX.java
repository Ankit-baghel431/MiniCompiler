import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ScientificCalculatorFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scientific Calculator (JavaFX)");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter expression (e.g., sin(30) + log(100))");

        Button evalButton = new Button("Evaluate");
        Label resultLabel = new Label("Result: ");

        evalButton.setOnAction(e -> {
            String input = inputField.getText();
            try {
                Lexer lexer = new Lexer(input);
                Parser parser = new Parser(lexer);
                double result = parser.parse();
                resultLabel.setText("Result: " + result);
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        layout.getChildren().addAll(inputField, evalButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}