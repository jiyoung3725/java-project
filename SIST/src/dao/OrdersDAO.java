package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import db.ConnectionProvider;

public class OrdersDAO {
	//���̸��� �Ű������� ���޹޾� �ش� ���� �ֹ���
	//������,���ǻ��,�ֹ�����,�ֹ����� ����� ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
	//����Ʈ�� ��� ���� Į����� ������ VO�� ���� ������ �ʰ�
	//Map�� �̿��� ���ϴ�.
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
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		return list;
	}	

}
