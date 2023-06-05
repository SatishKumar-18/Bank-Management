import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadharTextField;
    JComboBox religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    JButton next;
    JRadioButton ySenior, nSenior, yExisting, nExisting;
    String formNo, name;

    SignupTwo(String formNo, String name){

        this.formNo = formNo;
        this.name = name;

        setLayout(null);

        setTitle("Page 2: NEW ACCOUNT APPLICATION FORM ");


        JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(260, 80, 320, 40);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(150, 170, 100, 20);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(330, 165, 250, 25);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 16));
        category.setBounds(150, 210, 150, 20);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(330, 210, 250, 25);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(150, 250, 100, 20);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(330, 255, 250, 25);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 16));
        education.setBounds(150, 290, 100, 20);
        add(education);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 16));
        qualification.setBounds(150, 320, 120, 20);
        add(qualification);

        String valEducation[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others"};
        educationBox = new JComboBox(valEducation);
        educationBox.setBounds(330, 305, 250, 25);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBounds(150, 370, 100, 20);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired"};
        occupationBox = new JComboBox(valOccupation);
        occupationBox.setBounds(330, 365, 250, 25);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("PAN: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 16));
        pan.setBounds(150, 410, 100, 20);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(330, 410, 250, 25);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(150, 450, 130, 20);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(330, 450, 250, 25);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 16));
        seniorCitizen.setBounds(150, 490, 120, 20);
        add(seniorCitizen);

        ySenior = new JRadioButton("Yes");
        ySenior.setBounds(330, 490, 80, 20);
        ySenior.setBackground(Color.WHITE);
        add(ySenior);

        nSenior = new JRadioButton("No");
        nSenior.setBounds(410, 490, 80, 20);
        nSenior.setBackground(Color.WHITE);
        add(nSenior);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(ySenior);
        seniorGroup.add(nSenior);

        JLabel existing = new JLabel("Existing Account: ");
        existing.setFont(new Font("Raleway", Font.BOLD, 16));
        existing.setBounds(150, 530, 140, 20);
        add(existing);

        yExisting = new JRadioButton("Yes");
        yExisting.setBounds(330, 530, 80, 20);
        yExisting.setBackground(Color.WHITE);
        add(yExisting);

        nExisting = new JRadioButton("No");
        nExisting.setBounds(410, 530, 80, 20);
        nExisting.setBackground(Color.WHITE);
        add(nExisting);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(yExisting);
        existingGroup.add(nExisting);


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
        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();

        String seniorCitizen = null;
        if(ySenior.isSelected()){
            seniorCitizen = "Yes";
        }else if(nSenior.isSelected()){
            seniorCitizen = "No";
        }

        String existing = null;
        if(yExisting.isSelected()){
            existing = "Yes";
        }
        else if(nExisting.isSelected()){
            existing = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try{
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN number is required");
            }
            else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar number required");
            }
            else{
                JDBC jdbc = new JDBC();

                String query = "insert into signuptwo values('"+formNo+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorCitizen+"', '"+existing+"')";

                jdbc.st.executeUpdate(query);
            }

            setVisible(false);

            new SignupThree(formNo, name, aadhar).setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new SignupTwo("", "");
    }
}
