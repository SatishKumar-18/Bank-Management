import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried, widow;
    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);

        Random num = new Random();
        random = Math.abs((num.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO. "+random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 36));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(260, 80, 320, 40);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(150, 170, 100, 20);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(330, 165, 250, 25);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 16));
        fname.setBounds(150, 210, 150, 20);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(330, 205, 250, 25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(150, 250, 120, 20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(330, 245, 250, 25);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(150, 290, 100, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(330, 285, 80, 20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(410, 285, 80, 20);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(500, 285, 80, 20);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("E-Mail: ");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(150, 330, 100, 20);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(330, 325, 250, 25);
        add(emailTextField);

        JLabel marital = new JLabel("Marital: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 16));
        marital.setBounds(150, 370, 100, 20);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(330, 365, 80, 25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(410, 365, 100, 25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        widow = new JRadioButton("Other");
        widow.setBounds(510, 365, 100, 25);
        widow.setBackground(Color.WHITE);
        add(widow);

        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        maritalButtonGroup.add(widow);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(150, 410, 100, 20);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(330, 405, 250, 25);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(150, 450, 100, 20);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(330, 445, 250, 25);
        add(cityTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(150, 490, 100, 20);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(330, 485, 250, 25);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin-Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 16));
        pincode.setBounds(150, 530, 100, 20);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(330, 525, 250, 25);
        add(pincodeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(480, 600, 100, 25);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }

    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(other.isSelected()){
            gender = "Other";
        }
        String email = emailTextField.getText();

        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(widow.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "E-mail required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State required");
            }
            else{
                JDBC jdbc = new JDBC();

                String query = "insert into signup values('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";

                jdbc.st.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formNo, name).setVisible(true);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
}
