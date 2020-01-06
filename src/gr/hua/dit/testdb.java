package gr.hua.dit;

import java.sql.Connection;
import java.sql.DriverManager;

public class testdb {

   public static void main(String[] args) {

           String jdbcUrl = "jdbc:mysql://127.0.0.1/test?useSSL=false";
           String user = "root";
           String pass = "spot";

           try {
                   System.out.println("Connecting to database: " + jdbcUrl);
                   Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
                   System.out.println("Connection success");

           } catch (Exception e) {
                   e.printStackTrace();
           }
   }
}