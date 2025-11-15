package NumberCounter;

import javax.swing.*;
import java.awt.*;

public class NumberCounter extends JFrame {
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;
    private int count = 0;

    public NumberCounter() {
        // Set up the frame
        setTitle("Number Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        // Create and configure the count label
        countLabel = new JLabel("0");
        countLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setPreferredSize(new Dimension(300, 40));

        // Create the decrease button
        decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });

        // Create the increase button
        increaseButton = new JButton("Increase");
        increaseButton.addActionListener(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });

        // Add components to the frame
        add(countLabel);
        add(decreaseButton);
        add(increaseButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> new NumberCounter());
    }
}