import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.awt.event.*;
import java.util.*;
// create set methods for values
public class GameBoard extends JFrame{
    int playerFood, playerFavor, playerWood, playerGold;
    int bankFood, bankFavor, bankWood, bankGold;
    int wonderVictoryCubeCount = 0, mostBuildingsVictoryCubeCount = 0;
    
    Font headerFont = new Font("SansSerif", Font.BOLD, 30);
    Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
    JTextField playerFoodText = new JTextField("0");
    JTextField playerFavorText = new JTextField("0");
    JTextField playerWoodText = new JTextField("0");
    JTextField playerGoldText = new JTextField("0");
    JTextField bankFoodText = new JTextField("0");
    JTextField bankFavorText = new JTextField("0");
    JTextField bankWoodText = new JTextField("0");
    JTextField bankGoldText = new JTextField("0");
    JTextField mostBuildingsVictoryCardText = new JTextField("0");
    JTextField wonderVictoryCardText = new JTextField("0");
    
    public GameBoard(String player, String opponentOne, String opponentTwo){
        String playerName = player;
        String opponentOneName = opponentOne;
        String opponentTwoName = opponentTwo;
        
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(2,1));
        
        JPanel lowerAreas = new JPanel();
        lowerAreas.setLayout(new GridLayout(1,3));
        JPanel upperAreas = new JPanel();
        upperAreas.setLayout(new GridLayout(1,3));
        add(upperAreas);
        add(lowerAreas);
        
        ArrayList<StretchIcon> norse_terrain = new ArrayList<StretchIcon>();
        for(int i = 0; i<16; i++){
            StretchIcon terrain_picture = new StretchIcon("pa_n_" + (i+1) + ".gif");
            norse_terrain.add(terrain_picture);
        }
        JPanel productionArea = new JPanel();
        productionArea.setLayout(new GridLayout(4,4));
        JLabel productionSquareOne = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareTwo = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareThree = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareFour = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareFive = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareSix = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareSeven = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareEight = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareNine = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareTen = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareEleven = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareTwelve = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareThirteen = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareFourteen = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareFifteen = new JLabel(norse_terrain.remove(0));
        JLabel productionSquareSixteen = new JLabel(norse_terrain.remove(0));

        productionArea.add(productionSquareOne);
        productionArea.add(productionSquareTwo);
        productionArea.add(productionSquareThree);
        productionArea.add(productionSquareFour);
        productionArea.add(productionSquareFive);
        productionArea.add(productionSquareSix);
        productionArea.add(productionSquareSeven);
        productionArea.add(productionSquareEight);
        productionArea.add(productionSquareNine);
        productionArea.add(productionSquareTen);
        productionArea.add(productionSquareEleven);
        productionArea.add(productionSquareTwelve);
        productionArea.add(productionSquareThirteen);
        productionArea.add(productionSquareFourteen);
        productionArea.add(productionSquareFifteen);
        productionArea.add(productionSquareSixteen);
        
        ArrayList<StretchIcon> norse_city_area = new ArrayList<StretchIcon>(); 
        for(int i = 0; i<16; i++){
            StretchIcon city_picture = new StretchIcon("ca_n_" + (i+1) + ".gif");
            norse_city_area.add(city_picture);
        }
        
        JPanel cityArea = new JPanel();
        cityArea.setLayout(new GridLayout(4,4));       
        JLabel citySquareOne = new JLabel(norse_city_area.remove(0));
        JLabel citySquareTwo = new JLabel(norse_city_area.remove(0));
        JLabel citySquareThree = new JLabel(norse_city_area.remove(0));
        JLabel citySquareFour = new JLabel(norse_city_area.remove(0));
        JLabel citySquareFive = new JLabel(norse_city_area.remove(0));
        JLabel citySquareSix = new JLabel(norse_city_area.remove(0));
        JLabel citySquareSeven = new JLabel(norse_city_area.remove(0));
        JLabel citySquareEight = new JLabel(norse_city_area.remove(0));
        JLabel citySquareNine = new JLabel(norse_city_area.remove(0));
        JLabel citySquareTen = new JLabel(norse_city_area.remove(0));
        JLabel citySquareEleven = new JLabel(norse_city_area.remove(0));
        JLabel citySquareTwelve = new JLabel(norse_city_area.remove(0));
        JLabel citySquareThirteen = new JLabel(norse_city_area.remove(0));
        JLabel citySquareFourteen = new JLabel(norse_city_area.remove(0));
        JLabel citySquareFifteen = new JLabel(norse_city_area.remove(0));
        JLabel citySquareSixteen = new JLabel(norse_city_area.remove(0));
        cityArea.add(citySquareOne);
        cityArea.add(citySquareTwo);
        cityArea.add(citySquareThree);
        cityArea.add(citySquareFour);
        cityArea.add(citySquareFive);
        cityArea.add(citySquareSix);
        cityArea.add(citySquareSeven);
        cityArea.add(citySquareEight);
        cityArea.add(citySquareNine);
        cityArea.add(citySquareTen);
        cityArea.add(citySquareEleven);
        cityArea.add(citySquareTwelve);
        cityArea.add(citySquareThirteen);
        cityArea.add(citySquareFourteen);
        cityArea.add(citySquareFifteen);
        cityArea.add(citySquareSixteen);
        
        JPanel resourceStates = new JPanel();
        resourceStates.setLayout(new GridLayout(4,1));
        JLabel bankTitle = new JLabel("BANK", SwingConstants.CENTER);
        bankTitle.setFont(headerFont);
        resourceStates.add(bankTitle);
        JPanel bankResources = new JPanel();
        bankResources.setLayout(new GridLayout(1,4));
        JPanel bankFoodPanel = new JPanel(new GridLayout(1,2));
        JPanel bankFavorPanel = new JPanel(new GridLayout(1,2));
        JPanel bankWoodPanel = new JPanel(new GridLayout(1,2));
        JPanel bankGoldPanel = new JPanel(new GridLayout(1,2));
        bankResources.add(bankFoodPanel);
        bankResources.add(bankFavorPanel);
        bankResources.add(bankWoodPanel);
        bankResources.add(bankGoldPanel);

        JLabel bankFoodLabel = new JLabel("Food = ");
        JLabel bankFavorLabel = new JLabel("Favor = ");
        JLabel bankWoodLabel = new JLabel("Wood = ");
        JLabel bankGoldLabel = new JLabel("Gold = ");
        playerFoodText.setEditable(false);
        playerFavorText.setEditable(false);
        playerWoodText.setEditable(false);
        playerGoldText.setEditable(false);
        bankFoodPanel.add(bankFoodLabel);
        bankFoodPanel.add(bankFoodText);
        bankFavorPanel.add(bankFavorLabel);
        bankFavorPanel.add(bankFavorText);
        bankWoodPanel.add(bankWoodLabel);
        bankWoodPanel.add(bankWoodText);
        bankGoldPanel.add(bankGoldLabel);
        bankGoldPanel.add(bankGoldText);
        resourceStates.add(bankResources);
        
        JLabel playerTitle = new JLabel(player, SwingConstants.CENTER); //create gameboard name so it will be different for each gameboard
        playerTitle.setFont(headerFont);
        resourceStates.add(playerTitle);
        JPanel playerResources = new JPanel();
        playerResources.setLayout(new GridLayout(1,4));
        bankFoodText.setEditable(false);
        bankFavorText.setEditable(false);
        bankWoodText.setEditable(false);
        bankGoldText.setEditable(false);
        JLabel playerFoodTitleLabel = new JLabel("Food = ");
        JLabel playerFavorTitleLabel = new JLabel("Favor = ");
        JLabel playerWoodTitleLabel = new JLabel("Wood = ");
        JLabel playerGoldTitleLabel = new JLabel("Gold = ");
        
        JPanel playerFoodPanel = new JPanel();
        playerFoodPanel.setLayout(new GridLayout(1,2));
        JPanel playerFavorPanel = new JPanel();
        playerFavorPanel.setLayout(new GridLayout(1,2));
        JPanel playerWoodPanel = new JPanel();
        playerWoodPanel.setLayout(new GridLayout(1,2));
        JPanel playerGoldPanel = new JPanel();
        playerGoldPanel.setLayout(new GridLayout(1,2));
        playerResources.add(playerFoodPanel);
        playerResources.add(playerFavorPanel);
        playerResources.add(playerWoodPanel);
        playerResources.add(playerGoldPanel);
        playerFoodPanel.add(playerFoodTitleLabel);
        playerFoodPanel.add(playerFoodText);
        playerFavorPanel.add(playerFavorTitleLabel);
        playerFavorPanel.add(playerFavorText);
        playerWoodPanel.add(playerWoodTitleLabel);
        playerWoodPanel.add(playerWoodText);
        playerGoldPanel.add(playerGoldTitleLabel);
        playerGoldPanel.add(playerGoldText);
        resourceStates.add(playerResources);
        
        lowerAreas.add(productionArea);
        lowerAreas.add(resourceStates);
        lowerAreas.add(cityArea);
        resourceStates.setBorder(border);
        playerResources.setBorder(border);
        bankResources.setBorder(border);
        ActionListener testButtonListener = new testButtonListener();
        
        JPanel actionCardArea = new JPanel(new GridLayout(2,4));
        StretchIcon buildingCostImage = new StretchIcon("buildingCost.gif");
        JLabel buildingCostLabel = new JLabel(buildingCostImage);
        JPanel upperRight = new JPanel(new GridLayout(1,2));
        JPanel gameOptions = new JPanel(new GridLayout(4,1));
        JButton gameMenuButton = new JButton("Exit to Game Menu");
        gameOptions.add(gameMenuButton);
        JButton gameRulesButton = new JButton("Game Rules");
        gameOptions.add(gameRulesButton);
        JButton viewOpponentOneButton = new JButton("View " + opponentOneName + "'s Board");
        gameOptions.add(viewOpponentOneButton);
        JButton viewOpponentTwoButton = new JButton("View " + opponentTwoName + "'s Board");
        gameOptions.add(viewOpponentTwoButton);
        upperRight.add(buildingCostLabel);
        upperRight.add(gameOptions);
        
        JPanel additionalOptions = new JPanel(new GridLayout(3,3));
        JPanel victoryCardArea = new JPanel(new GridLayout(1,4));
        JLabel mostBuildingsVictoryCardLabel = new JLabel("Most Buildings Victory Card", SwingConstants.CENTER);
        mostBuildingsVictoryCardLabel.setFont(headerFont);
        JLabel wonderVictoryCardLabel = new JLabel("Wonder Victory Card", SwingConstants.CENTER);
        wonderVictoryCardLabel.setFont(headerFont);
        victoryCardArea.add(wonderVictoryCardLabel);
        victoryCardArea.add(wonderVictoryCardText);
        victoryCardArea.add(mostBuildingsVictoryCardLabel);
        victoryCardArea.add(mostBuildingsVictoryCardText);
        mostBuildingsVictoryCardText.setEditable(false);
        wonderVictoryCardText.setEditable(false);
        
        JPanel cardHandArea = new JPanel(new GridLayout(1,4));
        JLabel cardSlotOneLabel = new JLabel("1", SwingConstants.CENTER);
        cardSlotOneLabel.setFont(headerFont);
        JLabel cardSlotTwoLabel = new JLabel("2", SwingConstants.CENTER);
        cardSlotTwoLabel.setFont(headerFont);
        JLabel cardSlotThreeLabel = new JLabel("3", SwingConstants.CENTER);
        cardSlotThreeLabel.setFont(headerFont);
        JLabel cardSlotFourLabel = new JLabel("4", SwingConstants.CENTER);
        cardSlotFourLabel.setFont(headerFont);
        JLabel cardSlotFiveLabel = new JLabel("5", SwingConstants.CENTER);
        cardSlotFiveLabel.setFont(headerFont);
        JLabel cardSlotSixLabel = new JLabel("6", SwingConstants.CENTER);
        cardSlotSixLabel.setFont(headerFont);
        JLabel cardSlotSevenLabel = new JLabel("7", SwingConstants.CENTER);
        cardSlotSevenLabel.setFont(headerFont);
        JLabel cardSlotEightLabel = new JLabel("8", SwingConstants.CENTER);
        cardSlotEightLabel.setFont(headerFont);
        
        cardSlotOneLabel.setBorder(border);
        cardSlotTwoLabel.setBorder(border);
        cardSlotThreeLabel.setBorder(border);
        cardSlotFourLabel.setBorder(border);
        cardSlotFiveLabel.setBorder(border);
        cardSlotSixLabel.setBorder(border);
        cardSlotSevenLabel.setBorder(border);
        cardSlotEightLabel.setBorder(border);
        
        actionCardArea.add(cardSlotOneLabel);
        actionCardArea.add(cardSlotTwoLabel);
        actionCardArea.add(cardSlotThreeLabel);
        actionCardArea.add(cardSlotFourLabel);
        actionCardArea.add(cardSlotFiveLabel);
        actionCardArea.add(cardSlotSixLabel);
        actionCardArea.add(cardSlotSevenLabel);
        actionCardArea.add(cardSlotEightLabel);
      
        upperAreas.add(actionCardArea);
        upperAreas.add(additionalOptions);
        upperAreas.add(upperRight);
        
       
        /*JPanel namesPanel = new JPanel();
        namesPanel.setLayout(new GridLayout(1,3));
        upperAreas.add(namesPanel, BorderLayout.NORTH);
        JButton testerTwo = new JButton("CLICK ME!!!!!!!!");
        testerTwo.addActionListener(testButtonListener);
        JLabel opponentOneLabel = new JLabel(opponentOneName);
        JLabel opponentTwoLabel = new JLabel(opponentTwoName);
        namesPanel.add(testerTwo);
        namesPanel.add(opponentOneLabel);
        namesPanel.add(opponentTwoLabel);*/

    }
    
    class testButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                playerFood++;
                playerFavor++;
                playerWood++;
                playerGold++;
                bankFood++;
                bankFavor++;
                bankWood++;
                bankGold++;
           
                playerFoodText.setText(Integer.toString(playerFood));
                playerFavorText.setText(Integer.toString(playerFavor));
                playerWoodText.setText(Integer.toString(playerWood));
                playerGoldText.setText(Integer.toString(playerGold));
                bankFoodText.setText(Integer.toString(bankFood));
                bankFavorText.setText(Integer.toString(bankFavor));
                bankWoodText.setText(Integer.toString(bankWood));
                bankGoldText.setText(Integer.toString(bankGold));
            }
    }
    
    public void addCubeMostBuildingsVictoryCard(int newCountOne){
        mostBuildingsVictoryCubeCount = newCountOne;
        
    }
    public void addCubeWonderVictoryCard(int newCountTwo){
         wonderVictoryCubeCount = newCountTwo;
    }
    public void updatePlayerFood(int newPlayerFood){
        playerFood = newPlayerFood;
        playerFoodText.setText(Integer.toString(playerFood));
    }
    public void updatePlayerFavor(int newPlayerFavor){
        playerFavor = newPlayerFavor;
        playerFavorText.setText(Integer.toString(playerFavor));
    }
    public void updatePlayerWood(int newPlayerWood){
        playerWood = newPlayerWood;
        playerWoodText.setText(Integer.toString(playerWood));
    }
    public void updatePlayerGold(int newPlayerGold){
        playerGold = newPlayerGold;
        playerGoldText.setText(Integer.toString(playerGold));
    }
    public void updateBankFood(int newBankFood){
        bankFood = newBankFood;
        bankFoodText.setText(Integer.toString(bankFood));
    }
    public void updateBankFavor(int newBankFavor){
        bankFavor = newBankFavor;
        bankFavorText.setText(Integer.toString(bankFavor));
    }
    public void updateBankWood(int newBankWood){
        bankWood = newBankWood;
        bankWoodText.setText(Integer.toString(bankWood));
    }
    public void updateBankGold(int newBankGold){
        bankGold = newBankGold;
        bankGoldText.setText(Integer.toString(bankGold));
    }

    public static void main (String args[]){
        GameBoard test = new GameBoard("Christian", "Bob", "Sarah");
        test.setVisible(true);
    }
   
}