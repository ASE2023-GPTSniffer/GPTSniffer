import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClockExample extends JFrame {

    private JLabel timeLabel;

    public ClockExample() {
        JPanel panel = new JPanel();
        timeLabel = new JLabel();
        panel.add(timeLabel);
        add(panel);
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        updateTime();
    }

    public void updateTime() {
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        int hour = Integer.parseInt(hourTextField.getText());
                        int minute = Integer.parseInt(minuteTextField.getText());
                        int second = Integer.parseInt(secondTextField.getText());
                        Calendar calendar = new GregorianCalendar();
                        calendar.set(Calendar.HOUR_OF_DAY, hour);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, second);
                        Date time = calendar.getTime();
                        timeLabel.setText(time.toString());
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        new ClockExample();
    }

    private JTextField hourTextField, minuteTextField, secondTextField;

    public ClockExample() {
        JPanel panel = new JPanel();
        hourTextField = new JTextField("0", 2);
        minuteTextField = new JTextField("0", 2);
        secondTextField = new JTextField("0", 2);
        panel.add(hourTextField);
        panel.add(minuteTextField);
        panel.add(secondTextField);
        add(panel, BorderLayout.NORTH);
        timeLabel = new JLabel();
        panel.add(timeLabel);
        add(panel, BorderLayout.CENTER);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        updateTime();
    }

}
