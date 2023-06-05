import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Transaction extends JFrame implements ActionListener{

    JButton deposit, withdraw, cash, mini, change, balance, exit;
    String pin, aadhar;

    Transaction(String pNum){

        this.pin = pNum;

        setLayout(null);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(130, 50, 500, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.white);
        add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(110, 170, 150, 30);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(320, 170, 150, 30);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        add(withdraw);

        cash = new JButton("Fast Cash");
        cash.setBounds(110, 250, 150, 30);
        cash.setFont(new Font("System", Font.BOLD, 14));
        cash.setBackground(Color.white);
        cash.setForeground(Color.BLACK);
        cash.addActionListener(this);
        add(cash);

        mini = new JButton("Mini Statement");
        mini.setBounds(320, 250, 150, 30);
        mini.setFont(new Font("System", Font.BOLD, 14));
        mini.setBackground(Color.white);
        mini.setForeground(Color.BLACK);
        mini.addActionListener(this);
        add(mini);

        change = new JButton("Change Pin");
        change.setBounds(110, 330, 150, 30);
        change.setFont(new Font("System", Font.BOLD, 14));
        change.setBackground(Color.white);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        add(change);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(320, 330, 150, 30);
        balance.setFont(new Font("System", Font.BOLD, 14));
        balance.setBackground(Color.white);
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        add(balance);

        exit = new JButton("Exit");
        exit.setBounds(240, 400, 90, 30);
        exit.setFont(new Font("System", Font.BOLD, 14));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.BLUE);

        setSize(600, 500);
        setLocation(450, 150);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        JDBC jdbc = new JDBC();

        try {
            ResultSet rs = jdbc.st.executeQuery("select aadhar_number from accountdetails where pin_number = '"+pin+"'");

            if(rs.next()){
                aadhar = rs.getString("aadhar_number");
                if(ae.getSource() == exit){
                    System.exit(0);
                }
                else if(ae.getSource() == deposit){
                    setVisible(false);
        
                    new Deposit(pin, aadhar).setVisible(true);
                }
                else if(ae.getSource() == withdraw){
                    setVisible(false);
        
                    new Withdraw(pin, aadhar).setVisible(true);
                }
                else if(ae.getSource() == cash){
                    setVisible(false);
        
                    new FastCash(pin, aadhar).setVisible(true);
                }
                else if(ae.getSource() == balance){
                    setVisible(false);
        
                    new Balance(pin, aadhar).setVisible(true);
                }
                else if(ae.getSource() == change){
                    setVisible(false);

                    new PinChange(pin).setVisible(true);
                }
                else if(ae.getSource() == mini){
            
                    new MiniStatement(pin).setVisible(true);
                }
            }

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
