package com.kame.database;

import java.io.*;
import java.util.*;
import org.gjt.mm.mysql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.*;
public class RegDataSource {
	public static void main(String[] args) {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL,"/Users/autumnzest/Desktop/code/");
	
	try{
		InitialContext jnctx = new InitialContext(env);
		MysqlDataSource ds = new MysqlDataSource();
		ds.setDatabaseName("jdbc/cloud");
		ds.setUser("root");
		ds.setPassword("autumnzest");
		ds.setServerName("kame.c3efr74wmoir.ap-northeast-1.rds.amazonaws.com");
		ds.setPort(3306);
		jnctx.bind("cloud", ds);
	}catch (Exception e) {
		
	}
}
}
