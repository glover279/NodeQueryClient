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
    private static String host="jdbc:derby://localhost:1527/nqc";
    private static String uname="robert";
    private static String pass="password";
    private static Connection conn = null;
    private static Statement stmt = null;
public DB(){
createConnection();

}
 public static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(host, uname, pass); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
            System.out.println("CAUGHTERR");
        }
    }
  public static void insertInto(String Name,int tz,int totreq,int ratelim, int maxserv)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO tblAccount" + " values('"+Name+"'," + tz + "," +totreq+ "," +ratelim+","+maxserv+")");  
                     //  ON DUPLICATE KEY UPDATE \"+\"NAME=\"+Name+\", TIMEZONE=\"+tz+\" TOTALAPICALLS=\"+totreq+\", DETECTEDRATE_LIMIT=\"+ratelim+\", MAXALLOWEDSERVERS=\"+maxserv"
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            System.out.println("C@");
        }
    }
    

}

    


    

