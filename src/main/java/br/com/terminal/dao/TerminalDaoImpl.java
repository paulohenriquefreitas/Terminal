package br.com.terminal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.terminal.model.Terminal;

public class TerminalDaoImpl implements TerminalDao{
	
	private static final Log LOG = LogFactory.getLog(TerminalDaoImpl.class);

	@Override
	public void save(Terminal terminal) {
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS terminal ("
					+ "logic integer PRIMARY KEY,"
					+ "serial varchar(30),"
					+ "model varchar(30),"
					+ "sam integer,"
					+ "ptid varchar(30),"
					+ "plat integer,"
					+ "version varchar(30),"
					+ "mxr integer,"
					+ "mxf integer,"
					+ "VERFM varchar(30)"
					+ ")";
			st.executeUpdate(sql);
			
			if (conn != null) {
				
				pstmt = conn.prepareStatement("INSERT INTO terminal(logic,serial,model,sam,ptid,plat,version,mxr,mxf,VERFM)"
						+ "  VALUES (?,?,?,?,?,?,?,?,?,?)");
					
				pstmt.setInt(1, terminal.getLogic());
				pstmt.setString(2, terminal.getSerial());
				pstmt.setString(3, terminal.getModel());
				pstmt.setInt(4, terminal.getSam());
				pstmt.setString(5, terminal.getPtid());
				pstmt.setInt(6, terminal.getPlat());
				pstmt.setString(7, terminal.getVersion());
				pstmt.setInt(8, terminal.getMxr());
				pstmt.setInt(9, terminal.getMxf());
				pstmt.setString(10, terminal.getVERFM());
				pstmt.execute();
				pstmt.close();
				conn.close();
				
				
			}
		} catch (SQLException ex) {
			LOG.error("An Exception occurred when save data. " + ex);
		}		
	}

	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());
		Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
		return conn;
	}

}
