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

@WebServlet("/EventAdd")
public class EventAdd extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
    		String name = request.getParameter("name");
        String eventdate = request.getParameter("eventdate").toString();
        String info = request.getParameter("info");
        //String userid = "admin";

        	DataSource ds= new DataSource();
        	ds.getConnection();
        	String sql = "insert into event_list (name, eventdate, userid, info) values (?, ?, ?, ?)";
    		List<Object> params = new ArrayList<Object>();
    		params.add(name);
    		params.add(eventdate);
    		params.add(1);
    		params.add(info);
    		try {
    			boolean flag = ds.updateByPreparedStatement(sql, params);
    			System.out.println(flag);
    			if(flag) {
    				PrintWriter out = response.getWriter(); 
    				out.println("Add Successed!");
    				response.sendRedirect("calendar.jsp");
    			}
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}finally {
        ds.releaseConn();}
       
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
