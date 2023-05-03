

public class TwoCircles extends Application {

    private final int RADIUS = 15;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Group root = new Group();

        
        Random random = new Random();
        Circle circle1 = new Circle(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT), RADIUS, Color.RED);
        Circle circle2 = new Circle(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT), RADIUS, Color.BLUE);

        
        Point2D point1 = new Point2D(circle1.getCenterX(), circle1.getCenterY());
        Point2D point2 = new Point2D(circle2.getCenterX(), circle2.getCenterY());
        Point2D direction = point2.subtract(point1).normalize();
        Point2D offset1 = direction.multiply(RADIUS);
        Point2D offset2 = direction.multiply(-RADIUS);
        Point2D lineStart = point1.add(offset1);
        Point2D lineEnd = point2.add(offset2);

        
        Line line = new Line(lineStart.getX(), lineStart.getY(), lineEnd.getX(), lineEnd.getY());
        line.setStrokeWidth(2);
        line.setStroke(Color.GREEN);

        
        root.getChildren().addAll(circle1, circle2, line);

        
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Two Circles");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
