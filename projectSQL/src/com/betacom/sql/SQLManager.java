package com.betacom.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSetMetaData;


public class SQLManager {
	
	public Connection initSQL (String url, String user, String pwd) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection con = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pwd);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found: " + e.getMessage());
			e.printStackTrace();
		} catch ( SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;	
	}
	
	public void listOfTable(Connection con, String dbName) {
		
		try {
			DatabaseMetaData dbMD = con.getMetaData();
			ResultSet res = dbMD.getTables(dbName, null, null, null);
			
			while(res.next()) {
				
				System.out.println("Table name: " + res.getString("TABLE_NAME"));
			}
		} catch ( SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	

	
	public List<Map<String, Object>> list(Connection con, String qry) {
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
								
			ResultSet res = cmd.executeQuery();	
			
			return resultSetList(res);
			
		}  catch ( Exception e) {
			System.out.println("error found in list: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Map<String, Object>> list(Connection con, String qry, Map<Integer, Object> params) {
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
					
			ResultSet res = cmd.executeQuery();	
			
			return resultSetList(res);
			
		}  catch ( Exception e) {
			System.out.println("error found in list: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Map<String, Object> get(Connection con, String qry, Map<Integer, Object> params) {
		try {
			
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
					
			ResultSet res = cmd.executeQuery();

			
			return resultSet(res);
			
		}  catch ( Exception e) {
			System.out.println("error found in list: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	public long count(Connection con, String qry) {
		try {
			String countqry = "select count(*) as total from (" + qry + ") as numero";
			PreparedStatement cmd = con.prepareStatement(countqry);
			ResultSet res = cmd.executeQuery();	
			
			res.next();
			return (Long)res.getObject("total");
			
		}  catch ( Exception e) {
			System.out.println("error found in list: " + e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public long count(Connection con, String qry, Map<Integer, Object> params) {
		try {
			
			String countqry = "select count(*) from " + qry + "as numero";
			PreparedStatement cmd = con.prepareStatement(countqry);
			cmd = createSet(cmd, params);
			ResultSet res = cmd.executeQuery();	
			
			res.next();
			return (Long)res.getObject("numero");
			
		}  catch ( Exception e) {
			System.out.println("error found in list: " + e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}


	private PreparedStatement createSet(PreparedStatement cmd, Map<Integer, Object> params) {
		params.entrySet().forEach(s -> {
			try {
				cmd.setObject(s.getKey(), s.getValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return cmd;
	}
	
	private List<Map<String , Object>> resultSetList(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();
		int column = md.getColumnCount();
		List<Map<String , Object>> rows = new ArrayList<Map<String , Object>>();
		
		while(rs.next()) {
			Map<String , Object> row = new HashMap<String, Object>();
			for(int i = 1; i<=column; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
		}
		return rows;
	}
	
	private Map<String , Object> resultSet(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();
		Map<String , Object> map = new HashMap<String , Object>();
		
		while(rs.next()) {
			map.put(md.getColumnName(1), rs.getObject(1));		//errore column index out of range

		}
		return map;
	}
	
	
	
	public int insert(Connection con, String qry, Map<Integer, Object> params) {
		int rc = 0;
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
			rc = cmd.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	public int update(Connection con, String qry, Map<Integer, Object> params) {
		int rc = 0;
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
			rc = cmd.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("update error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	public int delete(Connection con, String qry, Map<Integer, Object> params) {
		int rc = 0;
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
			rc = cmd.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("update error: " + e.getMessage());		
		}
		
		return rc;
	}
	
}
