package com.betacom;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.betacom.config.SQLConfiguration;
import com.betacom.exception.SQLAcademyException;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class SQLManager {
	
	private ArrayList<String> arrayList;

	public Connection initSQL () {
		Connection con = null;

		try {
			
			String driver;
			driver = SQLConfiguration.getInstance().getDriver();

			Class.forName(driver);
			
			con = DriverManager.getConnection(SQLConfiguration.getInstance().getUrl(), SQLConfiguration.getInstance().getUser(), SQLConfiguration.getInstance().getPwd());
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found: " + e.getMessage());
			e.printStackTrace();
		} catch ( SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLAcademyException e) {
			System.out.println("error in configuration " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;	
	}
	
	// ---------DA FARE
	public Connection transaction () {
		
		Connection con = null;
		
		try {
			String driver;
			driver = SQLConfiguration.getInstance().getDriver();
			Class.forName(driver);
			
			con = DriverManager.getConnection(SQLConfiguration.getInstance().getUrl(), SQLConfiguration.getInstance().getUser(), SQLConfiguration.getInstance().getPwd());
			con.setAutoCommit(false);			//dovro fare commit manualmente alla fine
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found: " + e.getMessage());
			e.printStackTrace();
		} catch ( SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLAcademyException e) {
			System.out.println("error in configuration " + e.getMessage());
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
		int column = md.getColumnCount();

		rs.next();
		for(int i = 1; i<=column; ++i) {
			map.put(md.getColumnName(i), rs.getObject(i));
		}
		return map;
	}
	
	
	
	public int insertMacchina(Connection con, Map<Integer, Object> params) {
		int rc = 0;
		try {
			System.out.println("pramas: " + params);


			PreparedStatement cmd = con.prepareStatement(SQLConfiguration.getInstance().getInsertMacchina());
			System.out.println("CMD" + cmd);

			cmd = createSet(cmd, params);

			rc = cmd.executeUpdate();
						
		} catch (Exception e) {
			System.out.println("insert error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	public int insertVeicolo(Connection con, Map<Integer, Object> params) {
		int rc = 0;
		try {
			System.out.println("pramas: " + params);


			PreparedStatement cmd = con.prepareStatement(SQLConfiguration.getInstance().getInsertVeicolo());
			System.out.println("CMD" + cmd);

			cmd = createSet(cmd, params);
			
			System.out.println("CMD VEICOLO : " + cmd);

			rc = cmd.executeUpdate();
						
		} catch (Exception e) {
			System.out.println("insert error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	public int update(Connection con, Map<Integer, Object> params) {
		int rc = 0;
		try {
			
			String qry = SQLConfiguration.getInstance().getUpdate();
			
			qry = qry.replaceAll("!", params.get(3).toString());
			params.remove(3);
			
			System.out.println("QRY: " + params);
			
			PreparedStatement cmd = con.prepareStatement(qry);
			
			cmd = createSet(cmd, params);
			System.out.println("CMD" + cmd);

			rc = cmd.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("update error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	public int delete(Connection con, Map<Integer, Object> params) {
		int rc = 0;
		try {
			PreparedStatement cmd = con.prepareStatement(SQLConfiguration.getInstance().getDelete());
			
			cmd = createSet(cmd, params);
			rc = cmd.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("update error: " + e.getMessage());		
		}
		
		return rc;
	}
	
	
	public void commit(Connection con) {
		try {
			con.commit();
			
		} catch (Exception e) {
			System.out.println("errore on commit: " + e.getMessage());
			e.printStackTrace();
			}
		
	}
	
	public void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			System.out.println("errore on rollback: " + e.getMessage());
			e.printStackTrace();
			}
		
	}
	
	
	public List<Map<String, Object>> select(Connection con) {
		try {
			PreparedStatement cmd = con.prepareStatement(SQLConfiguration.getInstance().getSelect());
								
			ResultSet res = cmd.executeQuery();	
			
			return resultSetList(res);
			
		}  catch ( Exception e) {
			System.out.println("error found in select: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void increase(Connection con ,Map<Integer, Object> params) {

		String qry = "update dbcar.contatore set contatore = contatore + 1 where id = ?";
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			cmd = createSet(cmd, params);
			cmd.execute();
		} catch (SQLException e) {
			System.out.println("error found in increase: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void decrease(Connection con ,Map<Integer, Object> params) {

		String qry = "update dbcar.contatore set contatore = contatore - 1 where id = ?";
		try {
			PreparedStatement cmd = con.prepareStatement(qry);
			cmd = createSet(cmd, params);
			cmd.execute();
		} catch (SQLException e) {
			System.out.println("error found in increase: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
