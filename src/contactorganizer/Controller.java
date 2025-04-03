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
    private String id;
    private String name;
    private String address;
    private String pNumber;
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
            stm.setObject(1, getId());
            stm.setObject(2, getName());
            stm.setObject(3, getAddress());
            stm.setObject(4, getpNumber());
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
    
    public static Controller searchContact(String index){
        return null;
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the pNumber
     */
    public String getpNumber() {
        return pNumber;
    }
        

   
}
