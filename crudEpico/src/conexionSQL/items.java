/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class items {
    
    conexionSQL cc=new conexionSQL();
    Connection con=cc.conexion();
    
    
    /**
     * creates a registry in the table epico_items
     * 
     * @param name item name
     * @param category item category
     * @param costPrice item cost price
     * @param unitPrice item unit price
     * @param pic item pic filename
     * 
     * @return log log of execution
     * 
     */
    public String create(String name, String category, int costPrice, int unitPrice, String pic){
        
        String log ="";
        
        try{
            
            String querySQL="insert into epico_items (name,category,cost_price,unit_price,pic_filename) values(?,?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(querySQL);
            
            pst.setString(1,name);            
            pst.setString(2, category);
            pst.setInt(3 ,costPrice);
            pst.setInt(4 ,unitPrice);
            pst.setString(5,pic);      
            pst.execute();
            
            log = "Sucesfully added";
            
        } catch (Exception e){
            
            log = "Error, " + e.getMessage();
        }
        
        return log;
        
    }
    
    
    
    /**
     * reads all registries in the table epico_items and return them in a list of HashMaps  
     * 
     * @return ListOfProducts contains all elements of the table
     * 
     */
    public List<HashMap> read(){

        List<HashMap> ListOfProducts = new ArrayList<HashMap>();

        String querySQL="select * from epico_items";

        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(querySQL);

            while (rs.next()){
                HashMap<String,String> map=new HashMap<String,String>();

                map.put("iditems",rs.getString("iditems"));
                map.put("name",rs.getString("name"));
                map.put("category",rs.getString("category"));
                map.put("cost_price",rs.getString("cost_price"));
                map.put("unit_price",rs.getString("unit_price"));
                map.put("pic_filename",rs.getString("pic_filename"));

                ListOfProducts.add(map);

            }


        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error, data could not be displayed. " +e.getMessage());
        }
            
        return ListOfProducts;
    }
    
    
    
    /**
     * updates a registry in the table epico_items
     * 
     * @param itemId item id
     * @param name item name
     * @param category item category
     * @param costPrice item cost price
     * @param unitPrice item unit price
     * @param pic item pic filename
     * 
     * @return log log of execution
     * 
     */
    public String update(String itemId, String name, String category, int costPrice, int unitPrice, String pic){
        
        String log ="";
        
        try{
            
            String querySQL="update epico_items set name=?, category=?, cost_price=?, unit_price=?, pic_filename=? where iditems=? ";
            
            PreparedStatement pst=con.prepareStatement(querySQL);
            
            pst.setString(1,name);            
            pst.setString(2, category);
            pst.setInt(3 ,costPrice);
            pst.setInt(4 ,unitPrice);
            pst.setString(5,pic);      
            pst.setString(6 ,itemId);
            pst.execute();
            
            log = "Sucesfully updated";
           
        } catch (Exception e){
            
            log = "Error, " + e.getMessage();
        }
        
        return log;
     }
      
    
    /**
     * updates a registry in the table epico_items
     * 
     * @param itemId item id
     * 
     * @return log log of execution
     * 
     */
    public String delete (String itemId){
        
        String log ="";
        
        try{
            
            String querySQL="delete from epico_items where iditems=?";
            
            PreparedStatement pst=con.prepareStatement(querySQL);
            
            pst.setString(1,itemId);            
            pst.execute();
            
            log = "Sucesfully deleted";
           
        } catch (Exception e){
            
            log = "Error, " + e.getMessage();
        }
        
        return log;
     }

}


