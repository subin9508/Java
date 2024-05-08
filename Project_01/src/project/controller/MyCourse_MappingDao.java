package project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import project.model.MyCourse_Mapping;

public class MyCourse_MappingDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MyCourse_MappingDao instance;
	
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "SYSTEM";
	private String password = "0831";
	
	// 생성자
	public MyCourse_MappingDao() {
		// db 인서트
		
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
	} // getConnection end
	
	// 싱글톤 구현
	public static MyCourse_MappingDao getInstance() {
		if(instance == null) {
			synchronized (MyCourse_MappingDao.class) {
				instance = new MyCourse_MappingDao();
			}
		}
		return instance;
	}
	
	// list 목록 생성
	public List<MyCourse_Mapping> getMappingList() {
		List<MyCourse_Mapping> mcmapList = new ArrayList<MyCourse_Mapping>();
		
		try {
			String sql = "select * from Mycourses";
			getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MyCourse_Mapping mcmap = new MyCourse_Mapping();
				mcmap.setId(rs.getString("id"));
				mcmap.setName(rs.getString("name"));
				mcmap.setCourseTitle(rs.getString("courseTitle"));
				mcmap.setCourseNumber(rs.getInt("courseNumber"));
				mcmap.setTeacher(rs.getString("teacher"));
				mcmap.setClassroom(rs.getString("classroom"));
				
				mcmapList.add(mcmap);
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
		return mcmapList;
	} // list 목록 생성 end
	
	// 수강신청
	public void applyCourse(MyCourse_Mapping mcmap) {
		getConnection();
		
		try {
			String sql = "insert into Mycourses(id, name, courseTitle, courseNumber, teacher, classroom) values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mcmap.getId());
			pstmt.setString(2, mcmap.getName());
			pstmt.setString(3, mcmap.getCourseTitle());
			pstmt.setInt(4, mcmap.getCourseNumber());
			pstmt.setString(5, mcmap.getTeacher());
			pstmt.setString(6, mcmap.getClassroom());
			
			pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) 
					pstmt.close();
				if(conn != null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // 수강신청 end
	
	
	// 수강 신청 여부 확인
	public int applyConfirmCourse(MyCourse_Mapping mcmap) {
		int ap = 0;
		getConnection();
		
		try {
			String sql = "select * from mycourses where id=? and coursenumber=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mcmap.getId());
			pstmt.setInt(2,  mcmap.getCourseNumber());
			
			ap = pstmt.executeUpdate();
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
		return ap;
	} // 수강 신청 여부 확인 end
	
	
	// 강좌 삭제
	public void deleteCourse(int courseNumber) {
		String sql = "delete Mycourses where courseNumber=?";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNumber);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null) 
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // 강좌 삭제 end
	
	// 나의 강의 목록
	public List<Integer> getMyCourseList(String id) {
		List<Integer> mcmapList = new ArrayList<Integer>();
		
		try {
			getConnection();
			String sql = "select * from Mycourses where id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				mcmapList.add(rs.getInt("courseNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null) 
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mcmapList;
	} // 나의 강의 목록 end
	
	
 }
	

