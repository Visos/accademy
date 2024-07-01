package com.betacom.process;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.betacom.SQLManager;
import com.betacom.oggetti.Macchina;
import com.betacom.utilities.DBUtilities;

	public class ProcessInsert extends DBUtilities{


	public void execute(SQLManager db, Map<String,List<String>> l) {
		
		//macchina da inserire la prendo dal db
		Connection con = db.initSQL();
		List<Map<String, Object>>resultGet =db.select(con);
		System.out.println(resultGet.get(0));
		
		
		//Macchina car = transformResultInMacchina(resultGet.get(0));
		
		System.out.println("la mia macchina da select SQL:");
		//System.out.println(car.toString());	
		//car.setNumerotarga("93333303");
		
		
		
		//-------------------------INSERT-------------------------------- 
		System.out.println("----------------INIZIO INSERT-------------");

		List<String> allParam= l.get("INSERT");
		System.out.println("lista size: " + allParam.size());
		Map<Integer, Object> params = null;
		String tipo  = allParam.get(0);
		int rc = 0;
		if(tipo.equalsIgnoreCase("macchina")) {
			params = buildParameters(new Object [] {
				allParam.get(allParam.size()-3),
				allParam.get(allParam.size()-2),
				allParam.get(allParam.size()-1),
			});
			
			rc = db.insertMacchina(con, params);
			
			
			params = buildParameters(new Object[] {
					"AUTO"
			});
			db.increase(con, params);
			
			
			params = buildParameters(new Object[] {
					allParam.get(1),
					allParam.get(2),
					allParam.get(3),
					allParam.get(4),
					allParam.get(5),
					allParam.get(6),
					allParam.get(7)
			});
			rc = 0;
			System.out.println("INSERIMENTO VEICOLOOOOOOOOOO");
			rc = db.insertVeicolo(con, params);
		}
		
		
		
		

		System.out.println("After insert veicolo rc: " + rc);
		System.out.println("----------------FINE INSERT-------------");

		

	}

}
