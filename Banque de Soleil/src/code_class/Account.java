package code_class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account{
	public String cardId;
	public String cardPsd;
	public double cardBalance;
	public String cardOwnerId;
	
	public Account() {
	}
	
	
	


	public void setAcc(Account card) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "INSERT INTO bankcard"
					+ "(card_id, card_psd, card_balance, card_owner_id) "
					+ "VALUES"
					+ "(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, card.cardId);
			ps.setString(2, card.cardPsd);
			ps.setDouble(3, card.cardBalance);
			ps.setString(4, card.cardOwnerId);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	public ArrayList<Account> getAcc(String cardOwnerId) {
		
		ArrayList<Account> cards = new ArrayList<Account>(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM bankcard WHERE card_owner_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardOwnerId);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
			Account card = new Account();
			card.cardId = rs.getString("card_id");
			card.cardOwnerId = rs.getString("card_owner_id");
			card.cardBalance = rs.getDouble("card_balance");
			card.cardPsd = rs.getString("card_psd");
			
			cards.add(card);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return cards;
	}
	
public ArrayList<String> getAllAccId() {
		
		ArrayList<String> cards = new ArrayList<String>(); 
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM bankcard";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()) {
			String a = new String();
			a = rs.getString("card_id");
			cards.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return cards;
	}
	
	
	
	
	public void printCsv(String cardOwnerid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HHmmss");
			
			String sql = "SELECT * INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/" + df.format(new Date()) + ".csv'"
					+ " FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' "
					+ "FROM (SELECT 'Card ID', 'Card Balance' UNION SELECT card_id, card_balance FROM bankcard WHERE card_owner_id = " + cardOwnerid + ")b";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
	
	
	
	public void updateInfo(Account acc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "UPDATE bankcard "
					+ "SET "
					+ "card_balance=?"
					+ "WHERE card_id=?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, acc.cardBalance);
			ps.setString(2, acc.cardId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
	
			
	
	
	public Account getOneAcc(String cardID) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Account accA = new Account();
		
		try {
			conn = MysqltoJava.getConnection();
			String sql = "SELECT * FROM bankcard WHERE card_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardID);
			rs = ps.executeQuery();
			
			if(rs.next()) {
			
				rs.beforeFirst();
				while(rs.next()) {
					accA.cardBalance = rs.getDouble("card_balance");
					accA.cardId = rs.getString("card_id");
					accA.cardOwnerId = rs.getString("card_owner_id");
					accA.cardPsd = rs.getString("card_psd");
					}
				}else {
					accA.cardId = "NO";
					accA.cardBalance = 0;
					accA.cardOwnerId = "0";
					accA.cardPsd = "0";
					}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}return accA;
	}
	
	@Override
	public String toString() {
		return "Account [cardId=" + cardId + ", cardPsd=" + cardPsd + ", cardBalance=" + cardBalance + ", cardOwnerId="
				+ cardOwnerId + "]";
	}





	public void deleteAcc(String cardId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MysqltoJava.getConnection();
			String sql = "DELETE FROM bankcard WHERE card_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqltoJava.close(conn, ps, rs);
		}
	}
}