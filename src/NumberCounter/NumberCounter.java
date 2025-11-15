package NumberCounter;

import javax.swing.*;
import java.awt.*;

public class NumberCounter extends JFrame {
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;
    private int count = 0;

    public NumberCounter() {
        setTitle("Number Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        countLabel = new JLabel("0");
        countLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setPreferredSize(new Dimension(300, 40));

        decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });

        increaseButton = new JButton("Increase");
        increaseButton.addActionListener(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });

        add(countLabel);
        add(decreaseButton);
        add(increaseButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberCounter());
    }
}