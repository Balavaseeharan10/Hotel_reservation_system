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
	
	public static boolean validatePhone(String phone) {
		String pattern1="[0-9]{10}";
	    return phone.matches(pattern1);
	}
	
	public static boolean validateEmail(String email) {
	    return email.contains("@") && email.contains(".");
	}
	
	public static boolean validateAadhar(String aadhar) {
		String pattern2="[0-9]{12}";
	    return aadhar.matches(pattern2);
	}
	
	public static boolean validateYesOrNo(String value) {
	    return value.equalsIgnoreCase("YES")|| value.equalsIgnoreCase("NO");
	}
	
	
}
