package com.osa.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProApi {
	
	String fileName;
	String filePath="src\\main\\resources";
	
	public ProApi(String fileName){
		this.fileName=fileName;
		}
	
	public ProApi(String fileName, String filePath){
		this.fileName= fileName;
		this.filePath= filePath;		
	}
	
	public String propApi(String key) {
		Properties pr= new Properties();
		String value= null;
		try {
		String fullURL= filePath+fileName;
		pr.load(new FileInputStream(fullURL));
		value= pr.get(key).toString();
		}catch(IOException e) {
		System.out.println(e.getStackTrace());
			
		}
		return value;
		
	}
	
	

}
