import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Balance extends JFrame implements ActionListener{
    
    JButton back;
    String pin, aadhar;
    double balance;

    Balance(String pin, String aadhar){

        this.pin = pin;
        this.aadhar = aadhar;

        setLayout(null);

        JDBC jdbc = new JDBC();

        String query = "select balance from accountdetails where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";

        try{
            ResultSet rs = jdbc.st.executeQuery(query);

            if(rs.next()){
                balance = rs.getDouble("balance");

                JLabel text = new JLabel("Your account balance is Rs."+balance);
                text.setBounds(120, 150, 500, 30);
                text.setFont(new Font("System", Font.BOLD, 22));
                text.setForeground(Color.white);
                add(text);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(240, 300, 90, 30);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.BLUE);

        setSize(600, 500);
        setLocation(450, 150);
       /*  setUndecorated(true); */
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new Balance("", "");
    }
}
