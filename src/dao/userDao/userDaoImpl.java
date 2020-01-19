package dao.userDao;


import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import dao.pojo.User;
import dao.tools.ConnectionTool;



public class userDaoImpl implements UserDao{
	@Override
	public User logIn(User user) {
		Connection con = null;
		PreparedStatement pStatement =null;
     	 	try {	
     	 		con=ConnectionTool.getConnection();
     	 		if(con==null) {
     	 			return null;
     	 		}
     	 		String sql = "SELECT * FROM user";
     	 		pStatement = con.prepareStatement(sql);//预编译，提高性能
     	 		ResultSet re = pStatement.executeQuery();
     	 		while(re.next()){
     	 			if(re.getString(2).equals(user.getUserName())&&re.getString(3).equals(user.getUserPassword())) {
     	 				return user;
     	 			}
   				
     	 			if(re.isLast())	{
     	 				return null;
     	 			}
     	 		}
     	 		
     	 	}catch (Exception e){
     	 		e.printStackTrace();
     	 		return null;
     	 	}finally {
      			try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
     	 	  
		
		return null;
	}

	@Override
	public int register(User user) {
		Connection con =null;
		try {
      	 	try {
    			String name = user.getUserName();
    			String password = user.getUserPassword();
    			String email =user.getUserEmail();
    			String phonrNumber = user.getPhoneNumber();
    			
    			con =ConnectionTool.getConnection();


       			String sql2 = "insert into user (name,password,email,phonenumber) values(?,?,?,?)";
       			PreparedStatement pStatement2 = con.prepareStatement(sql2);//预编译，提高性能

       			pStatement2.setString(1, name);
       			pStatement2.setString(2, password);
       			pStatement2.setString(3, email);
       			pStatement2.setString(4,phonrNumber);
       			int x = pStatement2.executeUpdate();
       			return x;
    			
    		}
    		catch (Exception sqle){
    			System.out.println("SQL错误！");
    			return 0;
    		}finally {
    			con.close();
    		}
      	 	 
   		 } catch (Exception e){
   			System.out.println("找不到驱动类!");
   			return 0;
 		 }
	}


	public String getEmailKey(String email) throws MessagingException {
		Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com"); //// 设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码

        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf =null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤

        //创建定义整个应用程序所需的环境信息的 Session 对象

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("545646733@qq.com", "授权码");
            }
        });


        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(false);

        //2、通过session得到transport对象
        Transport ts = session.getTransport();

        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "2669918628@qq.com", "dpytsqmttvhudjdc");

        //4、创建邮件

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("2669918628@qq.com"));

        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //邮件的标题
        message.setSubject("只包含文本的简单邮件");

        int mailkey = (int)((Math.random()*9+1)*10000);
        //邮件的文本内容
        message.setContent("您在carBooking上的验证码是：<h2>"+mailkey+"</h2>", "text/html;charset=UTF-8");

        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        ts.close();
		return mailkey+"";

	}

	@Override
	public boolean checkUserName(String userName) {
		Connection con =null;
		try {
      	 	try {
    			con =ConnectionTool.getConnection();


       			String sql2 = "select * from user";
       			PreparedStatement pStatement2 = con.prepareStatement(sql2);
       			ResultSet re = pStatement2.executeQuery();
     	 		while(re.next()){
     	 			if(re.getString(2).equals(userName)) {
     	 				return false;
     	 			}
     	 		}
    			
    		}
    		catch (Exception sqle){
    			System.out.println("SQL错误！");
    			return false;
    		}finally {
    			con.close();
    		}
      	 	 
   		 } catch (Exception e){
   			System.out.println("找不到驱动类!");
   			return false;
 		 }
		return true;
	}

}
