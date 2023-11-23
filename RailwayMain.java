
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RailwayMain extends JFrame {
    Connection con = null;
    PreparedStatement pst = null;

    private JTextField txtId, txtPassngeer,txtName, txtDate, txtClass, txtSeat_no, txtFROM, txtTO;
    private JButton btnBook, btnClear;

    public RailwayMain() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("train booking");
        setLayout(new GridLayout(2, 1));

        JPanel formPanel = new JPanel(new GridLayout(10, 2));
        add(formPanel);

        formPanel.add(new JLabel("train no:"));
        txtId = new JTextField();
        formPanel.add(txtId);

        formPanel.add(new JLabel("Passngeer Name:"));
        txtPassngeer = new JTextField();
        formPanel.add(txtPassngeer);

        formPanel.add(new JLabel("train name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Date:"));
        txtDate = new JTextField();
        formPanel.add(txtDate);

        formPanel.add(new JLabel(" Class:"));
        txtClass = new JTextField();
        formPanel.add(txtClass);

        formPanel.add(new JLabel("Seat_no"));
        txtSeat_no = new JTextField();
        formPanel.add(txtSeat_no);

        formPanel.add(new JLabel("FROM"));
        txtFROM = new JTextField();
        formPanel.add(txtFROM);

        formPanel.add(new JLabel("TO"));
        txtTO = new JTextField();
        formPanel.add(txtTO);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel);

        btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveFlight();
            }
        });
        buttonPanel.add(btnBook);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearForm();
            }
        });
        buttonPanel.add(btnClear);

        pack();
    }

    private void saveFlight() {
        String trainno = txtId.getText();
        String PassengerName = txtPassngeer.getText();
        String trainname = txtName.getText();
        String date = txtDate.getText();
        String Class = txtClass.getText();
        String seat_no = txtSeat_no.getText();
        String FROM = txtFROM.getText();
        String TO = txtTO.getText();

           
        JOptionPane.showMessageDialog(this, "train BOOKED successfully.");

        // Clear the form after saving
        clearForm();
        try{
          if(trainno.equals("")){
              JOptionPane.showMessageDialog(null,"train  is Required");
          } else {
              Conn c = new Conn();
              String query = "insert into details values('"+trainno+"','"+PassengerName+"','"+trainname+"','"+date+"','"+Class+"','"+seat_no+"','"+FROM+"','"+TO+"')";
              c.s.executeUpdate(query);
              
              setVisible(false);
              
          } 
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtPassngeer.setText("");
        txtName.setText("");
        txtDate.setText("");
        txtClass.setText("");
        txtSeat_no.setText("");
        txtFROM.setText("");
        txtTO.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RailwayMain().setVisible(true);
            }
        });
    }
}