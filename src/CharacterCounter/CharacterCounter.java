package CharacterCounter;

import javax.swing.*;
import java.awt.*;

public class CharacterCounter extends JFrame {
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter() {
        // Set up the frame
        setTitle("Character Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Create the main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and configure the text area with scroll pane
        messageTextArea = new JTextArea(10, 30);
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create bottom panel for input and button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        // Create label and text field for character input
        JLabel inputLabel = new JLabel("Enter character:");
        characterTextField = new JTextField(5);

        // Create the count button
        countButton = new JButton("Count");
        countButton.addActionListener(e -> countCharacter());

        // Add components to bottom panel
        bottomPanel.add(inputLabel);
        bottomPanel.add(characterTextField);
        bottomPanel.add(countButton);

        // Create panel for count display
        JPanel countPanel = new JPanel();
        countPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel countLabelText = new JLabel("Count:");
        countLabel = new JLabel("0");
        countPanel.add(countLabelText);
        countPanel.add(countLabel);

        // Create a panel to hold both bottom panels
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(bottomPanel);
        southPanel.add(countPanel);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private void countCharacter() {
        String text = messageTextArea.getText();
        String characterInput = characterTextField.getText();

        // Check if character input is empty or more than one character
        if (characterInput.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a character.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get the first character from input
        char targetChar = characterInput.charAt(0);

        // Count occurrences of the character
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                count++;
            }
        }

        // Display the count
        countLabel.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> new CharacterCounter());
    }
}