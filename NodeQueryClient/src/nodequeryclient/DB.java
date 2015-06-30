/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodequeryclient;
import java.sql.*;

/**
 *
 * @author Robert
 */
public class DB {
    private static String host="jdbc:derby://localhost:1527/nq";
    private String uname="robert";
    private String pass="test";
    private static Connection conn = null;
    private static Statement stmt = null;
public static void main(String[] args){

}
 public static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(host); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
  public static void insertInto(String Name,int tz,int totreq,int ratelim, int maxserv, String APIkey)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + "tblAccount" + " values (" +
                    Name + ",'" + tz + ",'" +totreq+ ",'" +ratelim+",'"+maxserv+",'"+APIkey+"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    

}

    


    

