import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class AskPlayerNames extends JFrame{
    JTextField firstPlayerTextField = new JTextField(15);
    JTextField secondPlayerTextField = new JTextField(15);
    JTextField thirdPlayerTextField = new JTextField(15);
    public AskPlayerNames(){
        setLayout(new BorderLayout());
        setSize(600,300);
        JLabel promptLabel = new JLabel("OPTIONAL: Change the names of the players:");
        add(promptLabel, BorderLayout.NORTH);
        JPanel namesPanel = new JPanel();
        namesPanel.setLayout(new GridLayout(3,2));
        add(namesPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        JLabel firstPlayerLabel = new JLabel("First Player:");
        JLabel secondPlayerLabel = new JLabel("Second Player:");
        JLabel thirdPlayerLabel = new JLabel("Third Player:");
        
        firstPlayerTextField.setText("Player 1");
        secondPlayerTextField.setText("Player 2");
        thirdPlayerTextField.setText("Player 3");
        JButton initializeGameButton = new JButton("Initialize Game");
        buttonPanel.add(initializeGameButton, BorderLayout.EAST);
        namesPanel.add(firstPlayerLabel);
        namesPanel.add(firstPlayerTextField);
        namesPanel.add(secondPlayerLabel);
        namesPanel.add(secondPlayerTextField);
        namesPanel.add(thirdPlayerLabel);
        namesPanel.add(thirdPlayerTextField);
        ActionListener initializeGameListener = new InitializeGameButtonListener();
        initializeGameButton.addActionListener(initializeGameListener);
    }
    class InitializeGameButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                startGame();
                
            }
    }
    public void startGame(){
        GameBoard playGame = new GameBoard(firstPlayerTextField.getText(), secondPlayerTextField.getText(), thirdPlayerTextField.getText());
        playGame.setVisible(true);
    }
    public static void main (String args[]){
        AskPlayerNames test = new AskPlayerNames();
        test.setVisible(true);
    }
}