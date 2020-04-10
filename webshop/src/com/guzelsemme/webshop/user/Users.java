package com.guzelsemme.webshop.user;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.guzelsemme.webshop.dblayer.DBHelper;
import com.guzelsemme.webshop.entities.User;

@ManagedBean
public class Users {
	List<User> userList = new ArrayList();
	
	public Users() {
		userList = new DBHelper().getUserList();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
