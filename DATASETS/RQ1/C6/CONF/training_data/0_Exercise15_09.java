import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LineDrawing extends Application {

    private double centerX;
    private double centerY;
    private double currentX;
    private double currentY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        
        centerX = canvas.getWidth() / 2;
        centerY = canvas.getHeight() / 2;
        currentX = centerX;
        currentY = centerY;

        
        Pane root = new Pane(canvas);

        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case RIGHT:
                    drawLine(gc, currentX, currentY, currentX + 50, currentY);
                    currentX += 50;
                    break;
                case UP:
                    drawLine(gc, currentX, currentY, currentX, currentY - 50);
                    currentY -= 50;
                    break;
                case LEFT:
                    drawLine(gc, currentX, currentY, currentX - 50, currentY);
                    currentX -= 50;
                    break;
                case DOWN:
                    drawLine(gc, currentX, currentY, currentX, currentY + 50);
                    currentY += 50;
                    break;
            }
        });
    }

    private void drawLine(GraphicsContext gc, double startX, double startY, double endX, double endY) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(startX, startY, endX, endY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}