/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.management;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows 10
 */
public class database {
 public static Connection connectDb(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", ""); // root is the default username while "" or empty is for the pass
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}
