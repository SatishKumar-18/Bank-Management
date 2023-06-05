import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{

    MiniStatement(String pin){
        setLayout(null);

        setTitle("Mini Statement");
       

        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 500, 200);
        add(mini);

        JLabel bank = new JLabel("HDFC Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 340, 300, 20);
        add(balance);

        try{
            JDBC jdbc = new JDBC();

            ResultSet rs = jdbc.st.executeQuery("Select * from login where pin_number = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0,4) + "xxxxxxxx" + rs.getString("card_number").substring(12));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            JDBC jdbc = new JDBC();

            ResultSet rs = jdbc.st.executeQuery("Select * from bank where pin_number = '"+pin+"'");

            while(rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("day") + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + rs.getString("type") + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" +  rs.getString("amount") + "<br>");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            JDBC jdbc = new JDBC();

            ResultSet rs = jdbc.st.executeQuery("Select balance from accountdetails where pin_number = '"+pin+"'");

            while(rs.next()){
                balance.setText("Total Balance: " + rs.getDouble("balance"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);

        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}