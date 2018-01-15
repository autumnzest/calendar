package com.kame.admin;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginAdminBean implements java.io.Serializable{
	DataSource ds = null;
	private int id;
	private String username = new String();
	private String password = new String();
	private boolean isUser = false;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return username;}
	public void setName(String name) {this.username=username;}
	public void setPassword(String password) {this.password=password;}
	
	public boolean getAuth() {
		return isUser;
	}
	
	public LoginAdminBean() throws SQLException, NamingException{
		InitialContext jnctx = new InitialContext();
		ds = (DataSource)jnctx.lookup("jdbc/cloud");
	}
	
	public void doLogin(String username,String password) throws SQLException{
		Connection con = (Connection) ds.getConnection();
		String sql = "select * from admin_list where user_name = '" + username + "' and password = '"
+ password + "'";	
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			this.setId(rs.getInt("id"));
			System.out.println("id:"+id);
			this.setName(rs.getString("user_name"));
			System.out.println("user_name:"+username);
			this.setPassword(rs.getString("password"));
			System.out.println("password:"+password);
		}
		rs.close();
		stmt.close();
		con.close();
		
	}
}
