package com.betacom.projectRandomAccess;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MianRandomAccess {
	
	
	static String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\random.txt";

	
	
	public static void main(String args[]) {
		
		try {
			System.out.println(new String (readCHrstFromFile(filePath, 1, 5)));
			
			
			
			writeDate(filePath, "ciaone", 4);
			
			appendDate(filePath, "sono alla fine");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	private static byte[] readCHrstFromFile(String filePath, int seek, int chars) throws IOException {
		
		RandomAccessFile file = new RandomAccessFile(filePath,  "r");
		file.seek(seek);
		byte[] bytes = new byte[chars];
		file.read(bytes);
		file.close();
		
		
		return bytes;
		
		
	}
	
	private static void writeDate(String path, String data, int seek) throws IOException {
		
		RandomAccessFile file = new RandomAccessFile(filePath,  "rw");
		file.seek(seek);
		file.write(data.getBytes());
		file.close();
		
		
	}
	
	
	private static void appendDate(String path, String data) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath,  "rw");
		file.seek(file.length());
		System.out.println("file pointer" + file.getFilePointer());
		file.write(data.getBytes());
		file.close();

		

	}



}
