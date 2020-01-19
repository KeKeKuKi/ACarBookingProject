package serVice;

import dao.userDao.*;

import dao.pojo.User;

public interface UserService {
	
	public User userLogin(User user);
	public boolean userRegister(User user);
	public boolean checkUserName(String userName);

}
