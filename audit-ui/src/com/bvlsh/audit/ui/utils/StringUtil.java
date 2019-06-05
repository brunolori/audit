package com.bvlsh.audit.ui.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtil {

	
	public static boolean isNumber(String value)
	{
		try {
			
			Integer.valueOf(value);
			
			return true;
			
		}catch(NumberFormatException nf)
		{
			return false;
		}
	}
	
	
	public static boolean isValid(String value)
	{
		return value != null && !"".equals(value.trim());
	}
	
	public static String toUpper(String value)
	{
		if(!isValid(value)) return null;
		return value.trim().toUpperCase();
	}
	
	public static String formatSQ(String value)
	{
		if(isValid(value))
		{
			return value.trim().toUpperCase().replace("Ë","E").replace("Ç", "C");
		}
		return null;
	}
	
	
	public static String toString(InputStream is)
	{
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try {	
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}catch(Exception e) {return null;}
	 
		return stringBuilder.toString();
	}
	
	public static String formatDouble(double d)
    {
        return String.format("%.2f", d);
    }
	
}
