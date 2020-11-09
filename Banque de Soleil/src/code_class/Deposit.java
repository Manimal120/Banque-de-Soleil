package code_class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Deposit{
	public String deposId;
	public String deposOwnerId;
	public Timestamp deposDate;
	public String deposToCardId;
	public Double deposAmount;
	public Double deposBalance;
	
	public Deposit() {
	}
	
	public void setDepos(Deposit record) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			
			Date d = new Date(); // 
			Timestamp timestamp = new Timestamp(d.getTime());
			
			String sql = "INSERT INTO deposit"
					+ "(depos_date, depos_to_card_id, depos_amount, depos_owner_id, depos_balance) "
					+ "VALUES"
					+ "(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setString(2, record.deposToCardId);
			ps.setDouble(3, record.deposAmount);
			ps.setString(4, record.deposOwnerId);
			ps.setDouble(5, record.deposBalance);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Deposit [deposId=" + deposId + ", deposOwnerId=" + deposOwnerId + ", deposDate=" + deposDate
				+ ", deposToCardId=" + deposToCardId + ", deposAmount=" + deposAmount + ", deposBalance=" + deposBalance
				+ "]";
	}

	public ArrayList<Deposit> getDepos(String deposOwnerId) {
		
		ArrayList<Deposit> records = new ArrayList<Deposit>(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM deposit WHERE depos_owner_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deposOwnerId);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
				Deposit record = new Deposit();
				
				record.deposId = rs.getString("depos_id");
				record.deposOwnerId = rs.getString("depos_owner_id");
				record.deposDate = rs.getTimestamp("depos_date");
				record.deposToCardId = rs.getString("depos_to_card_id");
				record.deposAmount = rs.getDouble("depos_amount");
				record.deposBalance = rs.getDouble("depos_balance");
				
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return records;
	}
	
	public ArrayList<Deposit> getTransByDate(String dateFrom, String dateTo){
		
		ArrayList<Deposit> records = new ArrayList<Deposit>(); 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM deposit WHERE depos_owner_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deposOwnerId);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
				Deposit record = new Deposit();
				
				record.deposId = rs.getString("depos_id");
				record.deposOwnerId = rs.getString("depos_owner_id");
				record.deposDate = rs.getTimestamp("depos_date");
				record.deposToCardId = rs.getString("depos_to_card_id");
				record.deposAmount = rs.getDouble("depos_amount");
				
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return records;
	}
}