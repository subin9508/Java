package project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import jdbctest.JdbcTest;
import oracle.jdbc.OracleDriver;
import project.model.CourseRegistrationMember;
import project.jdbc.OracleJdbc.*;


public class CourseRegistrationMemberDao {
	
	Connection conn; // db와 연결된 객체
	PreparedStatement pstmt; // sql문을 담는 객체
	ResultSet rs; // sql문 결과를 담는 객체
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "SYSTEM";
	private String password = "0831"; 
	private static CourseRegistrationMemberDao instance = null;
	
	// 생성자
	public CourseRegistrationMemberDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // 생성자 end
	
	// 접속
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 접속 end
	
	//----> singleton 구현 시작
	public static CourseRegistrationMemberDao getInstance( ) {
		if(instance == null) {
			instance = new CourseRegistrationMemberDao();
		}
		return instance;
	} // <---- singleton 구현 end
	
	
	// list 목록 생성
		public List<CourseRegistrationMember> getMemberList() {
			List<CourseRegistrationMember> crmList = new ArrayList<CourseRegistrationMember>();

			try {
				String sql = "select * from system.courseregistrations order by id";
				getConnection();

				pstmt = conn.prepareStatement(sql);// 생성
				rs = pstmt.executeQuery(); // 실행

				while (rs.next()) {
					CourseRegistrationMember crm = new CourseRegistrationMember();
					crm.setUserNumber(rs.getInt("usernumber"));
					crm.setId(rs.getString("id"));
					crm.setName(rs.getString("name"));
					crm.setPassword(rs.getString("pw"));
					crm.setPhone(rs.getString("phone"));
					crm.setEmail(rs.getString("email"));
					
					crmList.add(crm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return crmList;
		}// list 목록 생성 end

		// 1. 등록 - insertMember
		public void insertMember(CourseRegistrationMember crm) throws Exception{

			getConnection();

			try {
				String sql = "insert into courseregistrations values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);// 생성

				pstmt.setInt(1, crm.getUserNumber());
				pstmt.setString(2, crm.getId());
				pstmt.setString(3, crm.getName());
				pstmt.setString(4, crm.getPassword());
				pstmt.setString(5, crm.getPhone());
				pstmt.setString(6, crm.getEmail());
				

				pstmt.executeUpdate();// 실행

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
		}// insertMember end

		// 2.로그인
		public int loginMember(CourseRegistrationMember crm) {
			int lg = 0;
			getConnection();

			try {
				String sql = "select * from courseregistrations where id=? and password=?";
				pstmt = conn.prepareStatement(sql);// 생성

				pstmt.setString(1, crm.getId());
				pstmt.setString(2, crm.getPassword());

				lg = pstmt.executeUpdate();// 실행

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
			return lg;
		} // 로그인 end
		
	
		// 중복 확인
		public int overlapMember(CourseRegistrationMember crm) {
		int ol = 0;
		getConnection();
		
		try {
			String sql = "select * from courseregistrations where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, crm.getId());
			
			ol = pstmt.executeUpdate();
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
		
		return ol;
	} // 중복 확인 end

	// 내 정보 확인 부분
		public CourseRegistrationMember myInformation(CourseRegistrationMember crm) {
			CourseRegistrationMember myCrm = new CourseRegistrationMember();
			
			getConnection();
			
			try {
				String sql = "select * from courseregistrations where id=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, crm.getId());
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					myCrm.setUserNumber(rs.getInt("userNumber"));
					myCrm.setId(rs.getString("id"));
					myCrm.setName(rs.getString("name"));
					myCrm.setPassword(rs.getString("password"));
					myCrm.setPhone(rs.getString("phone"));
					myCrm.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return myCrm;
		} // 내 정보 확인 end
	
	
	
} // class end

