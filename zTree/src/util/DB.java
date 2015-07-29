package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	//数据库用户名
	String userName="root";
	//数据库密码
	String userPassword="root";
	//数据库的URL
	String mdb=this.getClass().getClassLoader().getResource("test.mdb").getPath().substring(1);
	String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + mdb ;
	//定义一个连接对象
	Connection dbConn;   
	//错误信息串
	String errDesc;
    	
   	public DB()
   	{
   		//初始化操作
   		errDesc="";
   		dbConn=null;
   	}
   	
	//连接数据库
   	public Connection getConn()
   	{  
		//声明所用的类包
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			dbConn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}   		  		
	   	
	   	return dbConn;
   }
   
   //获取错误信息
   public String getErrDesc()
   {
   		return errDesc;	
   }

}
