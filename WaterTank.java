import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class WaterTank extends JFrame {

    private JSlider waterSlider;
    private JLabel levelValueLabel;
    private JLabel alarmStatusLabel;

    public WaterTank() {
        setTitle("Water Tank Alarm System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Water Tank Monitoring System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel instructionLabel = new JLabel("Adjust Water Level (0 - 100):");
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(instructionLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Slider setup
        waterSlider = new JSlider(0, 100, 30); 
        waterSlider.setMajorTickSpacing(20);
        waterSlider.setMinorTickSpacing(5);
        waterSlider.setPaintTicks(true);
        waterSlider.setPaintLabels(true);
        centerPanel.add(waterSlider);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Current Level Text
        levelValueLabel = new JLabel("Current Water Level: 30");
        levelValueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        levelValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(levelValueLabel);

        add(centerPanel, BorderLayout.CENTER);

        //  Alarm Status Indicator
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        
        alarmStatusLabel = new JLabel("ALARM: OFF");
        alarmStatusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        alarmStatusLabel.setForeground(new Color(0, 150, 0)); // Green for OFF
        bottomPanel.add(alarmStatusLabel);

        add(bottomPanel, BorderLayout.SOUTH);
        waterSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int currentLevel = waterSlider.getValue();
                levelValueLabel.setText("Current Water Level: " + currentLevel);
                
                if (currentLevel > 60) {
                    alarmStatusLabel.setText("ALARM: ON");
                    alarmStatusLabel.setForeground(Color.RED);
                } else {
                    alarmStatusLabel.setText("ALARM: OFF");
                    alarmStatusLabel.setForeground(new Color(0, 150, 0));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WaterTank().setVisible(true);
            }
        });
    }
}
