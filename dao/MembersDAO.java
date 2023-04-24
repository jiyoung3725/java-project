package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.ConnectionProvider;

public class MembersDAO {
	
	public String getPWD(String ID){
		String sql = "SELECT PWD FROM MEMBER WHERE ID = ?";
		String result = "";
		try {
			Connection conn = ConnectionProvider.getConnecton();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
	}
	
	public String getTitle(String ID) {
		String sql = "SELECT TITLE FROM MINIROOM WHERE ID = ?";
		String result = "";
		try {
			Connection conn = ConnectionProvider.getConnecton();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
		
	}
	public String getGender(String ID) {
		String sql = "SELECT DECODE(SUBSTR(JUMIN,8,1),1,'남',3,'남','여') FROM MINIROOM R,MEMBER M WHERE R.ID =?";
		String result = "";
		try {
			Connection conn = ConnectionProvider.getConnecton();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			result = rs.getString(1);
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
		
	}
	public int saveTitle(String title, String ID) {
		String sql = "UPDATE MINIROOM SET TITLE=? WHERE ID = ?";
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnecton();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, ID);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return re;
	}
	
	
}
