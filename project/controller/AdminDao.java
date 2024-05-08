package project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.model.Admin_Model;

public class AdminDao {
	private Connection conn; // db와 연결된 객체
	private PreparedStatement pstmt; // sql문을 담는 객체
	private static AdminDao instance;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "SYSTEM";
	private String password = "0831"; 
	
	public AdminDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static AdminDao getInstance() {
		if (instance == null) {
			synchronized (AdminDao.class) {
				instance = new AdminDao();
			}
		}
		return instance;
	}
	
	public int loginArticle(Admin_Model adm) {
		int su = 0;
		getConnection();

		try {
			String sql = "select * from admin where id=? and password=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, adm.getId());
			pstmt.setString(2, adm.getPassword());

			su = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
}
