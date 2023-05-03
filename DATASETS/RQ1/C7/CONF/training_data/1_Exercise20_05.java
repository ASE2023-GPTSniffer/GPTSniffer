




public class nan{

    @Override
    public void start(Stage primaryStage) throws Exception {
        MulitpleBallPane multiBallPane = new MulitpleBallPane();

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button suspendButton = new Button("Suspend");
        Button resumeButton = new Button("Resume");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(suspendButton, resumeButton, addButton, subtractButton);
        hBox.setAlignment(Pos.CENTER);

        addButton.setOnAction(ev1 -> {
            multiBallPane.addOne();
        });
        subtractButton.setOnAction(ev2 -> {
            multiBallPane.removeOne();
        });

        multiBallPane.setOnMouseClicked(event -> {
            multiBallPane.reactToMouseClick(event.getX(), event.getY());
        });

        suspendButton.setOnAction(e -> multiBallPane.pause());
        resumeButton.setOnAction(e -> multiBallPane.play());

        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        multiBallPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(multiBallPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 450, 350);
        primaryStage.setResizable(false);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private class MulitpleBallPane extends Pane {
        public BallOverlapComparator overlapComparator;
        private Timeline animation;

        MulitpleBallPane() {
            animation = new Timeline(new KeyFrame(Duration.millis(50), event -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
            overlapComparator = new BallOverlapComparator();
        }

        public void addOne() {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            getChildren().add(new Ball(30, 30, 20, color));
        }

        public void removeOne() {
            if (getChildren().size() > 0) {
                getChildren().remove(getChildren().size() - 1);
            }
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void reactToMouseClick(double x, double y) {
            for (int i = 0; i < this.getChildren().size(); i++) {
                Ball ball = (Ball) this.getChildren().get(i);
                double centerDistanceFromClick =
                        Math.sqrt(Math.pow(Math.abs(x - ball.getCenterX()), 2) + Math.pow(Math.abs(y - ball.getCenterY()), 2));
                if (centerDistanceFromClick <= ball.getRadius()) {
                    this.getChildren().remove(i);
                }
            }

        }

        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }


        protected void moveBall() {
            for (int i = 0; i < this.getChildren().size(); i++) {
                Ball ball = (Ball) this.getChildren().get(i);
                
                if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1; 
                }
                if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1; 
                }
                
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());

                for (int j = 0; j < this.getChildren().size(); j++) {
                    Ball otherBall = (Ball) this.getChildren().get(j);
                    if (i == j) { 
                        continue; 
                    }
                    int touching = overlapComparator.compare(ball, otherBall);
                    if (touching == 1 || touching == 0) {
                        double currentRadius = ball.getRadius();
                        ball.setRadius(currentRadius + otherBall.getRadius());
                        this.getChildren().remove(j);
                        
                        if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
                            ball.dx *= -1; 
                        }
                        if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
                            ball.dy *= -1; 
                            
                            ball.setCenterX(ball.dx + ball.getCenterX());
                            ball.setCenterY(ball.dy + ball.getCenterY());
                        }
                    }
                }
            }
        }

    }
}

class Ball extends Circle implements Comparable<Ball> {
    double dx = 1, dy = 1;

    Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setFill(color);
    }

    @Override
    public int compareTo(Ball that) {
        if (this.getCenterX() < that.getCenterX()) {
            return -1;
        } else if (this.getCenterX() > that.getCenterX()) {
            return 1;
        } else {
            if (this.getCenterY() < that.getCenterY()) {
                return -1;
            } else if (this.getCenterY() > that.getCenterY()) {
                return 1;
            }
        }
        return 0;

    }
}

class BallOverlapComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball b1, Ball b2) {
        double distanceSquared = (b1.getCenterX() - b2.getCenterX()) * (b1.getCenterX() - b2.getCenterX()) +
                (b1.getCenterY() - b2.getCenterY()) * (b1.getCenterY() - b2.getCenterY());
        double radiusSumSquared = (b1.getRadius() + b2.getRadius()) * (b1.getRadius() + b2.getRadius());
        if (distanceSquared == radiusSumSquared) {
            return 1;
        } else if (distanceSquared > radiusSumSquared) {
            return -1;
        } else {
            return 0;
        }
    }
}
