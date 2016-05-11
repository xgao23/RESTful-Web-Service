package org.koushik.javabrains.messenger2.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.messenger2.model.Message;
import org.koushik.javabrains.messenger2.model.Profile;

public class DatabaseClass {
	public class getProfile {

	}

	private static Map<Long,Message>message=new HashMap<>();
	private static Map<String,Profile> profile=new HashMap<>();
	
	public static Map<Long, Message> getMessage() {
		return message;
	}

	public static Map<String, Profile> getProfile() {
		return profile;
	}
	


}
