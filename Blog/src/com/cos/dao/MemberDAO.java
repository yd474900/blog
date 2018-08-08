package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.dto.MemberVO;
import com.cos.util.DBManger;

public class MemberDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//insert
	public int insert(MemberVO member) {
		String SQL = "INSERT INTO member VALUES(?,?,?,?)";
		Connection conn = DBManger.getConnentcion();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUsername());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn,pstmt);
		}
		return -1;
	}
}
