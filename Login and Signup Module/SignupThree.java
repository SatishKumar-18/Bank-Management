import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton savings, current, fd, rd;
    JCheckBox atm, iBank, mBank, sms, cBook, eStatement, declare;
    JButton submit, cancel;
    String formNo, name, aadhar;

    SignupThree(String formNo, String name, String aadhar){

        this.formNo = formNo;
        this.name = name;
        this.aadhar = aadhar;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(240, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 120, 160, 30);
        add(type);

        savings = new JRadioButton("Savings");
        savings.setFont(new Font("Raleway", Font.BOLD, 15));
        savings.setBounds(100, 170, 100, 20);
        savings.setBackground(Color.WHITE);
        add(savings);

        current = new JRadioButton("Current");
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBounds(260, 170, 100, 20);
        current.setBackground(Color.WHITE);
        add(current);

        fd = new JRadioButton("Fixed Deposit");
        fd.setFont(new Font("Raleway", Font.BOLD, 15));
        fd.setBounds(100, 220, 150, 20);
        fd.setBackground(Color.WHITE);
        add(fd);
        
        rd = new JRadioButton("Recurring Deposit");
        rd.setFont(new Font("Raleway", Font.BOLD, 15));
        rd.setBounds(260, 220, 180, 20);
        rd.setBackground(Color.WHITE);
        add(rd);

        ButtonGroup accType = new ButtonGroup();
        accType.add(savings);
        accType.add(current);
        accType.add(fd);
        accType.add(rd);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 280, 160, 30);
        add(card);

        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-4142");
        cNumber.setFont(new Font("Raleway", Font.BOLD, 16));
        cNumber.setBounds(260, 280, 180, 30);
        add(cNumber);

        JLabel cDetails = new JLabel("(Your 16-digit card number)");
        cDetails.setFont(new Font("Raleway", Font.BOLD, 10));
        cDetails.setBounds(100, 310, 180, 20);
        add(cDetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 350, 100, 30);
        add(pin);

        JLabel pDetails = new JLabel("(Your 4-digit pin number)");
        pDetails.setFont(new Font("Raleway", Font.BOLD, 10));
        pDetails.setBounds(100, 380, 180, 20);
        add(pDetails);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pNumber.setBounds(260, 350, 100, 30);
        add(pNumber);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 430, 200, 30);
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setFont(new Font("Raleway", Font.BOLD, 14));
        atm.setBounds(100, 480, 120, 30);
        atm.setBackground(Color.WHITE);
        add(atm);

        iBank = new JCheckBox("Internet Banking");
        iBank.setFont(new Font("Raleway", Font.BOLD, 14));
        iBank.setBounds(260, 480, 150, 30);
        iBank.setBackground(Color.WHITE);
        add(iBank);

        mBank = new JCheckBox("Mobile Banking");
        mBank.setFont(new Font("Raleway", Font.BOLD, 14));
        mBank.setBounds(100, 530, 140, 30);
        mBank.setBackground(Color.WHITE);
        add(mBank);

        sms = new JCheckBox("E-mail & SMS Alert");
        sms.setFont(new Font("Raleway", Font.BOLD, 14));
        sms.setBounds(260, 530, 170, 30);
        sms.setBackground(Color.WHITE);
        add(sms);

        cBook = new JCheckBox("Cheque Book");
        cBook.setFont(new Font("Raleway", Font.BOLD, 14));
        cBook.setBounds(100, 580, 140, 30);
        cBook.setBackground(Color.WHITE);
        add(cBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway", Font.BOLD, 14));
        eStatement.setBounds(260, 580, 170, 30);
        eStatement.setBackground(Color.WHITE);
        add(eStatement);

        declare = new JCheckBox("I here by declares the above entered details are correct to the best of my knowledge");
        declare.setFont(new Font("Raleway", Font.BOLD, 12));
        declare.setBounds(100, 650, 500, 30);
        declare.setBackground(Color.WHITE);
        add(declare);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(260, 710, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(410, 710, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setVisible(true);
        setLocation(350, 10);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String type = null;
            if(savings.isSelected()){
                type = "Savings";
            }
            else if(current.isSelected()){
                type = "Current";
            }
            else if(fd.isSelected()){
                type = "Fixed Deposit";
            }
            else if(rd.isSelected()){
                type = "Recurring Deposit";
            }

            Random random= new Random();
            String cNum = "" + Math.abs((random.nextLong() % 90000000L) + 1080200300000000L);

            String pNum = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            double balance = 0.0;

            String service = "";
            if(atm.isSelected()){
                service = service + "ATM Card";
            }
            else if(iBank.isSelected()){
                service = service + "Internet Banking";
            }
            else if(mBank.isSelected()){
                service = service + "Mobile Banking";
            }
            else if(sms.isSelected()){
                service = service + "E-mail & SMS Alert";
            }
            else if(cBook.isSelected()){
                service = service + "Cheque Book";
            }
            else if(eStatement.isSelected()){
                service = service + "E-Statement";
            }

            String d = "";
            if(declare.isSelected()){
                d = "I here by declares the above entered details are correct to the best of my knowledge";
            }

            try{
                if(type.equals(null)){
                    JOptionPane.showMessageDialog(null, "Choose account type");
                }
                else if(service.equals("")){
                    JOptionPane.showMessageDialog(null, "Choose atleast one service");
                }
                else if(d.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select I agree to continue");
                }
                else{
                    JDBC jdbc = new JDBC();

                    String query = "insert into signupthree values('"+formNo+"', '"+type+"', '"+cNum+"', '"+pNum+"', '"+service+"')";
                    String query2 = "insert into login values('"+formNo+"', '"+cNum+"', '"+pNum+"')";
                    String query3 = "insert into accountdetails values('"+pNum+"', '"+name+"', '"+aadhar+"', "+balance+")";

                    jdbc.st.executeUpdate(query);
                    jdbc.st.executeUpdate(query2);
                    jdbc.st.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "Card Number: "+cNum+"\nPin: "+pNum);

                    setVisible(false);
                    new Deposit(pNum, aadhar).setVisible(true);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("", "", "");
    }
}
