package com.kame.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kame.database.DataSource;
import com.kame.domain.EventInfo;

public class EventSelect {
	public Map<String, String> getEventList(String datetime){
	    	String startdate = datetime+"-1";
	    	String enddate = datetime+"-31";
		DataSource ds= new DataSource();
	    	ds.getConnection();
	    	String sql = "select id,eventdate,name from event_list where eventdate between ? and ?";
		List<Object> params = new ArrayList<Object>();
		params.add(startdate);
		params.add(enddate);
//		System.out.println(datetime);
//		params.add(datetime);
		List<Map<String, Object>> eventlist = null;
		Map<String, String> eventmap = new HashMap<String, String>();
		try {
			eventlist = ds.findModeResult(sql, params);
		  	for (Map<String, Object> map : eventlist)
		      {
		  		String newdate = map.get("eventdate").toString().substring(8, 10);
		  		String newdate2 = Integer.parseInt(newdate)+"";
		  		String infoname = map.get("name").toString();
		  		eventmap.put(newdate2, infoname);
		      }		      					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
    ds.releaseConn();}
		return eventmap;
	}
	
	public List getSingleEventList(String datetime){
	DataSource ds= new DataSource();
    	ds.getConnection();
    	String sql = "select * from event_list where eventdate = ?";
	List<Object> params = new ArrayList<Object>();
//	System.out.println(datetime);
	params.add(datetime);
	EventInfo eventinfo = null;
	List<String> eventlist = new ArrayList<String>();
	try {
		eventinfo = ds.findSimpleRefResult(sql, params, EventInfo.class);	
		eventlist.add(eventinfo.getName());
		eventlist.add(eventinfo.getInfo());
		eventlist.add(eventinfo.getId()+"");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		ds.releaseConn();}

	return eventlist;
}
}
