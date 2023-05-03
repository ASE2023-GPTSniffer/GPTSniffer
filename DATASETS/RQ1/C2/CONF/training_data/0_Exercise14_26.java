import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TwoClocks extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create two ClockPane objects with the specified time values
        ClockPane clock1 = new ClockPane(4, 20, 45);
        ClockPane clock2 = new ClockPane(22, 46, 15);

        // create an HBox to hold the two clocks side by side
        HBox hbox = new HBox(clock1, clock2);

        // create a scene and add the HBox to it
        Scene scene = new Scene(hbox, 600, 300);

        // set the title of the stage and show it
        primaryStage.setTitle("Two Clocks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
