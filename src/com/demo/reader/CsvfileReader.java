package com.demo.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CsvfileReader {

	public static void main(String[] args) {
		String path = "C:\\Users\\koushikkr\\eclipse-workspace\\CsvFileReader\\src\\com\\demo\\reader\\Demo.csv";
		File file = new File(path);
		BufferedReader bufferedReader = null;
		int lineNoCount=0;
		String elementsArray[]=null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter line number:");
			int lineNumber = sc.nextInt();
			lineNumber++;
			System.out.println("Please enter element to search:");
			String searchElement = sc.next();
			System.out.println("Searched character is: "+searchElement);
			
			while(bufferedReader.read()!=-1) {
				String readLine=bufferedReader.readLine();
				lineNoCount++;				
				if(lineNoCount==lineNumber) {
					elementsArray=readLine.split(",");
				}
			}
			for(String search : elementsArray) {
				  if(search.equalsIgnoreCase(searchElement)) {
					  System.out.println("searching element found");
				  }
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
