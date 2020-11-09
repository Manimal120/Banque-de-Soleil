package code_class;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Client{
	public String clientId;
	public String clientPsd;
	public String clientFname;
	public String clientLname;
	public String clientSex;
	public Date clientDate;
	public String clientPhone;
	public String clientEmail;
	
	public Client() {
	}



	public boolean loginCheck(String clientId, String clientPsd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM client WHERE cl_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, clientId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String a = rs.getString("cl_id");
				String b = rs.getString("cl_psd");
				if(clientId.equals(a) && clientPsd.equals(b))
					result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
		return result;
	}
	
	public Client getInfo(String clientId) {
		
		Client user = new Client();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM client WHERE cl_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, clientId);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
				user.clientId = rs.getString("cl_id");
				user.clientPsd = rs.getString("cl_psd");
				user.clientFname = rs.getString("cl_fname");
				user.clientLname = rs.getString("cl_lname");
				user.clientSex = rs.getString("cl_sex");
				user.clientDate = rs.getDate("cl_date");
				user.clientPhone = rs.getString("cl_phone");
				user.clientEmail = rs.getString("cl_email");
			}
		} catch (Exception e) {			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return user;
	}
	
	public ArrayList<Client> getAll() {
		
		ArrayList<Client> users = new ArrayList<Client>(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM client WHERE cl_sex <> '0'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
				Client user = new Client();
				user.clientId = rs.getString("cl_id");
				user.clientPsd = rs.getString("cl_psd");
				user.clientFname = rs.getString("cl_fname");
				user.clientLname = rs.getString("cl_lname");
				user.clientSex = rs.getString("cl_sex");
				user.clientDate = rs.getDate("cl_date");
				user.clientPhone = rs.getString("cl_phone");
				user.clientEmail = rs.getString("cl_email");
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return users;
	}

	
	
	
//	public void setInfo(Client user) {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = MysqltoJava.getConnection();
//			String sql = "INSERT INTO client"
//					+ "(cl_id, cl_psd, cl_fname, cl_lname, cl_sex, cl_date, cl_phone, cl_email) "
//					+ "VALUES"
//					+ "(?,?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//		
//			ps.setString(1, user.clientId);
//			ps.setString(2, user.clientPsd);
//			ps.setString(3, user.clientFname);
//			ps.setString(4, user.clientLname);
//			ps.setString(5, user.clientSex);
//			ps.setDate(6, user.clientDate);
//			ps.setString(7, user.clientPhone);
//			ps.setString(8, user.clientEmail);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			MysqltoJava.close(conn, ps, rs);
//		}
//	}

	public void setInfo(Client user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "UPDATE client "
					+ "SET "
					+ "cl_fname=?, cl_lname=?, cl_sex=?, cl_date=?, cl_phone=?, cl_email=?"
					+ "WHERE cl_id = ?";
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, user.clientFname);
			ps.setString(2, user.clientLname);
			ps.setString(3, user.clientSex);
			ps.setDate(4, user.clientDate);
			ps.setString(5, user.clientPhone);
			ps.setString(6, user.clientEmail);
			ps.setString(7, user.clientId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	public void updateInfo(Client user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "UPDATE client "
					+ "SET "
					+ "cl_phone=?, cl_email=?"
					+ "WHERE cl_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.clientPhone);
			ps.setString(2, user.clientEmail);
			ps.setString(3, user.clientId);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	
}