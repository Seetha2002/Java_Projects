package bank.management.system;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
   
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno,eyes, eno;
    JComboBox religion, category,income, occupation, education;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
      
        
        JLabel additonalDetails=new JLabel("Page 2: Additional Details");
        additonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additonalDetails.setBounds(290,80,400,30);
        add(additonalDetails);
        
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,200,30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);//JComboBox is used for dropdown
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel cate=new JLabel("Category:");
        cate.setFont(new Font("Raleway",Font.BOLD,20));
        cate.setBounds(100,190,200,30);
        add(cate);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        add(category);
        category.setBackground(Color.WHITE);
        
        JLabel inc=new JLabel("Income");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String valIncome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        add(income);
        income.setBackground(Color.WHITE);
        
        
       
        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
        
        
        JLabel qual=new JLabel("Qualification:");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(100,315,200,30);
        add(qual);
        
        String educationValues[]={"Non Graduate","Graduate","Post graduation","Doctorate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        add(education);
        education.setBackground(Color.WHITE);
        

        
        JLabel occu=new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(100,390,200,30);
        add(occu);
        
        String occupationValues[]={"Salaried","Self-Employeed","Bussiness","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        occupation.setBackground(Color.WHITE);
        
        JLabel pan_number=new JLabel("Pan Number:");
        pan_number.setFont(new Font("Raleway",Font.BOLD,20));
        pan_number.setBounds(100,440,200,30);
        add(pan_number);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadhar_number=new JLabel("Aadhar Number:");
        aadhar_number.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar_number.setBounds(100,490,200,30);
        add(aadhar_number);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
  
       
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
       
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(720,610,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,900);
        setLocation(350,0);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();//getselectedItem method is used to take the selected one from the dropdown
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
       
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen="No";
        }
      
        String existingaccount=null;
        if(eyes.isSelected()){
           existingaccount ="Yes";
        }
        else if(eno.isSelected()){
            existingaccount="No";
        }
       
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{
           
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
}
    
     public static void main(String args[]){
        new SignupTwo("");
    }
}
