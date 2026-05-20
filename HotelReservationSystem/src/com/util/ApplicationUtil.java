package com.util;
import java.util.*;

public class ApplicationUtil {
	public static List<String> extractDetail(String input){
		
		List<String> details=new ArrayList<String>();
		String[] inputs=input.split(":");
		for(String s:inputs) {
			details.add(s);
		}
		return details;
	}
}
