/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class conexionSQL {
    
    Connection conectar = null;
    
    public Connection  conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/epico","root","");
            JOptionPane.showMessageDialog(null,"DB succesdully loaded");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error " + e.getMessage());
        }
        return conectar;
    }
    
    
}
