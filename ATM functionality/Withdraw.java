import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Withdraw extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw, back;
    String pin, aadhar;

    Withdraw(String pin, String aadhar){

        this.pin = pin;
        this.aadhar = aadhar;

        setLayout(null);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(110, 100, 450, 30);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        amount = new JTextField();
        amount.setBounds(150, 200, 290, 30);
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBackground(Color.WHITE);
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(180, 280, 100, 40);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("Back");
        back.setBounds(320, 280, 100, 40);
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
        if(ae.getSource() == withdraw){
            String wAmount = amount.getText();
            Date date = new Date();
            Double balance;

            if(wAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the withdraw amount");
            }
            
            else{
                JDBC jdbc = new JDBC();

                String query1 = "select balance from accountdetails where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";
                String query = "insert into bank values('"+pin+"', '"+date+"','Withdraw', '"+wAmount+"')";
                String query2 = "update accountdetails set balance = balance -"+wAmount+" where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";

                try{
                    ResultSet rs = jdbc.st.executeQuery(query1);
                    if(rs.next()){
                        balance = rs.getDouble("balance");
                        if(balance < Integer.parseInt(wAmount)){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            return;
                        }
                        else{
                            jdbc.st.executeUpdate(query);
                            jdbc.st.executeUpdate(query2);

                            JOptionPane.showMessageDialog(null, "Rs."+wAmount+" withdraw successfully");
                            setVisible(false);
                            new Transaction(pin/* , aadhar */).setVisible(true);
                        }
                    }
                }
                catch(Exception e){
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
        new Withdraw("", "");
    }
}
