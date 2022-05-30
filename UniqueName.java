package com.corejava.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueName {

	public static void main(String[] args) throws IOException {
		//Creating scanner object for console input
		Scanner input = new Scanner(System.in);
		Integer deviceNameSize = input.nextInt();
		String []devicenames = new String[deviceNameSize]; //instantiation the array
		for(int i=0;i<deviceNameSize;i++)
			devicenames[i] = input.next(); //initializing the values
		input.close();
		System.out.println("devicenames = "+Arrays.asList(devicenames));
		String []uniqueDeviceNames = new UniqueName().deviceNamesSystem(devicenames);
		for(String s:uniqueDeviceNames)
			System.out.println(s);
		
	}
	
	/**
	 * 
	 * @param devicenames take the array of device names
	 * @return the unique device names in same order
	 */
	public String[] deviceNamesSystem(String []devicenames){
		Map<String, Integer> devices = new HashMap<String, Integer>();
		for(int i=0;i<devicenames.length;i++) {
			String deviceName = devicenames[i].toLowerCase();
			if(devices.containsKey(deviceName)) {
				devicenames[i] = deviceName+(devices.get(deviceName)+1);
				devices.put(deviceName, devices.get(deviceName)+1);
			}else {
				devicenames[i] = deviceName;
				devices.put(deviceName, 0);
			}
		}
		devices = null; // Making devices map to null for gc
		return devicenames;
	}
}
