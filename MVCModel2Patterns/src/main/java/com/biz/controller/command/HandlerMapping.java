package com.biz.controller.command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.biz.controller.Command;

public class HandlerMapping {
	
	private static HashMap<String,Command> commandList = new HashMap<String,Command>();
	
	public static void mapping(String configFile){
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream(configFile)); 
			Set keyList = props.keySet();
			
			Iterator<String> iter = keyList.iterator();
			
			while(iter.hasNext()){
				String key = iter.next();
				Command value = (Command) Class.forName(props.getProperty(key)).newInstance();
				commandList.put(key,value);
			}
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static Command getCommand(String action){ 
		return commandList.get(action);		
	}
}
