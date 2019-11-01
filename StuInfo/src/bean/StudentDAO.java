package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class StudentDAO {
	public Boolean addStudent(StudentDTO student){
		boolean b = false;
		
		Connection conn = null;
		Statement  st = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConn();
			//st = conn.createStatement();
			//String sql = "select * from User_Table where user_name ='" + username +"' and user_password = '" + pwd + "'";
		    String sql = "insert into  student_table values (?,?,?,?,?,?,?)";
			System.out.println(sql);
			prst = conn.prepareStatement(sql);
			prst.setString(1, student.getStudent_id());
			prst.setString(2, student.getStudent_name());
			prst.setString(3, student.getStudent_sex());
			prst.setString(4, student.getStudent_birthday());
			prst.setString(5, student.getStudent_dept());
			prst.setString(6, student.getStudent_major());
			prst.setString(7, student.getStudent_classid());

		     //rs = st.executeQuery(sql);
			
		     
		     if (prst.executeUpdate() != 0) 
		    	 b = true;
		     else
		    	 b = false; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}



	public LinkedList<StudentDTO> queryAllStudent1(){
		
		boolean b = false; 
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		StudentDTO s = null;
		LinkedList<StudentDTO> list =  new LinkedList<StudentDTO>();
		try {
			conn = DBManager.getConn();
			
		    String sql = "select * from student_table";
			prst = conn.prepareStatement(sql);

			rs = prst.executeQuery();
		     
		    while(rs.next()) {
		    	s = new StudentDTO();
		    	s.setStudent_id(rs.getString("student_id"));
		    	s.setStudent_name(rs.getString("student_name"));
		    	s.setStudent_sex(rs.getString("student_sex"));
		    	s.setStudent_birthday(rs.getString("student_birthday"));
		    	s.setStudent_dept(rs.getString("student_dept"));
		    	s.setStudent_major(rs.getString("student_major"));
		    	s.setStudent_classid(rs.getString("student_classid"));	
		    	list.add(s);
		   }
		   for(StudentDTO stu : list){
	        	   System.out.println(stu.getStudent_id());
	        	   System.out.println(stu.getStudent_name());
	        	   System.out.println(stu.getStudent_sex());
	        	   System.out.println(stu.getStudent_birthday());
	        	   System.out.println(stu.getStudent_dept());
	        	   System.out.println(stu.getStudent_major());
	        	   System.out.println(stu.getStudent_classid());
	      }
		    	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		    	try {rs.close();} catch (SQLException e) {} 
		    	try {prst.close();} catch (SQLException e) {} 
		    	try {conn.close();} catch (SQLException e) {} 
	    }
		
		return list;
		
	}
	
public boolean deleteStudentByID(String id){
		
		boolean b = false; 
		Connection conn = null;
		PreparedStatement prst = null;
		try {
			conn = DBManager.getConn();
			
		    String sql = "delete from student_table where student_id = ? ";
			prst = conn.prepareStatement(sql);
			prst.setString(1, id);

			int i = prst.executeUpdate();
		     
			if (i > 0){
           	 
         	   b = true; 
            }
			else 
			   b = false;
		    	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		    	try {prst.close();} catch (SQLException e) {} 
		    	try {conn.close();} catch (SQLException e) {} 
	    }
		
		return b;
		
	}

public int ChangeStu(StudentDTO student){  
	 Connection conn = null;
		Statement  st = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
	   int result=-1;
	   String sql="update student_table set student_id=?,student_name=?,student_sex=?,student_birthday=?,student_dept=? ,student_major=?,student_classid=?  where student_id=?"; 
			try {
				conn=DBManager.getConn();
				conn.setAutoCommit(false);  //关闭更新操作的结果
				prst=conn.prepareStatement(sql);
				prst.setString(1,student.getStudent_id());	
				prst.setString(2,student.getStudent_name());			
				prst.setString(3,student.getStudent_sex());
				prst.setString(4,student.getStudent_birthday());
				prst.setString(5,student.getStudent_dept());	
				prst.setString(6,student.getStudent_major());	
				prst.setString(7,student.getStudent_classid());
				prst.setString(8,student.getStudent_id());	
				result=prst.executeUpdate();
				conn.commit();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	   return result;
  }

public LinkedList<StudentDTO> queryAllStudent(){
	
	boolean b = false; 
	Connection conn = null;
	PreparedStatement prst = null;
	ResultSet rs = null;
	StudentDTO s = null;
	LinkedList<StudentDTO> list =  new LinkedList<StudentDTO>();
	try {
		conn = DBManager.getConn();
		
	    String sql = "select * from student_table";
		prst = conn.prepareStatement(sql);

		rs = prst.executeQuery();
	     
	    while(rs.next()) {
	    	s = new StudentDTO();
	    	s.setStudent_id(rs.getString("student_id"));
	    	s.setStudent_name(rs.getString("student_name"));
	    	s.setStudent_sex(rs.getString("student_sex"));
	    	s.setStudent_birthday(rs.getString("student_birthday"));
	    	s.setStudent_dept(rs.getString("student_dept"));
	    	s.setStudent_major(rs.getString("student_major"));
	    	s.setStudent_classid(rs.getString("student_classid"));	
	    	list.add(s);
	   }		    	

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	    	try {rs.close();} catch (SQLException e) {} 
	    	try {prst.close();} catch (SQLException e) {} 
	    	try {conn.close();} catch (SQLException e) {} 
   }
	
	return list;
	
}

public StudentDTO queryStudentById(String id){
	
	boolean b = false; 
	Connection conn = null;
	PreparedStatement prst = null;
	ResultSet rs = null;
	StudentDTO s = new StudentDTO();;

	try {
		conn = DBManager.getConn();
		
	    String sql = "select * from student_table where student_id = ?";
		prst = conn.prepareStatement(sql);
		prst.setString(1, id);

		rs = prst.executeQuery();
	     
	    if (rs.next()) {
	    	s.setStudent_id(rs.getString("student_id"));
	    	s.setStudent_name(rs.getString("student_name"));
	    	s.setStudent_sex(rs.getString("student_sex"));
	    	s.setStudent_birthday(rs.getString("student_birthday"));
	    	s.setStudent_dept(rs.getString("student_dept"));
	    	s.setStudent_major(rs.getString("student_major"));
	    	s.setStudent_classid(rs.getString("student_classid"));	
	   }

        	   System.out.println(s.getStudent_id());
        	   System.out.println(s.getStudent_name());
        	   System.out.println(s.getStudent_sex());
        	   System.out.println(s.getStudent_birthday());
        	   System.out.println(s.getStudent_dept());
        	   System.out.println(s.getStudent_major());
        	   System.out.println(s.getStudent_classid());
	    	

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	    	try {rs.close();} catch (SQLException e) {} 
	    	try {prst.close();} catch (SQLException e) {} 
	    	try {conn.close();} catch (SQLException e) {} 
    }
	
	return s;
	
}

public boolean update(String id, String name, String sex, String birthday, 
		String dept, String major, String classid) {
	System.out.println(id);
	boolean b = false; 
	Connection conn = null;
	PreparedStatement prst = null;
	
	try {
		conn = DBManager.getConn();
		
	    String sql = "Update  student_table Set student_name = ?,student_sex = ?, student_birthday = ?, student_dept= ?, student_major = ?, student_classid = ?  where student_id = ? ";
	    //String sql = "update User_Table set password = '111111' where username = 'www'";
		prst = conn.prepareStatement(sql);
		
		System.out.println("test");
		
		
		prst.setString(1, name);
		prst.setString(2, sex);
		prst.setString(3, birthday);
		prst.setString(4, dept);
		prst.setString(5, major);
		prst.setString(6, classid);
		prst.setString(7, id);
		

		int i = prst.executeUpdate();
	     
		if (i > 0){
       	 
     	   b = true; 
        }
		else 
		   b = false;
	    	

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	    	try {prst.close();} catch (SQLException e) {} 
	    	try {conn.close();} catch (SQLException e) {} 
    }
	
	return b;
	

}

}





