package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Code {

	public static void main(String args[]) {
	}
	
public static String[] checkShift(String shift) throws IOException {
	String[] empArray;
		switch (shift) {
		case "Days": {
			empArray = setEmployees(0);
			break;
		}
		case "Swings": {
			empArray = setEmployees(1);
			break;
		}
		case "Mids": {
			empArray = setEmployees(2);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + shift);
		}
		return empArray;
	};

	public static String[] setEmployees(int shiftNumber) throws IOException {
		File shiftFile = null;
		switch (shiftNumber) {
		case 0: {
			shiftFile = new File("src\\datastore\\shift_days_employees");
			break;
		}
		case 1: {
			shiftFile = new File("src\\datastore\\shift_swings_employees");
			break;
		}
		case 2: {
			shiftFile = new File("src\\datastore\\shift_mids_employees");
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + shiftNumber);
		}
		}
		FileReader reader = new FileReader(shiftFile);
		BufferedReader br = new BufferedReader(reader); // creates a buffering character input stream
		String line;
		String[] empArray = new String[10];
		int i = 0;
		while ((line = br.readLine()) != null) {
//			System.out.println(i);
			empArray[i] = line; // appends line to string buffer
			i++;
		}
		for (int j = 0; j < empArray.length; j++) {
			if (empArray[j] == null) {
				empArray[j] = "None";
			}
//			System.out.println(empArray[j]);
		}
		reader.close(); // closes the stream and release the resources
		return empArray;
	};
	
}
