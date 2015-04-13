import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class GameMenu extends JFrame{
    public GameMenu(){
        setLayout(new BorderLayout());
        ImageIcon menuTitle = new ImageIcon(getClass().getResource("menutitle.PNG"));
        JLabel menuLabel = new JLabel(menuTitle);
        add(menuLabel, BorderLayout.NORTH);
        JButton startGameButton = new JButton("Start Game");
        JButton gameRulesButton = new JButton("Game Rules");
        JButton exitGameButton = new JButton("Exit");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startGameButton);
        buttonPanel.add(gameRulesButton);
        buttonPanel.add(exitGameButton);      
        add(buttonPanel, BorderLayout.CENTER);
        
        ActionListener startGameListener = new StartGameButtonListener();
        ActionListener gameRulesListener = new GameRulesButtonListener();
        ActionListener exitGameListener = new ExitGameButtonListener();
        startGameButton.addActionListener(startGameListener);
        gameRulesButton.addActionListener(gameRulesListener);
        exitGameButton.addActionListener(exitGameListener);
    }
    
    class StartGameButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                AskPlayerNames startUp = new AskPlayerNames();
                startUp.setVisible(true);
            }
    }
    class GameRulesButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                openManual();
            }
    }
    class ExitGameButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.exit(0);  
            }
    }
     
    public void openManual(){
        if(Desktop.isDesktopSupported()){
            try{
                File pdf = new File("InstructionManual.pdf");
                Desktop.getDesktop().open(pdf);
            }
            catch(IOException ex){
                
            }
        }
    }
    public static void main (String args[]){
        GameMenu mainMenu = new GameMenu();
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainMenu.setVisible(true);
        mainMenu.setTitle("Game Menu");   
    }
}