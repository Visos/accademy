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
import com.mysql.cj.jdbc.result.ResultSetMetaData;



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
		lD = transformResultInDTO(db.list(con, qry));		
		lD.forEach(d -> System.out.println(d));
		System.out.println("************************");
		
		

		//count brutto
		qry = "select count(*) as numero from dipendenti";
		List<Map<String, Object>> resultCount = db.list(con, qry);
		System.out.println("size: " + resultCount.size() + " numero: " + resultCount.get(0).get("numero"));


		qry = "select * from dipendenti";

		long number = db.count(con, qry);
		System.out.println("count bello:" + number);
		
		
		//-------MIA GET SENZA LIST------
		System.out.println("NELLA GET********");
		qry = "select nome from dipendenti where id_user = 4";
		Map<String, Object> resultGet =db.get(con, qry, new HashMap<Integer, Object>());
		System.out.println("prova daje: " + resultGet.get("nome"));
		
		System.out.println("FUORI GET*******");
		

		
	}
	


}
