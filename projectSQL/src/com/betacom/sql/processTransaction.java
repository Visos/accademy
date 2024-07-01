package com.betacom.sql;

import java.sql.Connection;
import java.util.Map;

import com.betacom.sql.utilities.DBUtilities;

public class processTransaction extends DBUtilities implements SQLProcess{
	private static SQLManager db = new SQLManager();

	@Override
	public void execute() {
		Connection con = db.transaction();
		System.out.println("after connection to transaction");		
		
		
		String sql = "insert into dipendenti (nome, cognome, data_assunzione, telefono, mansione, stipendio) values"
				+ "	(? , ? , ?, ? , ? , ?)";
		
		Map<Integer, Object> params = buildParameters(new Object[]{
				"Roberto",
				"transaction",
				"2022-02-09",
				"606725452",
				"Sviluppatore",
				2100
			});
		
		int rc = db.insert(con, sql, params);
		
		System.out.println("after insert: " + rc);
		
		boolean ok = false;
		if(ok) {
			db.commit(con);
			System.out.println("Transaction is commited");
		} else {
			db.rollback(con);
			System.out.println("Transaction is rolled back");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
