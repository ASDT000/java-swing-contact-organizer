/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactorganizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DINUSHKA_THARIDU-AS
 */
public class Controller {
    String id;
    String name;
    String address;
    String pNumber;
    int confurm = -1 ;
    
    public int addContact(String id, String name, String address, String pNumber){
        this.id = id;
        this.name = name;
        this.address = address ;
        this.pNumber = pNumber ;
        confurm =  connectToDB();
        return confurm;
        
    }
    
    public int connectToDB(){
        String SQL = "INSERT INTO contacts VALUES(?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/contactOrganizer", "root", "Edu@1076");
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, id);
            stm.setObject(2, name);
            stm.setObject(3, address);
            stm.setObject(4, pNumber);
            int res = stm.executeUpdate();
            
            
            if (res>0){
                System.out.println("Added Successfully");
                
                return 1;
            }
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Driver Software not Found");
            JOptionPane.showMessageDialog(null, "Driver Software not Found", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex , "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    
    public int searchContact(String id, String name){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactorganizer", "root", "");
            String sql = "SELECT * FROM contacts WHERE id = ? OR name = ?"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name); 
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtName.setText(rs.getString("name")); 
                txtAddress.setText(rs.getString("address"));
                txtPNo.setText(rs.getString("phoneNo"));
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found");
                txtName.setText("");
                txtAddress.setText("");
                txtPNo.setText("");
            }
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

   
}
