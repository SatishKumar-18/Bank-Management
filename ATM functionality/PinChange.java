import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pin;
    JPasswordField nPin, cPin;
    JButton change, back;

    PinChange(String pin){
        this.pin = pin;

        setLayout(null);

        JLabel text = new JLabel("Change your 4-digit pin here");
        text.setBounds(140, 50, 350, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 22));
        add(text);

        JLabel newPin = new JLabel("New Pin: ");
        newPin.setBounds(120, 160, 100, 30);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System", Font.BOLD, 18));
        add(newPin);

        nPin = new JPasswordField();
        nPin.setBounds(260, 160, 200, 30);
        nPin.setBackground(Color.WHITE);
        nPin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(nPin);

        JLabel confirmPin = new JLabel("Confirm Pin: ");
        confirmPin.setBounds(120, 240, 200, 30);
        confirmPin.setForeground(Color.WHITE);
        confirmPin.setFont(new Font("System", Font.BOLD, 18));
        add(confirmPin);
        
        cPin = new JPasswordField();
        cPin.setBounds(260, 240, 200, 30);
        cPin.setBackground(Color.WHITE);
        cPin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cPin);

        change = new JButton("Change");
        change.setBounds(180, 330, 100, 40);
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(320, 330, 100, 40);
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

        if(ae.getSource() == back){
            setVisible(false);

            new Transaction(pin).setVisible(true);
        }
        else{
            String newPin = nPin.getText();
            String confirm = cPin.getText();

            if(newPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new pin");
            }
            else if(confirm.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter confirm pin");
            }
            else if(!newPin.equals(confirm)){
                JOptionPane.showMessageDialog(null, "Confirm pin did not match");
            }
            else{
                JDBC jdbc = new JDBC();

                String query = "update login set pin_number = '"+confirm+"' where pin_number = '"+pin+"'";
                String query1 = "update accountdetails set pin_number = '"+confirm+"' where pin_number = '"+pin+"'";
                String query2 = "update bank set pin_number = '"+confirm+"' where pin_number = '"+pin+"'";
                String query3 = "update signupthree set pin_number = '"+confirm+"' where pin_number = '"+pin+"'";

                try {
                    jdbc.st.executeUpdate(query);
                    jdbc.st.executeUpdate(query1);
                    jdbc.st.executeUpdate(query2);
                    jdbc.st.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");

                    setVisible(false);
                    new Login().setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
            
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
