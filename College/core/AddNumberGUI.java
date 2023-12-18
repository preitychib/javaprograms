import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNumberGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CalculatorPanel calculatorPanel = new CalculatorPanel();
            frame.getContentPane().add(calculatorPanel);

            frame.setSize(300, 150);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class CalculatorPanel extends JPanel {

    private JTextField textFieldA;
    private JTextField textFieldB;
    private JLabel resultLabel;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        // Panel for input of variable 'a'
        JPanel panelA = createInputPanel("Enter value for 'a':");
        // Panel for input of variable 'b'
        JPanel panelB = createInputPanel("Enter value for 'b':");

        // Panel for the button and result
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        resultLabel = new JLabel("Result: ");
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(resultLabel);

        // Add ActionListener to the button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        // Get values from text fields
                        int a = Integer.parseInt(textFieldA.getText());
                        int b = Integer.parseInt(textFieldB.getText());

                        // Calculate and display the result
                        int result = a + b;
                        resultLabel.setText("Result: " + result);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input (non-numeric)
                        resultLabel.setText("Result: Invalid input");
                    }
                });
            }
        });

        // Add panels to the CalculatorPanel
        add(panelA, BorderLayout.NORTH);
        add(panelB, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(10);
        panel.add(label);
        panel.add(textField);
        if (labelText.contains("'a'")) {
            textFieldA = textField;
        } else if (labelText.contains("'b'")) {
            textFieldB = textField;
        }
        return panel;
    }
}
