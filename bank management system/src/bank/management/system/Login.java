package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
   
   JButton login, signup, clear;
   JTextField cardTextField;
   JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);// we are not gonna use the default layout of the frame, we will custom the layout using setBounds function;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));// to use images as icons
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);//we cannot place an image icon directly at the top of the frame. So we use JLabel. We can only use imageIcon in JLabel but not image;
        label.setBounds(70, 10, 100, 100);//(distance from left, distance from top, height, width);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));// to change the font; if the length of the label is too small to the text, text will be automatically disppear
        //text.setBounds(200,40,100,40);// here some text will be disappeared as the lenght of the label is 100 and it is not enough
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));// to change the font; if the length of the label is too small to the text, text will be automatically disppear
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));// to change the font; if the length of the label is too small to the text, text will be automatically disppear
        pin.setBounds(120,220,150,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));

        add(pinTextField);
        
        login= new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        
        
        clear= new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);// we use this to add actions on button click
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        getContentPane().setBackground(Color.white);// to change the color of entire frame.
        setSize(800,480);
        setVisible(true);// frame starts from top left corner this is the origin for frame
        setLocation(350,200);// we can set location other than orign, 350 from left and 200 from bottom
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()== login){
            Conn conn=new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
    }else if(ae.getSource()== signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    public static void main(String args[]){
        new Login();
    }
}
