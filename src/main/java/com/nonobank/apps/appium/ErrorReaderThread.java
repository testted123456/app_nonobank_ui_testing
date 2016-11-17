package com.nonobank.apps.appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ErrorReaderThread implements Runnable {
	private static Process process;
	public static Process getProcess() {
		return process;
	}

	public static void setProcess(Process process) {
		ErrorReaderThread.process = process;
	}


	public void run() {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<String>();
		InputStreamReader reader = new InputStreamReader(process.getErrorStream());
		
		BufferedReader input = new BufferedReader(reader);
		
		String line = "";
		try {
			while ((line = input.readLine())!= null)
			{
				System.out.println("error:"+line);
				strList.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
