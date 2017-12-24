package demo.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import demo.dao.UserMapper;
import demo.entity.User;

@Service("UserService")
public class UserImpl implements UserI{
	
	@Inject
	private UserMapper um;
	
//	public UserMapper getUm() {
//		return um;
//	}
//	
//	@Autowired
//	public void setUm(UserMapper um) {
//		this.um = um;
//	}

	public User getUser(int id) {
		return um.selectByPrimaryKey(id);
	}

	public void setUser(User record) {
		um.insert(record);
		
		
	}


	
	

//	public User getUser(int id) {
//		return um.selectByPrimaryKey(id);
//	}

}
