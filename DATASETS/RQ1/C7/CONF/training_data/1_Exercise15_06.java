



public class ChangeTextOnMouseClick{
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Text text = new Text("Java is fun");
        pane.getChildren().add(text);

        pane.setOnMouseClicked(e -> {
            if (text.getText().equals("Java is fun")) {
                text.setText("Java is powerful");
            } else {
                text.setText("Java is fun");
            }
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
