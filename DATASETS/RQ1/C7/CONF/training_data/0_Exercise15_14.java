
public class PolygonMouseHover {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Mouse Hover");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(10, 10, 200, 30);
        panel.add(messageLabel);

        int[] xPoints = {40, 70, 60, 45, 20};
        int[] yPoints = {20, 40, 80, 45, 60};
        Polygon polygon = new Polygon(xPoints, yPoints, 5);

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (polygon.contains(e.getX(), e.getY())) {
                    messageLabel.setText("Mouse pointer is inside the polygon.");
                } else {
                    messageLabel.setText("Mouse pointer is outside the polygon.");
                }
            }
        });

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
