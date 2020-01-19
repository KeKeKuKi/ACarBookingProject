package serVice;

import dao.userDao.*;

import dao.pojo.User;
import dao.userDao.UserDao;
import dao.userDao.userDaoImpl;

public class UserServiceImpl implements UserService{
	UserDao userDao = new userDaoImpl();

	@Override
	public User userLogin(User user) {
		
		return userDao.logIn(user);
	}

	@Override
	public boolean userRegister(User user) {
		if( userDao.register(user)>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean checkUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkUserName(userName);
	}

}
