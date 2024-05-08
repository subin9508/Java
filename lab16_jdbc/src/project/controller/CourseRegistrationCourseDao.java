package project.controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import project.model.CourseRegistrationCourse;

@SuppressWarnings("all")
public class CourseRegistrationCourseDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static CourseRegistrationCourseDao instance;
	
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "SYSTEM";
	private String password = "0831";
	
	// 생성자
	public CourseRegistrationCourseDao() {
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
	public static CourseRegistrationCourseDao getInstance() {
		if(instance == null) {
			synchronized (CourseRegistrationCourseDao.class) {
				instance = new CourseRegistrationCourseDao();
			}
		}
		return instance;
	}
	
	// 시퀀스 생성
	public int getCourseNumber() {
		int CourseNumber = 0;
		String sql = "select COURSENUMBER.nextval from dual;";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			rs = pstmt.executeQuery(); // 실행
			
			rs.next();
			CourseNumber = rs.getInt(1);
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
		
		return CourseNumber;
	} // 시퀀스 생성
	
	public List<CourseRegistrationCourse> getCourseList() {
		List<CourseRegistrationCourse> crcList = new ArrayList<CourseRegistrationCourse>();
		
		try {
			String sql = "select * from courses order by CourseNumber";
			getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CourseRegistrationCourse course = new CourseRegistrationCourse();
				course.getCourseNumber(); // 고유키(?)
				course.setCourseTitle(rs.getString("courseTitle"));
				course.setTeacher(rs.getString("teacher"));
				course.setClassroom(rs.getString("classroom"));
				
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
	      return crcList;
		} // list 목록 end
	
	
	// 강좌 등록
	
	public void insertCourse(CourseRegistrationCourse crc) {
	      String sql = "insert into courses(couseNumber, courseTitle, teacher, classroom)"
	      						 + " values(COURSENUMBER.nextval, ?, ?, ?)";
	      getConnection();

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, crc.getCourseTitle());
	         pstmt.setString(2, crc.getTeacher());
	         pstmt.setString(3, crc.getClassroom());
	        
	         
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
 } // 강의 end
 
 // 삭제 메소드
 public void deleteCourse(int courseNumber) {
    String sql = "delete courses where courseNumber=?";
    getConnection();
    try {
       pstmt = conn.prepareStatement(sql);
       pstmt.setInt(1, courseNumber);
       pstmt.executeUpdate();// 실행

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
 }

 // 수정 메소드
 public void updateCourse(CourseRegistrationCourse crc) {
    String sql = "update course set courseTitle=?" + ",teacher=?" + ",classroom=?" + "where courseNumber=?";
    getConnection();
    try {
       pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, crc.getCourseTitle());
       pstmt.setString(2, crc.getTeacher());
       pstmt.setString(3, crc.getClassroom());
      

       pstmt.executeUpdate();

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
 }

 public List<CourseRegistrationCourse> getMyCourseList(List<Integer> listC) {
	 List<CourseRegistrationCourse> crcList = new ArrayList<CourseRegistrationCourse>();
	 
	 getConnection();
	
		 
	     try {
	    	for(int i=0; i<listC.size(); i++) {
		        String sql = "select * from courses where courseNumber=?";
	
		        pstmt = conn.prepareStatement(sql);// 생성
		        pstmt.setInt(1, listC.get(i));

		        rs = pstmt.executeQuery(); // 실행
		
		        while (rs.next()) {
					CourseRegistrationCourse crc = new CourseRegistrationCourse();
					crc.setCourseTitle(rs.getString("courseTitle"));
					crc.setTeacher(rs.getString("teacher"));
					crc.setClassroom(rs.getString("classroom"));
					crcList.add(crc);
				}
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
   return crcList;
} // list 목록 end

 
 
 // 메인 홈 list 목록 생성
 public String getHomeLCourseList() {
   String name = new String();
   
    try {
       String sql = "select * from courses order by CourseNumber desc";
       getConnection();

       pstmt = conn.prepareStatement(sql);// 생성
       rs = pstmt.executeQuery(); // 실행

       while (rs.next()) {
      	 name = rs.getString("courseTitle");
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
    return name;
 } // 메인 홈  list 목록 end

	
	
	}
	
	


