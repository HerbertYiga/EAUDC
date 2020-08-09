package com.eaudc.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	
	
	
 /**
 * @param args
 */
public static void main(String [] args) {
		
	//testing arrays
	
	Date date=new Date();
	SimpleDateFormat dateformatter =new SimpleDateFormat();
	dateformatter=new SimpleDateFormat(" MMMM d yyyy");
	String dates=dateformatter.format(date);
	System.out.println(dates );

	
	
		
}
	

}
