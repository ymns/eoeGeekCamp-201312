package com.eoe.se2.day03;

import java.io.Serializable;
import java.util.ArrayList;

import com.eoe.se1.day01.User;

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public ArrayList<User> listUser;

	public Users() {
		listUser = new ArrayList<User>();
	}

}
