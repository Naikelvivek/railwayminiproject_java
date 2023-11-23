/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;
import java.lang.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignupRailwayReservation extends JFrame implements ActionListener {
    long random;
    JTextField usernameTextField,passTextField;
    JButton next;
    
   
    SignupRailwayReservation(){
        
        setLayout(null);
        
        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        
        JLabel formno = new JLabel(" FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("ENTER ID AND PASS TO CREATE");
        personDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personDetails.setBounds(290,80,400,40);
        add(personDetails);
        
        
         JLabel id = new JLabel("id: ");
        id.setFont(new Font("Raleway", Font.BOLD,20));
        id.setBounds(100,140,100,30);
        add(id);
        
        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        usernameTextField.setBounds(300,140,400,30);
        add(usernameTextField);
        
        JLabel pass = new JLabel("pass: ");
        pass.setFont(new Font("Raleway", Font.BOLD,20));
        pass.setBounds(100,190,200,30);
        add(pass);
        
        
       
        
        passTextField = new JTextField();
        passTextField.setFont(new Font("Raleway",Font.BOLD,14));
        passTextField.setBounds(300,190,400,30);
        add(passTextField);
        
        
        
       
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = ""+ random;
       String id = usernameTextField.getText();
        String pass= passTextField.getText();
        
       
        
        
        try{
          if(id.equals("")){
              JOptionPane.showMessageDialog(null,"id is Required");
          } else {
              Conn c = new Conn();
              String query = "insert into railway1 values('"+formno+"','"+id+"','"+pass+"')";
              c.s.executeUpdate(query);
              
              setVisible(false);
             
          } 
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupRailwayReservation();
    }
}


