import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class RotateRectangle extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) {
        
        Rectangle rect = new Rectangle(50, 50, 100, 100);
        rect.setFill(Color.BLUE);

        
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(rect);

        
        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction(event -> {
            rect.getTransforms().add(new Rotate(15, rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2));
        });

        
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pane, rotateButton);

        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotate Rectangle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}