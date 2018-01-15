package com.kame.admin;

import java.io.IOException;
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

@WebServlet("/UserSelect")
public class UserSelect extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
    		String keyword = request.getParameter("keyword");
        	DataSource ds= new DataSource();
        	ds.getConnection();
        	String sql = "select * from user_list where name like %?%";
    		List<Object> params = new ArrayList<Object>();
    		params.add(keyword);
    		UserInfo userInfo;
    		try {
    			List userlist;
    			userlist = ds.findMoreRefResult(sql, params, UserInfo.class);
    			System.out.print(userlist);
    		} catch (Exception e) {
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
