package com.betacom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.betacom.object.ObjectCollection;

public class Main {

	public static void main(String[] args) {
//		/*
//		 * 		bit  byte  range di valore   cifre dopo la virgula
//		 * byte   8   1      -128 127
//		 * short 16   2      -32768  32767
//		 * int   32   4      +_ 2*(10)9
//		 * long  64   8      +_  9*(10)18
//		 * 
//		 *  float  32  4                        7
//		 *  double 64   8                       15
//		 *  boolean
//		 */
//		
//		
//		
//		//boolean i1= false;
//		byte    iByte = 127;
//		int     iInt  = 2_000_000_000;
//		long    iLong = 9_473_892_479_237L;
//		
//		float   iFloat = 5.345611f;
//		double  iDouble = 5.123552345657678;
//		
//		char    iChar  = 'f';
//		
//		String  iString = "ciao come stai?";
//		System.out.println(iString);
//		
//		System.out.println(iString.toUpperCase());
//		
//		Scanner sc = new Scanner(System.in);
//		String nome;
//		
//		System.out.println("Nome");
//		nome = sc.nextLine();
//		
//		
//	
//		System.out.println("Eta:");
//		int eta = sc.nextInt();
//		
//		String resto="";
//		
//		/*
//		 * operatori logici
//		 * &&  and
//		 * ||  or
//		 * < , > <= => 
//		 */
//			
//		
//		resto = (eta < 50) ? "e sono un ragazzino" : " e sono vecchio";
//		
//		
//		System.out.printf("Ciao sono %s  %s " , nome ,resto);
//		
//		
//		/*
//		 * - + / *
//		 */
//		String v = "1234";
//		//int i2 = Integer.parseInt(v);
//		
//		String aaa = "ajksjksjkjdkjkdjkjfkjfkjkfjkf";
//		
//		System.out.println("Length:" + aaa.length() + " substring:" + aaa.substring(2,8));
//		
//		String bbb = "start   ";
//		
//		if (bbb.trim().equalsIgnoreCase("Start"))
//			System.out.println("trovato");
//		else 
//			System.out.println("non trovato");
//
//		String[] array = new String[3];
//		array[0] = "aaaaa";
//		array[1] = "bbbbb";
//		array[2] = "ccccc";
//		
//		for (int i=0; i < array.length; i++) {
//			System.out.println("array [" + i +"] " + array[i]);
//		}
//		
//		for (String it:array) {
//			System.out.println("array " + it);
//			
//		}
//		
//		List<String> ccc = new ArrayList<String>();
//		ccc.add("bbbb");
//		ccc.add("cccc");
//		ccc.add("dddd");
//		ccc.add("eeee");
//		ccc.add("ffff");
//		ccc.add("gggg");
//		ccc.add("hhhh");
//		ccc.add("iiii");
//
//		for (String it:ccc) {
//			System.out.println("array " + it);			
//		}
//		
//		List<ObjectCollection> oc = new ArrayList<ObjectCollection>();
//		oc.add(new ObjectCollection("pippo", "verde"));
//		oc.add(new ObjectCollection("victor", "hugo"));
//		oc.add(new ObjectCollection("Giuseppe", "Rossi"));
//		oc.add(new ObjectCollection("Paolo", "Giallo"));
//		oc.add(new ObjectCollection("Anna", "Grande"));
//		oc.add(new ObjectCollection("Silvia", "Piccola"));
//		
//		ObjectCollection objToRemove = new ObjectCollection();
//		for (ObjectCollection it:oc) {
//			System.out.println("array " + it);
//			if (it.getCognome().equalsIgnoreCase("hugo"))
//				objToRemove = it;
//		}
//		oc.remove(objToRemove);
//		for (ObjectCollection it:oc) {
//			System.out.println("array after" + it);
//		}
//		
//		String[][] cl2d = new String[3][5];
//		
//		cl2d[0][0] = "pos 0 0";
//		cl2d[0][1] = "pos 0 1";
//		cl2d[0][2] = "pos 0 2";
//		cl2d[0][3] = "pos 0 3";
//		cl2d[0][4] = "pos 0 4";
//	
//		System.out.println("length:" + cl2d.length + "/" + cl2d[0].length);
//		
		
		
//LEZIONE 2
		
//		List<ObjectCollection> oc = new ArrayList<ObjectCollection>();
//
//		
//		List<List<ObjectCollection>> myList = new ArrayList<List<ObjectCollection>>();
//		
//		List<ObjectCollection> item = null;
//		
//		
//		item = new ArrayList<ObjectCollection>();
//		oc = new ArrayList<ObjectCollection>();
//		oc.add(new ObjectCollection("pippo" , "verde"));
//		oc.add(new ObjectCollection("victor", "hugo"));
//		oc.add(new ObjectCollection("Giuseppe", "Rossi"));
//		oc.add(new ObjectCollection("Paolo", "Giallo"));
//		oc.add(new ObjectCollection("Anna", "Grande"));
//		oc.add(new ObjectCollection("Silvia", "Piccola"));
//		
//		myList.add(oc);
//		
//		item = new ArrayList<ObjectCollection>();
//		oc = new ArrayList<ObjectCollection>();
//		oc.add(new ObjectCollection("pippo" , "verde"));
//		oc.add(new ObjectCollection("victor", "hugo"));
//		oc.add(new ObjectCollection("Giuseppe", "Rossi"));
//		oc.add(new ObjectCollection("Paolo", "Giallo"));
//		oc.add(new ObjectCollection("Anna", "Grande"));
//		oc.add(new ObjectCollection("Silvia", "Piccola"));
//		
//		myList.add(oc);
//
//		
//		item = new ArrayList<ObjectCollection>();
//		oc = new ArrayList<ObjectCollection>();
//		oc.add(new ObjectCollection("Silvia", "Piccola"));
//		
//		myList.add(oc);
//
//		
//		System.out.println("size" +  myList.size() + "oc: " + myList.get(0).size());
//		
//		for ( List<ObjectCollection> it : myList) {
//			for(ObjectCollection ob : it) {
//				System.out.println(ob.toString());
//			}
//		}
//		
//--------------------------------------------
		ObjectCollection o  = new ObjectCollection();
		o.nome = "ciao";			//provare i modificatori d'accesso private, protected, pubblic
		
		
	}

}
