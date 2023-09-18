//* Write a Gaming app to guess the number in Java with the following rules:
//* Display Message if user has entered number greater than the number.
//* Display the number of attempts.
//* Make use of GUI based input-output */

import java.util.Random;
//? for GUI I/O
import javax.swing.JOptionPane;

public class GamingApp {
    public static void main(String[] args) {
        Random random = new Random();
        //? Generate a Random Number 
        int answer = random.nextInt(100);
        int userInput;
        int attempts = 0;
        do {
            //? Getting user input 
            userInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Guess the number"));
            if(userInput>answer)
                JOptionPane.showMessageDialog(null, "Enter a lesser number.");
            else if(userInput<answer)  
                JOptionPane.showMessageDialog(null, "Enter a greater number.");
            attempts++;
        } while (answer!=userInput);
        JOptionPane.showMessageDialog(null, "Congrats! You won in "+ attempts +" attempts");
    }
}
