package code_class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fofficer{
	public String fofficerId;
	public String fofficerPsd;
	
	
	public Fofficer() {
	}



	public boolean loginCheck(String fofficerId, String fofficerPsd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM fofficer WHERE fo_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fofficerId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String a = rs.getString("fo_id");
				String b = rs.getString("fo_psd");
				if(fofficerId.equals(a) && fofficerPsd.equals(b))
					result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
		return result;
	}
}