package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import db.ConnectionProvider;

public class OrdersDAO {
	//고객이름을 매개변수로 전달받아 해당 고객이 주문한
	//도서명,출판사명,주문가격,주문일의 목록을 리스트로 반환하는 메소드
	//리스트에 담기 위한 칼럼들로 구성된 VO를 따로 만들지 않고
	//Map을 이용해 봅니다.
	public ArrayList<HashMap<String, Object>> findOrdersByName(String name){
		ArrayList<HashMap<String, Object>> list = 
			new ArrayList<HashMap<String,Object>>();
		String sql = "select bookname,publisher,saleprice,orderdate "
				+ "from orders o, customer c, book b "
				+ "where o.bookid = b.bookid and "
				+ "c.custid = o.custid and "
				+ "name = ?";
		try {
			Connection conn = 
				ConnectionProvider.getConnecton();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String bookname = rs.getString(1);
				String publisher = rs.getString(2);
				int saleprice = rs.getInt(3);
				Date orderdate = rs.getDate(4);
				HashMap<String, Object> map 
				= new HashMap<String,Object>();
				map.put("bookname", bookname);
				map.put("publisher", publisher);
				map.put("saleprice", saleprice);
				map.put("orderdate", orderdate);
				list.add(map);
			}
			ConnectionProvider.close(rs, pstmt, conn);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}	

}
