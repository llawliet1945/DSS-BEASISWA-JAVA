package Connection;
import java.sql.*;
public class Connection {
    private java.sql.Connection koneksi;
    public java.sql.Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Connection Failed " + e);
        }
        String url = "jdbc:mysql://localhost/beasiswa";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
        }catch(SQLException e){
            System.out.println("Connection Failed " + e);
        }return koneksi;
    }
}
