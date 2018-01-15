package com.kame.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kame.database.DataSource;
import com.kame.domain.*;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
    		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Md5 md = new Md5();
        password = md.MD5(password);
        	DataSource ds= new DataSource();
        	ds.getConnection();
        	String sql = "select * from admin_list where name = ? and password = ?";
    		List<Object> params = new ArrayList<Object>();
    		params.add(username);
    		params.add(password);
    		AdminInfo adminInfo;
    		try {    			
    			adminInfo = ds.findSimpleRefResult(sql, params, AdminInfo.class);
    			System.out.print(adminInfo);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        ds.releaseConn();
       
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
