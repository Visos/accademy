package com.betacom.process;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.betacom.SQLManager;
import com.betacom.exception.SQLAcademyException;
import com.betacom.utilities.DBUtilities;
import com.betacom.process.Request;


public class ProcessDelete extends DBUtilities{


	
	public void execute( SQLManager db, Map<String,List<String>> l) {
		
		Connection con = db.initSQL();
		Request req = new Request();

		
		
		System.out.println("----------------INIZIO DELETE-------------");
		List<String> allParam= l.get("DELETE");
		
		try {
			req.checkDelete(allParam);
		} catch (SQLAcademyException e) {
			System.out.println(e.getMessage());	
			e.printStackTrace();
		}
		
		Map<Integer, Object> params = null;
		
		
		Map<Integer, Object> todel = buildParameters(new Object[] {
				allParam.get(1)		
		});
		int rc = 0;
		rc = db.delete(con, todel);
		
		params = buildParameters(new Object[] {
				"AUTO"
		});
		db.decrease(con, params);
		
		System.out.println("rc dopo delete: " + rc);
		System.out.println("----------------FINE DELETE-------------");

		
	}
}
