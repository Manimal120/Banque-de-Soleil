package code_class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Manager{
	public String managerId;
	public String managerPsd;
	
	
	public Manager() {
	}



	public boolean loginCheck(String managerId, String managerPsd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM manager WHERE ma_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, managerId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String a = rs.getString("ma_id");
				String b = rs.getString("ma_psd");
				if(managerId.equals(a) && managerPsd.equals(b))
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