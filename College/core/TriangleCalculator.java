import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriangleCalculator{

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
    private JTextField textFieldC;
    private JLabel resultLabel;

    public CalculatorPanel() {
        setLayout(new GridLayout(4,0));

        // Panel for input of variable 'a'
        JPanel panelA = createInputPanel("Enter value for 'a':");
        // Panel for input of variable 'b'
        JPanel panelB = createInputPanel("Enter value for 'b':");
        // Panel for input of variable 'c'
        JPanel panelC = createInputPanel("Enter value for 'c':");

        // Panel for the button and result
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton areaButton = new JButton("Area");
        JButton perimeterButton = new JButton("Perimeter");
        resultLabel = new JLabel("Result: ");
        buttonPanel.add(areaButton);
        buttonPanel.add(perimeterButton);
        buttonPanel.add(resultLabel);

        // Add ActionListener to the button
        perimeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        // Get values from text fields
                        int a = Integer.parseInt(textFieldA.getText());
                        int b = Integer.parseInt(textFieldB.getText());
                        int c = Integer.parseInt(textFieldC.getText());

                        if(isValidTriangle(a, b, c))
                        {
                            // Calculate and display the result
                            int result = a + b+c;
                            resultLabel.setText("Result: " + result + " unit");
                        }else
                            resultLabel.setText("Invalid Triangle sides");
                    } catch (NumberFormatException ex) {
                        // Handle invalid input (non-numeric)
                        resultLabel.setText("Result: Invalid input");
                    }
                });
            }
        });
        areaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        // Get values from text fields
                        int a = Integer.parseInt(textFieldA.getText());
                        int b = Integer.parseInt(textFieldB.getText());
                        int c = Integer.parseInt(textFieldC.getText());

                        // Calculate and display the result
                         if(isValidTriangle(a, b, c))
                        {
                            int s = (a + b + c / 2);
                            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                            resultLabel.setText(String.format("Result:  %.2f square unit",area));
                        }else
                            resultLabel.setText("Invalid triangle sides");

                    } catch (NumberFormatException ex) {
                        // Handle invalid input (non-numeric)
                        resultLabel.setText("Result: Invalid input");
                    }
                });
            }
        });

        // Add panels to the CalculatorPanel
        add(panelA);
        add(panelB);
        add(panelC);
        add(buttonPanel);
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
        } else if (labelText.contains("'c'")) {
            textFieldC = textField;
        }
        return panel;
    }

     private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
