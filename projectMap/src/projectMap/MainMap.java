package projectMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.StringValueExp;

public class MainMap {
	public static void main(String [] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		
		
		System.out.println("size: " + map.size());
		
		String ke1 = "k4";
		String value1 = "AAA";
		
		if (map.containsKey(ke1)) {
			System.out.println("key trovato");
		}else {
			System.out.println("non trovato");
		}
		System.out.println();

		
		if (map.containsValue(value1)) {
			System.out.println("valore trovato");
		}else {
			System.out.println("non trovato");
		}
		System.out.println();

		
		Set<String> keys = map.keySet();
		
		for(String k : keys) {
			System.out.println("key found: "+k + " valore: " + map.get(k));
		}
		System.out.println();

		
		Set<Entry<String ,String>> entry = map.entrySet();
		
		for(Entry<String ,String> e : entry) {
			System.out.println("key found: "+e.getKey() + " valore: " + e.getValue());
		}
		System.out.println();

		
		for(String s : map.values()) {
			System.out.println("Valore: "+  s);
		}
		System.out.println();

		
		Map<String, TestMap> mObject = new HashMap<String, TestMap>();	
		TestMap obj = null;
		String k = "map";
		System.out.println();

		
		for(int i = 0; i< 10;i++) {
			k+=String.valueOf(i);
			obj = new TestMap();
			obj.setC1("C1" + String.valueOf(i));
			obj.setC2("C2" + String.valueOf(i));
			mObject.put(k, obj);
			
		}
		System.out.println();

		System.out.println("mObject size: "+ mObject.size());
		
		for(Entry<String, TestMap> e : mObject.entrySet()) {
			System.out.println("key found: "+e.getKey() + " valore: " + ((TestMap)e.getValue()).toString());

		}
		System.out.println();
		
		System.out.println("size mObject: " + mObject.size());
		
		//test su in elemneto della testmap get c08
		
		
		
		
		
		
		//
		
		String s1 = "a,b,c,d,e,f,g";
		
		Set<String> hs = new HashSet<String>(Arrays.asList(s1.split(",")));
		
		if (hs.contains("b")){
			System.out.println("daje");
		}else
			System.out.println("non daje");
		
		
		List<Client> l = new ArrayList<Client>();
		l.add(new Client ( "gino", "postino", 80));
		l.add(new Client ( "ginetta", "postinetta", 90));
		l.add(new Client ( "franco", "rossi", 4));
		l.add(new Client ( "bello", "figo", 23));
		
		for(Client c : l) {
			System.out.println(c);
		}
		
		
		//anonymous class
//		l.sort(new Comparator<Client>() {
//
//			@Override
//			public int compare(Client a, Client b) {
//				return a.getAnni()-b.getAnni();
//			}	
//		});
		System.out.println();
		System.out.println();
		
		
		l.sort((Client a, Client b) -> a.getAnni() - b.getAnni());
		
		
		for(Client c : l) {
			System.out.println(c);
		}

		

	}
	

}
