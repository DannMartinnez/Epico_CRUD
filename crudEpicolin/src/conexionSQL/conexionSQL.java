/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import com.mysql.jdbc.Connection;

/**
 *
 * @author dann
 */
public class conexionSQL {
    
    Connection conectar = null;
    
    public Connection  conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/epicosql","root","");
        } catch (Exception e){
            
        }
    }
}
