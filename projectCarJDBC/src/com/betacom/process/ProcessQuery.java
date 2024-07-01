package com.betacom.process;

import java.sql.Connection;

import com.betacom.SQLManager;

public class ProcessQuery {
	private static SQLManager db = new SQLManager();
	private static String path = "./request.txt";
	
	public void execute() {
		
		Connection con = db.initSQL();

	}
	
	

}
