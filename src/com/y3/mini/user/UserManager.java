package com.y3.mini.user;

import java.util.HashMap;

public class UserManager {
	
	HashMap<String, UserDTO> userInfo = new HashMap<>();
	

	public void addUser(String id, String pwd) {
		UserDTO user = new UserDTO(id,pwd, null);
		userInfo.put(id, user);
	}
}