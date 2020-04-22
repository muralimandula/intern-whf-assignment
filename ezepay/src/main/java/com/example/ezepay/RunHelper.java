package com.example.ezepay;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RunHelper {
	
	public void killAndRun( ) throws IOException {
		
	/////// Retrieving previous process, Without using another file

//			String findPid = "netstat -ano | findstr 8080>test.txt";
//			Process findProcess = Runtime.getRuntime().exec(findPid);  //executing task kill
//			
//			Scanner sc = new Scanner(findProcess.getInputStream());
//			try {
//				String out = sc.nextLine();
//				System.out.println(out);
//			}catch (Exception e) {
//				// TODO: handle exception
//				System.out.println(e);
//				System.out.println("NO PORT RUNNING ON 8080");
//			}
//			sc.close();
			
			
	//////// Using pid.txt
		// getting previous pId, to kill
		
		String pid;
		File pidFile = new File("C:\\Users\\Muralidhar Mandula\\eclipse-workspace\\pid.txt");
		
		try {
			//
			Scanner scanner = new Scanner(pidFile);
			pid = scanner.nextLine();
			scanner.close();
	
			// killing/terminating previous process
			Process process = Runtime.getRuntime().exec("taskkill /F /pid " + pid);  //executing task kill
			
			//CMD response
			Scanner inScan = new Scanner(process.getInputStream());
			String out = inScan.nextLine();
			System.out.println(out);
			inScan.close();
			
			System.out.println("--------Previous process with pid, " + pid + " Killed.");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("NO PORT RUNNING ON 8080");
		}
		
		
		// -----------------------------------------------------getting current pId and writing it into the pid.txt
		pid = Long.toString(ProcessHandle.current().pid());
		FileWriter fw = new FileWriter(pidFile, false);
		fw.write(pid);
		fw.close();

		System.out.println("--------Current process with pid, " + pid +  " stored!");
	}
}

