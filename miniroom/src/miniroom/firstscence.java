package miniroom;


import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class firstscence extends Frame
{
    public static void main(String args[])
    {
    	createTable();
    	createSign("youjin", "123456789", "female", "18","boring");
    }
    public static void createSign(String name, String phone, String gender, String age, String note) {
    	try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note) "
					+ "VALUE"
					+ "('" + name +"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
					insert.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }

    
    public static void createTable() {
    	try {
    		Connection con = getConnection();
    		PreparedStatement create = con.prepareStatement(
    				"CREATE TABLE IF NOT EXISTS "
    				+ "customer(id int NOT NULL, AUTO_INCREMENT,"
    				+ "name varChar(255),"
    				+ "phone varChar(255),"
    				+ "gender varChar(255),"
    				+ "age varChar(255),"
    				+ "note varChar(255),"
    				+ "PRIMARY KEY(id)"
    				);
    				
			create.execute();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		System.out.println("���̺��� ���������� �������");
    	}
    }
    
    public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12265967";
			String user= "sql12265967";
			String pass = "P5nV8BM8qa";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Ŀ�ؼ� ������");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
}
