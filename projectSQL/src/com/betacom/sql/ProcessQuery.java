package com.betacom.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.sql.dao.Dipendenti;
import com.betacom.sql.utilities.DBUtilities;



public class ProcessQuery extends DBUtilities implements SQLProcess{
	private static SQLManager db = new SQLManager();

	@Override
	public void execute() {
		String dbURL = "jdbc:mysql://localhost:3306/dbprova";	
		Connection con = db.initSQL(dbURL, "root", "DataBase.345");
		System.out.println("after connection to db");
		
		db.listOfTable(con, "dbprova");
		
		String qry = "select * from dbprova.dipendenti where mansione = ? and stipendio > ?";
		
		
		Map<Integer, Object> params = buildParameters(new Object[]{
			"Sviluppatore", 1999
		});
		
		
		List<Map<String, Object>> result = db.list(con, qry, params);
		List<Dipendenti> lD = transformResultInDTO(result);
		
		lD.forEach(d -> System.out.println(d));
		
		System.out.println("************************");
		
		qry = "select * from dipendenti";
		lD = transformResultInDTO(db.list(con, qry, new HashMap<Integer, Object>()));		

		lD.forEach(d -> System.out.println(d));

		
	}
	


}
