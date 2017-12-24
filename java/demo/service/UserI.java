package demo.service;

import demo.entity.User;

public interface UserI {
	
	public User getUser(int id);
	
	public void setUser(User record);
}
