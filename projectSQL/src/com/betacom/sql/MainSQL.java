package com.betacom.sql;

import java.util.Scanner;

public class MainSQL {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("query Q -update U");
		String option = input.nextLine();
		SQLProcess pro = null;
		
		if(option.equalsIgnoreCase("q")) pro = new ProcessQuery();
		else if(option.equalsIgnoreCase("u")) pro = new ProcessUpdate();
		
		pro.execute();
		
		
		System.out.println("end of process.....");
		
		
		
	}

}
