/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RailwayLogin extends JFrame implements ActionListener{
    
    
    JButton login,signup,clear;
    JTextField cardTextField,pinTextField;
    JPasswordField pintextfield;
    RailwayLogin() {
        setTitle("Railway reservation system");
        
        setLayout(null);
      
       
        
        JLabel cardno =  new JLabel("username:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin =  new JLabel("Pass:");
        pin.setFont(new Font("Raleway",Font.BOLD,38));
        pin.setBounds(120,220,250,30);
        add(pin);
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed( ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            Conn conn = new Conn();
            String id = cardTextField.getText();
            String pass = pinTextField.getText();
            String query = "select * from railway1 where id = '"+id+"' and pass = '"+pass+"'";
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new RailwayMain().setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect user number or pin");
               }
                  
            } catch(Exception e){
                System.out.println(e);
            }
            
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupRailwayReservation().setVisible(true);
            
        }
         
        
    }
    
    public static void main(String args[]) {
        new RailwayLogin();
    }
}




