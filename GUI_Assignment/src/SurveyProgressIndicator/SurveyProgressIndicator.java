package SurveyProgressIndicator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SurveyProgressIndicator extends JFrame {
    private JProgressBar progressBar;
    private JTextField nameField;
    private JTextField birthField;
    private JTextField genderField;
    private JTextField numberField;
    private JTextField emailField;
    private JButton submitButton;
    private JLabel messageLabel;

    public SurveyProgressIndicator() {

        setTitle("Survey Progress Indicator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(false);
        progressBar.setPreferredSize(new Dimension(400, 25));
        progressBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        progressBar.setForeground(new Color(255, 140, 0)); // Orange color
        mainPanel.add(progressBar);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));


        nameField = createFormField(mainPanel, "Full Name:");
        birthField = createFormField(mainPanel, "Date of Birth:");
        genderField = createFormField(mainPanel, "Gender:");
        numberField = createFormField(mainPanel, "Contact Number:");
        emailField = createFormField(mainPanel, "Email Address:");

        addDocumentListener(nameField);
        addDocumentListener(birthField);
        addDocumentListener(genderField);
        addDocumentListener(numberField);
        addDocumentListener(emailField);

        messageLabel = new JLabel("");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(messageLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 30));
        submitButton.addActionListener(e -> handleSubmit());
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        buttonPanel.add(submitButton);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JTextField createFormField(JPanel panel, String labelText) {
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        containerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField textField = new JTextField(30);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        centerPanel.add(label);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        centerPanel.add(textField);

        containerPanel.add(centerPanel);

        panel.add(containerPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        return textField;
    }

    private void addDocumentListener(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgress();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgress();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgress();
            }
        });
    }

    private void updateProgress() {
        int filledFields = 0;
        int totalFields = 5;

        if (!nameField.getText().trim().isEmpty()) filledFields++;
        if (!birthField.getText().trim().isEmpty()) filledFields++;
        if (!genderField.getText().trim().isEmpty()) filledFields++;
        if (!numberField.getText().trim().isEmpty()) filledFields++;
        if (!emailField.getText().trim().isEmpty()) filledFields++;

        int progressValue = (filledFields * 100) / totalFields;
        progressBar.setValue(progressValue);

        messageLabel.setText("");
    }

    private void handleSubmit() {
        if (nameField.getText().trim().isEmpty() ||
                birthField.getText().trim().isEmpty() ||
                genderField.getText().trim().isEmpty() ||
                numberField.getText().trim().isEmpty() ||
                emailField.getText().trim().isEmpty()) {

            messageLabel.setText("All fields are required");
            messageLabel.setForeground(Color.BLACK);
        } else {
            messageLabel.setText("Thank you for answering");
            messageLabel.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SurveyProgressIndicator());
    }
}