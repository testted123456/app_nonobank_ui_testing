package com.nonobank.apps.appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DeviceOperation {
	public static List<String> getWindowDevices(){
		List<String> strList = new ArrayList<String>();
		try {
			Process process = null;
			process = Runtime.getRuntime().exec("adb devices");
			// TODO Auto-generated method stub
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			int num = 0;
			Map<String, String> devicesMap = new HashMap<String, String>();
			String [] arr = null;
			try {
				while ((line = input.readLine())!= null)
				{
					System.out.println(line);
					num++;
					if (num>1)
					{
						arr = line.split("	");
						devicesMap.put("device"+Integer.toString(num), arr[0]);
					}
					strList.add(line);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strList;
	}
	
	public static List<String> getMacDevices(){
		String cmd = "adb devices";
		String[] cmds = { "/bin/sh", "-c", cmd };
		Process process = null;
		List<String> strList = new ArrayList<String>();
		try {
			process = Runtime.getRuntime().exec(cmds);
			// TODO Auto-generated method stub
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			int num = 0;
			Map<String, String> devicesMap = new HashMap<String, String>();
			String[] arr = null;

			while ((line = input.readLine()) != null) {
				System.out.println(line);
				num++;
				if (num > 1) {
					arr = line.split("	");
					devicesMap.put("device" + Integer.toString(num), arr[0]);
				}
				strList.add(line);
			}
							
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
