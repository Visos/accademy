package com.betacom.process;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.betacom.SQLManager;
import com.betacom.utilities.DBUtilities;

public class ProcessUpdate extends DBUtilities{


	
	public void execute( SQLManager db, Map<String,List<String>> l) {
		Connection con = db.initSQL();
		
		
		System.out.println("----------------INIZIO UPDATE-------------");
		List<String> allParam= l.get("UPDATE");
		
		List<String> params = new ArrayList<String>();
		
		String tipo = (allParam.get(0));	//tipo

		Map<Integer, Object> toupdate = buildParameters(new Object[] {
				allParam.get(3),	//nuovo valore
				allParam.get(1),		//id
				allParam.get(2),	//parametro

		});
		int rc = 0;
		rc = db.update(con, toupdate);
		
		System.out.println("rc dopo update: " + rc);
		System.out.println("----------------FINE UPDATE-------------");
		
		
		
	}
	
	
}
