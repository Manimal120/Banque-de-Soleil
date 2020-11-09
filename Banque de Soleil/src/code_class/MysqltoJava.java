package code_class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class MysqltoJava {
	
	 static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static String DB_URL = "jdbc:mysql://localhost:3306/banque?useSSL=false&serverTimezone=UTC";
     static String USER = "root";//”√ªß
     static String PASS = "password";//√‹¬Î
     //connect to DB
     static {
    	 try {
    		 Class.forName(JDBC_DRIVER);
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
     }
     //acquire the link with object
     public static Connection getConnection() {
    	 try {
    		 return DriverManager.getConnection(DB_URL,USER,PASS);
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 return null;
     }
     //close the resource
     public static void close(Connection conn,Statement st,ResultSet rs) {
 		if(rs != null) {
 			try {
 				rs.close();
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 		if(st != null) {
 			try {
 				st.close();
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 		if(conn != null) {
 			try {
 				conn.close();
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 	}
}