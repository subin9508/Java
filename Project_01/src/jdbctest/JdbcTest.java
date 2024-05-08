package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
		String password = "0831";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("오라클 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패"); // 드라이버 주소가 잘못됨.
		} catch(SQLException e) {
			System.out.println("연결 실패"); // url이 잘못됨.
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
		}
		
		
		
		
	}

}
