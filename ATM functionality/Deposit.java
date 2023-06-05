import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit, back;
    String pin, aadhar;

    Deposit(String pin, String aadhar){

        this.pin = pin;
        this.aadhar = aadhar;
        
        setLayout(null);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(120, 100, 500, 30);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.white);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBounds(150, 200, 290, 30);
        amount.setBackground(Color.white);
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(180, 280, 90, 40);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(310, 280, 90, 40);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.BLUE);

        setSize(600, 500);
        setLocation(450, 150);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){

            String dAmount = amount.getText();
            Date date = new Date();

            if(dAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the deposit amount");
            }
            else{
                JDBC jdbc = new JDBC();

                Double amount = 0.00;
                amount += Double.parseDouble(dAmount);
                

                String query = "insert into bank values('"+pin+"', '"+date+"','Deposit', '"+dAmount+"')";
                String query2 = "update accountdetails set balance = balance +"+amount+" where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";


                try {
                    jdbc.st.executeUpdate(query);
                    jdbc.st.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Rs."+dAmount+" deposited successfully");

                    setVisible(false);
                    new Transaction(pin /* aadhar */).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin/* , aadhar */).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("", "");
    }
}
