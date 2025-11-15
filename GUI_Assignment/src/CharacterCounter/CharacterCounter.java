package CharacterCounter;

import javax.swing.*;
import java.awt.*;

public class CharacterCounter extends JFrame {
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter() {
        setTitle("Character Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        messageTextArea = new JTextArea(10, 30);
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JLabel inputLabel = new JLabel("Enter character:");
        characterTextField = new JTextField(5);

        countButton = new JButton("Count");
        countButton.addActionListener(e -> countCharacter());

        bottomPanel.add(inputLabel);
        bottomPanel.add(characterTextField);
        bottomPanel.add(countButton);

        JPanel countPanel = new JPanel();
        countPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel countLabelText = new JLabel("Count:");
        countLabel = new JLabel("0");
        countPanel.add(countLabelText);
        countPanel.add(countLabel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(bottomPanel);
        southPanel.add(countPanel);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private void countCharacter() {
        String text = messageTextArea.getText();
        String characterInput = characterTextField.getText();

        if (characterInput.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a character.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        char targetChar = characterInput.charAt(0);

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                count++;
            }
        }
        countLabel.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CharacterCounter());
    }
}