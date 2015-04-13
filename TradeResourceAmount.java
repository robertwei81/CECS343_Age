import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class TradeResourceAmount extends JFrame{ 
    double resourceAmount = -1;
    JLabel warningLabel = new JLabel("Please enter a valid amount.");
    JTextField amountField = new JTextField(5);
    public TradeResourceAmount(){
        setLayout(new FlowLayout());
        setSize(350,200);
        JLabel prompt = new JLabel("Please enter the amount of resource you wish to trade:");
        
        JLabel amountLabel = new JLabel("Resource Amount:");
        JButton tradeButton = new JButton("Trade");
        
        class AmountButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                resourceAmount = calculateAmount();
                if(resourceAmount>=0 && resourceAmount<15 && (resourceAmount%1==0)){
                    System.out.println(resourceAmount);
                    setVisible(false);
                }
                else{
                    addWarning();
                }
                
            }
        }
        ActionListener amountListener = new AmountButtonListener();
        tradeButton.addActionListener(amountListener);
        add(prompt);
        add(amountLabel);
        add(amountField);
        add(tradeButton);
    }
    public int getAmount(){
        return (int)resourceAmount;
    }  
    public double calculateAmount(){
        return Double.parseDouble(this.amountField.getText());
    }
    public void addWarning(){
        add(warningLabel);
    }
    public static void main (String args[]){
        TradeResourceAmount test = new TradeResourceAmount();
        test.setVisible(true);
    }
}