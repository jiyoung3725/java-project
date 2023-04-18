package bookCust;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bookCust.ConnectionProvider;
import bookCust.CustomerVO;

public class CustomerDAO {
	//insert 메소드
	public  int  insertCustomer(CustomerVO c){
		int re = -1;
		String sql = "insert into customer values("+
		c.getCustid()+
		",'"+c.getName()+
		"','"+c.getAddress()+
		"','"+c.getPhone()+"')";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = 
					conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
	
	
	//update 메소드
	public int updateCustomer(CustomerVO c) {
		int re = -1;
		String sql = "update customer set name='"+
		c.getName()+"',address='"+
		c.getAddress()+"',phone='"+
		c.getPhone()+"' where custid="+
		c.getCustid();
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		return re;
	}
	
	
	
	//select 메소드
	//모든 고객목록을 검색하여 반환하는 메소드
	public ArrayList<CustomerVO> listCustomer(){
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		String sql = "select * from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custid = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				String phone = rs.getString(4);
				
				CustomerVO c = new CustomerVO(custid, name, addr, phone);
				list.add(c);
			}
			
			ConnectionProvider.close(rs, stmt, conn);			
					
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
	
	//delete 메소드
	//고객번호를 매개변수로 전달받아 해당 고객을 삭제하기 위한 메소드 구조를 잡아 봅니다.
	public int deleteCustomer(int custid) {
		int re = -1;
		String sql = "delete customer where custid="+custid;
		try {
			Connection conn 
			= ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
}


















