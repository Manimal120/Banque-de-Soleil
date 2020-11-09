package code_class;
import java.sql.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Transfer{
	public String transId;
	public Timestamp transDate;
	public String transCardId;
	public String transToCardId;
	public Double transAmount;
	public Double transCardBalance;
	public Double transToCardBalance;
	
	public Transfer() {
	}
	
	public void setTrans(Transfer info) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			
			Date d = new Date(); // 
			Timestamp timestamp = new Timestamp(d.getTime());
 
			
			String sql = "INSERT INTO transfer"
					+ "(trans_date, trans_card_id, trans_to_card_id, trans_amount, trans_card_balance, trans_to_card_balance) "
					+ "VALUES"
					+ "(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setString(2, info.transCardId);
			ps.setString(3, info.transToCardId);
			ps.setDouble(4, info.transAmount);
			ps.setDouble(5, info.transCardBalance);
			ps.setDouble(6, info.transToCardBalance);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	
	
	

	@Override
	public String toString() {
		return "Transfer [transId=" + transId + ", transDate=" + transDate + ", transCardId=" + transCardId
				+ ", transToCardId=" + transToCardId + ", transAmount=" + transAmount + ", transCardBalance="
				+ transCardBalance + ", transToCardBalance=" + transToCardBalance + "]";
	}

	public ArrayList<Transfer> getTrans(String transCardId) {
		
		ArrayList<Transfer> infos = new ArrayList<Transfer>(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM transfer WHERE trans_card_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, transCardId);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
				Transfer info = new Transfer();
				info.transId = rs.getString("trans_id");
				info.transCardId = rs.getString("trans_card_id");
				info.transDate = rs.getTimestamp("trans_date");
				info.transToCardId = rs.getString("trans_to_card_id");
				info.transAmount = rs.getDouble("trans_amount");
				info.transCardBalance = rs.getDouble("trans_card_balance");
				info.transToCardBalance = rs.getDouble("trans_to_card_balance");
				infos.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return infos;
	}
}