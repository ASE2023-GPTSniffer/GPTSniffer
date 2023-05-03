import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BinaryEditor extends JFrame {

    private JTextField fileNameTextField;
    private JTextArea binaryTextArea;
    private JButton openButton;
    private JButton saveButton;

    public BinaryEditor() {
        super("Binary Editor");
        initComponents();
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        fileNameTextField = new JTextField();
        fileNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        binaryTextArea = new JTextArea();
        binaryTextArea.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(binaryTextArea);

        openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(fileNameTextField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileNameTextField.setText(file.getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while ((i = fis.read()) != -1) {
                    sb.append(String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0'));
                    sb.append(" ");
                }
                binaryTextArea.setText(sb.toString());
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(file);
                String binaryText = binaryTextArea.getText().replaceAll("\\s", "");
                for (int i = 0; i < binaryText.length(); i += 8) {
                    String binaryByte = binaryText.substring(i, i + 8);
                    fos.write(Integer.parseInt(binaryByte, 2));
                }
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new BinaryEditor();
    }
}