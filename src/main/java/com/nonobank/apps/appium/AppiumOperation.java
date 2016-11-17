package com.nonobank.apps.appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.Executor;

import com.nonobank.apps.utils.file.ParseProperties;

public class AppiumOperation {

	public static final String APPIUMSERVERSTARTCMD = "/Contents/Resources/node_modules/.bin/appium -a 127.0.0.1 -p 4723  --automation-name 'Appium' --platform-name 'Android'";
	public static String WINDOWSAPPIUMSERVERSTART = "C:\\Program Files (x86)\\Appium\\node_modules\\.bin\\appium.cmd -a 127.0.0.1 -p ";
	public static Boolean flag = false;
	public static void startServerInMac(String strAppiumPort) {
		String appium_dir = ParseProperties.getInstance().getProperty("appium_dir");
		
		try {
			Process process = null;
			String cmdNode = appium_dir + "/Contents/Resources/node/bin/node ";
			String cmd = cmdNode + appium_dir + APPIUMSERVERSTARTCMD;
			String[] cmds = { "/bin/sh", "-c", cmd };
			process = Runtime.getRuntime().exec(cmds);

			ErrorReaderThread errThread = new ErrorReaderThread();
			errThread.setProcess(process);
			Thread thread = new Thread(errThread);
			thread.start();

			StreamReaderThread strThread = new StreamReaderThread();
			strThread.setProcess(process);

			Thread readerThread = new Thread(strThread);
			readerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void stopServerInMac(String strAppiumPort) {
		String cmd = "lsof -n -i:" + strAppiumPort + " | grep LISTEN | awk '{print $2}' | xargs kill";
		String natstatCmd = "lsof -i tcp:" + strAppiumPort;
		System.out.println(natstatCmd);
		Process process = null;
		List<String> strList = new ArrayList<String>();
		String[] cmds = { "/bin/sh", "-c", cmd };
		
		try {
			process = Runtime.getRuntime().exec(cmds);
			InputStreamReader reader = new InputStreamReader(process.getErrorStream());
			BufferedReader input = new BufferedReader(reader);
			String line = "";

			try {
				while ((line = input.readLine()) != null) {
					strList.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			InputStreamReader reader1 = new InputStreamReader(process.getErrorStream());
			BufferedReader input1 = new BufferedReader(reader1);

			String line1 = "";
			try {
				while ((line1 = input1.readLine()) != null) {
					strList.add(line1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void startWindowsServer(String strAppiumPort){
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		String cmd = WINDOWSAPPIUMSERVERSTART+strAppiumPort;
		CommandLine cmdLine = CommandLine.parse(cmd);
		ExecuteWatchdog dog = new ExecuteWatchdog(60 * 1000);
		Executor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.setWatchdog(dog);	
		try {
			executor.execute(cmdLine, resultHandler);
		} catch (ExecuteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			resultHandler.waitFor(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int runWithWatchDog(String line)
	{
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		ExecuteWatchdog watchdog = new ExecuteWatchdog(6000);
		executor.setWatchdog(watchdog);
		try {
			int exitValue = executor.execute(cmdLine);
			return exitValue;
		} catch (ExecuteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	public static void stopWindowsAppiumServer(String appiumServicePort)
	{
		runWithWatchDog("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in"
                + " (`netstat -nao ^| findstr /R /C:\"" + appiumServicePort + "\"`) do (FOR /F \"usebackq\" %b in"
                + " (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
	}
}
