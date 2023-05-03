import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CircleMove extends Application {

    @Override
    public void start(Stage primaryStage) {

        
        Circle circle = new Circle(150, 150, 50);
        circle.setFill(Color.RED);

        
        circle.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.UP) {
                circle.setCenterY(circle.getCenterY() - 10);
            } else if (keyCode == KeyCode.DOWN) {
                circle.setCenterY(circle.getCenterY() + 10);
            } else if (keyCode == KeyCode.LEFT) {
                circle.setCenterX(circle.getCenterX() - 10);
            } else if (keyCode == KeyCode.RIGHT) {
                circle.setCenterX(circle.getCenterX() + 10);
            }
        });

        
        circle.requestFocus();

        
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Move");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}