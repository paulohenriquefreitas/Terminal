package br.com.terminal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.terminal.utils.JsonHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.terminal.model.Terminal;

public class TerminalDaoImpl implements TerminalDao {
	
	private static final Log LOG = LogFactory.getLog(TerminalDaoImpl.class);
	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

	@Override
	public String save(Terminal terminal) throws JsonProcessingException{
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
				
				String sqlInsert = "INSERT INTO terminal(logic,serial,model,sam,ptid,plat,version,mxr,mxf,VERFM)"
						+ "  VALUES (?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sqlInsert);
					
				pstmt.setInt(1, terminal.getLogic());
				pstmt.setString(2, terminal.getSerial());
				pstmt.setString(3, terminal.getModel());
				pstmt.setObject(4, terminal.getSam() != null ? terminal.getSam() : null);
				pstmt.setString(5, terminal.getPtid());
				pstmt.setObject(6, terminal.getPlat() != null ? terminal.getPlat() : null);
				pstmt.setString(7, terminal.getVersion());
				pstmt.setObject(8, terminal.getMxr() != null ? terminal.getMxr() : null);
				pstmt.setObject(9, terminal.getMxf() != null ? terminal.getMxf() : null);
				pstmt.setString(10, terminal.getVERFM());
				pstmt.execute();
				pstmt.close();
				st.close();
				conn.close();
				return JsonHandler.parseTerminalToJson(terminal);
			}
		} catch (SQLException ex) {
			LOG.error("An Exception occurred when save data. " + ex);
			return new Gson().toJson(ex.getMessage());
		}catch (Exception ex) {
            LOG.error("An Exception occurred when save data. " + ex);
            return new Gson().toJson(ex.getMessage());
        }
        return null;
    }

	@Override
	public List<Terminal> getAll() {
		Statement stm = null;
		List<Terminal> terminalList = new ArrayList<>();
		try {
			
			Connection conn = getConnection();
			String sql = "SELECT * FROM terminal";
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while ( rs.next() ) {				
				terminalList.add(Terminal.builder()
						                 .logic(rs.getInt("logic"))
						                 .serial(rs.getString("serial"))
						                 .model(rs.getString("model"))
						                 .sam(rs.getInt("sam"))
						                 .ptid(rs.getString("ptid"))
						                 .plat(rs.getInt("plat"))
						                 .version(rs.getString("version"))
						                 .mxr(rs.getInt("mxr"))
						                 .mxf(rs.getInt("mxf"))
						                 .VERFM(rs.getString("VERFM"))
						                 .build());
			
			}
		} catch (SQLException ex) {
			LOG.error("An Exception occurred when find alls datas. " + ex);
		}
		return terminalList;
	}

	@Override
	public Terminal findById(int logicId) {
		PreparedStatement pstmt = null;
		try {
			
			Connection conn = getConnection();
			String sql = "SELECT * FROM terminal where logic = ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logicId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
		    return Terminal.builder()
                    .logic(rs.getInt("logic"))
                    .serial(rs.getString("serial"))
                    .model(rs.getString("model"))
                    .sam(rs.getInt("sam"))
                    .ptid(rs.getString("ptid"))
	                .plat(rs.getInt("plat"))
	                .version(rs.getString("version"))
	                .mxr(rs.getInt("mxr"))
	                .mxf(rs.getInt("mxf"))
	                .VERFM(rs.getString("VERFM"))
	                .build();
			
			
		} catch (SQLException ex) {
			LOG.error("An Exception occurred when find one data. " + ex);
			return null;
		}		
	}
	
	public Connection getConnection() throws SQLException {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	@Override
	public String update(Terminal terminal, int logicId) throws JsonProcessingException {
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();		
			if (conn != null) {
				
				String sql = "UPDATE terminal SET serial = ?,model = ? ,sam = ?,ptid = ?,plat = ?,"
						+ "version = ?,mxr = ?,mxf = ?,VERFM = ?  WHERE logic = ?";
				pstmt = conn.prepareStatement(sql);					
				
				pstmt.setString(1, terminal.getSerial());
				pstmt.setString(2, terminal.getModel());
				pstmt.setObject(3, terminal.getSam() != null ? terminal.getSam() : null);
				pstmt.setString(4, terminal.getPtid());
				pstmt.setObject(5, terminal.getPlat() != null ? terminal.getPlat() : null);
				pstmt.setString(6, terminal.getVersion());
				pstmt.setObject(7, terminal.getMxr() != null ? terminal.getMxr() : null);
				pstmt.setObject(8, terminal.getMxf() != null ? terminal.getMxf() : null);
				pstmt.setString(9, terminal.getVERFM());
				pstmt.setObject(10, terminal.getLogic());
				pstmt.execute();
				pstmt.close();
				st.close();
				conn.close();

                return JsonHandler.parseTerminalToJson(terminal);
				
			}
		} catch (SQLException ex) {
            LOG.error("An Exception occurred when update data. " + ex);
            return new Gson().toJson(ex.toString());
        }catch (Exception ex) {
            LOG.error("An Exception occurred when update data. " + ex);
            return ex.toString();
        }
        return null;
	}

}
