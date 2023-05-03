import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GridDisplay extends Application {
    
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);
        
        double width = scene.getWidth();
        double height = scene.getHeight();
        double lineLength = 0.9 * Math.min(width, height) / 3;
        double x0 = 0.5 * (width - lineLength);
        double y0 = 0.5 * (height - lineLength);
        
        for (int i = 0; i < 4; i++) {
            Line line1 = new Line(x0 + i * lineLength, y0, x0 + i * lineLength, y0 + 3 * lineLength);
            line1.setStroke(Color.RED);
            Line line2 = new Line(x0, y0 + i * lineLength, x0 + 3 * lineLength, y0 + i * lineLength);
            line2.setStroke(Color.BLUE);
            root.getChildren().addAll(line1, line2);
        }
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}