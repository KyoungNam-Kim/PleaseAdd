package kr.co.namdoll;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.namdoll.dao.SampleDAO;

 
@RunWith(SpringJUnit4ClassRunner.class) // 문자열이아닐떈 .class까지 작성
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EnvironBasicTest {

	//@Autowired
	ApplicationContext context; //1번

	//@Autowired
	DataSource dataSource; //2번

/* 마이바티스쓰니까 주석처리
	@Autowired
	JdbcTemplate template; //3번
*/	
	
	//@Autowired  
	SqlSession session;  //4번
	
	//@Autowired
//	SampleDAO dao; //5번
	
	@Test
	public void contextTest() {//1번에 대한테스트
		assertNotNull("=======> " + context);
	}

	@Test
	public void dataSourceTest() { //2번에 대한 테스트 기본
		assertNotNull("=======> " + dataSource);
	}

	@Test
	public void jdbcDataSourceTest() {//2번에 대한 테스트 커넥션풀을 이용한 db 기본동작테스트
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement("select sysdate from dual");
			rs = ps.executeQuery();  
			// 위랑 동일한 방법 rs = dataSource.getConnection().prepareStatement("select sysdate from dual").executeQuery();
			assertNotNull(rs);
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " <===============");
			}
		}catch (SQLException e) {
		 
		}finally {
			
			try {
				rs.close();
				ps.close();
				ps.close();
				
			}catch(SQLException e){ 	e.printStackTrace(); 	} 
		} 
 }
/*	 마이바티스쓰니까 주석처리
	@Test
	public void jdbcTemplateTest() { //3번 테스트
		assertNotNull(dataSource);
		String result = template.queryForObject("select sysdate from dual", String.class);
		assertNotNull(result);
		System.out.println(result + " <===============");
	}
*/
	
	@Test
	public void sqlSessionTest() { //4번의 기본테스트
		assertNotNull(session);
	}
	

	@Test
	public void sampleDaoTest() { //5번의 기본테스트
	//	assertNotNull(dao);
		//String result = dao.getTime();  //마이바티스 기반 DB 동작 테스트
	//	assertNotNull(result);
	//	System.out.println("Mybatis=======> " + result + " <===============");
	}
	
	
	
	
	
	
	
}
