import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
@SuppressWarnings("serial")
public class TradeResourceSelect extends JFrame{ 
    String choice = null;
    public TradeResourceSelect(){
        setLayout(new FlowLayout());
        setSize(350,200);
        JLabel prompt = new JLabel("Please select which resource you would like to trade:");
        JButton woodButton = new JButton("WOOD");
        JButton goldButton = new JButton("GOLD");
        JButton favorButton = new JButton("FAVOR");
        JButton foodButton = new JButton("FOOD");
        class WoodButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                updateChoice("Wood");
                setVisible(false);
            }
        }
        class GoldButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                updateChoice("Gold");
                setVisible(false);
            }
        }
        class FavorButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                updateChoice("Favor");
                setVisible(false);
            }
        }
        class FoodButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                updateChoice("Food");
                setVisible(false);
            }
        }
        ActionListener woodListener = new WoodButtonListener();
        ActionListener goldListener = new GoldButtonListener();
        ActionListener favorListener = new FavorButtonListener();
        ActionListener foodListener = new FoodButtonListener();
        add(prompt);
        add(woodButton);
        add(goldButton);
        add(favorButton);
        add(foodButton);
        woodButton.addActionListener(woodListener);
        goldButton.addActionListener(goldListener);
        favorButton.addActionListener(favorListener);
        foodButton.addActionListener(foodListener);
    }
    public void updateChoice(String selection){
        this.choice = selection;
    }
    public String getChoice(){
        return this.choice;
    }
    public static void main (String args[]){
        TradeResourceSelect test = new TradeResourceSelect();
        test.setVisible(true);
    }
}