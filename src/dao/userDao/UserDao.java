package dao.userDao;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import dao.pojo.User;

public interface UserDao {
	public User logIn(User user);
	public int register(User user);
	public String getEmailKey(String email) throws MessagingException;
	public boolean checkUserName(String userName);

}
