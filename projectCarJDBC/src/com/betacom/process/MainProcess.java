package com.betacom.process;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.betacom.SQLManager;
import com.betacom.oggetti.Macchina;

import com.betacom.utilities.DBUtilities;

public class MainProcess extends DBUtilities{
	
	private static SQLManager db = new SQLManager();
	private static String path = "./request.txt";



	public void execute() {
		Connection con = db.initSQL();
		Map<String,List<String>> l = readLlne(path);

		
		//select
		
		
//		List<Map<String, Object>>resultGet =db.select(con);
//		Macchina car = transformResultInMacchina(resultGet.get(0));
//		
//		System.out.println("la mia macchina da select SQL:");
//		System.out.println(car.toString());
		
		boolean flag = true;
		
		while (flag) {
			Scanner input = new Scanner(System.in);
			System.out.println("delete D -update U  -insert I  -exit E");
			String option = input.nextLine();
			
			if(option.equalsIgnoreCase("d"))  new ProcessDelete().execute(db, l);
			else if(option.equalsIgnoreCase("u")) new ProcessUpdate().execute(db, l);
			else if(option.equalsIgnoreCase("i"))  new ProcessInsert().execute(db, l);
			else if(option.equalsIgnoreCase("e")) flag = false;
		}
	}
}
