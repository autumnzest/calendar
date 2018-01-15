package com.kame.test;

import java.util.*;

import com.kame.admin.EventSelect;
import com.kame.domain.EventInfo;

public class CanlendarFace {
	public String showHtml(String year, String month, String date) {
		int y,m,d;
		GregorianCalendar temp = new GregorianCalendar();
		try {
			y = Integer.parseInt(year);
			m = Integer.parseInt(month);
			d = Integer.parseInt(date);
		}catch(Exception e) {
			y = temp.get(GregorianCalendar.YEAR);
			m = temp.get(GregorianCalendar.MONTH);
			d = temp.get(GregorianCalendar.DAY_OF_MONTH);			
		}
		if(y<1900||y>9999)y=temp.get(GregorianCalendar.YEAR);
		if(m==-1) {
			y--;
			m=11;
		}else if(m==12) {
			y++;
			m=0;
		}else if(m<-1||m>12) {
			m=temp.get(GregorianCalendar.MONTH);
		}
		if(d<1||d>31)d=1;
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(y,m,d);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK)-1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] days = new String[42];
		for(int i = 0;i<42;i++) {
			days[i] = "&nbsp;";
		}
		for(int i=0;i<maxIndex;i++) {
			days[firstIndex + i] = String.valueOf(i + 1);
		}
		String face = "";
        face += "<table id=\"t1\" width=\"91%\" border=\"1\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" bordercolordark=\"#94CCF6\" bordercolorlight=\"#fefefe\">";
        face += "<tr>";
        face += "<td height=\"35\" colspan=\"7\" align=\"center\" bgcolor=\"#CAE8FF\">";
        face += "<a href=\"calendar.jsp?year="+(y-1)+"&month="+m+"&date=1\">上年</a>&nbsp;";
        face += "<a href=\"calendar.jsp?year="+y+"&month="+(m-1)+"&date=1\">上月</a>";
        face += "<strong class=\"STYLE4\">　" + y + " 年 " + (m +1) + "  月 </strong>";//"+d +" 日
        face += "<a href=\"calendar.jsp?year="+y+"&month="+(m+1)+"&date=1\">下月</a>&nbsp;";
        face += "<a href=\"calendar.jsp?year="+(y+1)+"&month="+m+"&date=1\">下年</a>";
        face += "</td></tr>";
        face += "<tr>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\"><span class=\"STYLE3\">日</span></td>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\">一</td>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\">二</td>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\">三</td>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\">四</td>";
        face += "<td width=\"14%\" align=\"center\" bgcolor=\"#C8E1FA\">五</td>";
        face += "<td align=\"center\" bgcolor=\"#C8E1FA\"><span class=\"STYLE3\">六</span></td>";
        face += "</tr>";
        
  	  	EventSelect eventselect = new EventSelect();
  	  	Map<String, String> event = eventselect.getEventList(y+"-"+(m+1));  	  	
        
        for (int j = 0; j < 6; j++) {
            face += "<tr id=\"line"+ j +"\">";
            String status = "status=yes,scrollbars=yes,resizable=yes,width=640,height=480";
            for (int i = j * 7; i < (j + 1) * 7; i++) {
              if (i==35 && days[i].equals("&nbsp;")){
                   face += "<script>line5.style.display=\"none\"</script>";//"<td>&nbsp;</td>";
                   break;
              }
              if (days[i].equalsIgnoreCase(String.valueOf(temp.get(GregorianCalendar.DAY_OF_MONTH)))&& y == temp.get(GregorianCalendar.YEAR) && m == temp.get(GregorianCalendar.MONTH)){
                       face += "<td bgcolor=\"#E7FEE8\" height=\"50\" align=\"center\" <span class=\"STYLE10\">";
              }else if ((i%7)==0 || ((i+1)%7)==0){
            	  	//System.out.println(i);
                   face += "<td height=\"50\" align=\"center\" <span class=\"STYLE6\">";
              }else{
                   face += "<td height=\"50\" align=\"center\" <span class=\"STYLE7\">";
              }
              if(days[i]=="&nbsp;") {
            	  face +=  days[i] +"</span>";              
              }else if(event.get(days[i])==null) {
            	  face +=  "<a href=\"EventAdd.jsp?year="+y+"&month="+ (m +1) +"&date="+days[i]+"\">" + days[i] +"</a></span>";
              }else {
            		  face +=  "<a href=\"EventEdit.jsp?year="+y+"&month="+ (m +1) +"&date="+days[i]+"\">" +event.get(days[i])+"</a></span>";
            		}            
              
                face += "</td>";
            }
            face += "</tr>";
        }
        face += "</table>";
        return face;
		
	}
}
