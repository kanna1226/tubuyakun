package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MuttersDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/data/tubuyakun";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))  {
			String sql = "SELECT ID,USER_ID, NAME, TEXT, DATE FROM MUTTERS ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Timestamp date = rs.getTimestamp("DATE");
				Mutter mutter = new Mutter(id, userId, userName, text, date);
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO MUTTERS(USER_ID, NAME, TEXT, DATE) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, mutter.getUserId());
			pStmt.setString(2, mutter.getUserName());
			pStmt.setString(3, mutter.getText());
			pStmt.setTimestamp(4, mutter.getDate());
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
