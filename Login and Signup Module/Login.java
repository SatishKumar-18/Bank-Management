import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("ATM");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);
        label1.setBounds(150, 40, 50, 50);
        add(label1);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 35));
        text.setBounds(220, 45, 500, 40);
        add(text);
        
        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(180, 125, 200, 40);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(320, 130, 220, 35);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(180, 175, 200, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(320, 180, 220, 35);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(320, 250, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(440, 250, 100, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        clear = new JButton("CLEAR");
        clear.setBounds(380, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.white);

        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            JDBC jdbc = new JDBC();

            String cNum = cardTextField.getText();
            String pNum = pinTextField.getText();

            String query = "select * from login where card_Number = '"+cNum+"' and pin_Number = '"+pNum+"'";

            try {
                ResultSet rs = jdbc.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pNum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signUp){
            setVisible(false);
            new SignupOne().setVisible(true); 
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
