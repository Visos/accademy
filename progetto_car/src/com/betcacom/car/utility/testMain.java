package com.betcacom.car.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMain {

	public static void main(String[] args) {

		Reader r = new Reader();
		String path = "C:\\Users\\Betacom\\Documenti\\Gfile\\listeMacchine2.txt";
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		map = r.getMapFile2(path);
		
		System.out.println("key:" + map.keySet());
		
		System.out.println(map.get("TipoMachina"));
		System.out.println(map.get("TipoMoto"));
		System.out.println(map.get("TipoBici"));


		
	}

}
