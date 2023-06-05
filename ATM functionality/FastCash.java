import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{

    JButton hAmount, tAmount, fAmount, thAmount, ftAmount, ttAmount, back;
    String pin, aadhar;

    FastCash(String pin, String aadhar){

        this.pin = pin;
        this.aadhar = aadhar;

        setLayout(null);

        JLabel text = new JLabel("Select the withdrawal amount");
        text.setBounds(130, 50, 500, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.white);
        add(text);

        hAmount = new JButton("Rs.100");
        hAmount.setBounds(110, 170, 150, 30);
        hAmount.setFont(new Font("System", Font.BOLD, 14));
        hAmount.setBackground(Color.white);
        hAmount.setForeground(Color.BLACK);
        hAmount.addActionListener(this);
        add(hAmount);

        tAmount = new JButton("Rs.200");
        tAmount.setBounds(320, 170, 150, 30);
        tAmount.setFont(new Font("System", Font.BOLD, 14));
        tAmount.setBackground(Color.white);
        tAmount.setForeground(Color.BLACK);
        tAmount.addActionListener(this);
        add(tAmount);

        fAmount = new JButton("Rs.500");
        fAmount.setBounds(110, 250, 150, 30);
        fAmount.setFont(new Font("System", Font.BOLD, 14));
        fAmount.setBackground(Color.white);
        fAmount.setForeground(Color.BLACK);
        fAmount.addActionListener(this);
        add(fAmount);

        thAmount = new JButton("Rs.2000");
        thAmount.setBounds(320, 250, 150, 30);
        thAmount.setFont(new Font("System", Font.BOLD, 14));
        thAmount.setBackground(Color.white);
        thAmount.setForeground(Color.BLACK);
        thAmount.addActionListener(this);
        add(thAmount);

        ftAmount = new JButton("Rs.5000");
        ftAmount.setBounds(110, 330, 150, 30);
        ftAmount.setFont(new Font("System", Font.BOLD, 14));
        ftAmount.setBackground(Color.white);
        ftAmount.setForeground(Color.BLACK);
        ftAmount.addActionListener(this);
        add(ftAmount);

        ttAmount = new JButton("Rs.10000");
        ttAmount.setBounds(320, 330, 150, 30);
        ttAmount.setFont(new Font("System", Font.BOLD, 14));
        ttAmount.setBackground(Color.white);
        ttAmount.setForeground(Color.BLACK);
        ttAmount.addActionListener(this);
        add(ttAmount);

        back = new JButton("Back");
        back.setBounds(240, 400, 90, 30);
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

            new Transaction(pin/* , aadhar */).setVisible(true);
        }
        else{
            String fAmount = ((JButton)ae.getSource()).getText().substring(3);
            Date date = new Date();

            JDBC jdbc = new JDBC();
            String query = "insert into bank values('"+pin+"', '"+date+"','Withdraw', '"+fAmount+"')";
            String query1 = "select balance from accountdetails where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";
            String query2 = "update accountdetails set balance = balance -"+fAmount+" where pin_number = '"+pin+"' and aadhar_number = '"+aadhar+"'";


            try{
                ResultSet rs = jdbc.st.executeQuery(query1);
                double balance;

                if(rs.next()){

                   balance = rs.getDouble("balance");
                   if(balance < Integer.parseInt(fAmount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    else{
                        jdbc.st.executeUpdate(query);
                        jdbc.st.executeUpdate(query2);

                        JOptionPane.showMessageDialog(null, "Rs."+fAmount+" debited successfully");

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
    public static void main(String[] args) {
        new FastCash("", "");
    }
}