package com.test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TDDDemoDay1 {

	static int counter = 0;
	static String w_initialTimeStr = "01-06-2021 12:00:00";
	static String w_curTimeStr = "01-06-2021 12:00:40";
	
	public static void main(String[] args) throws ParseException 
	{ 
		ArrayList<String> w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		rateLimiter(w_list);
		System.out.println(counter);
		System.out.println(counter <= 20 && counter != 0);
		
		w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		w_list.add("Request3");
		w_list.add("Request4");
		w_list.add("Request5");
		w_list.add("Request6");
		w_list.add("Request7");
		w_list.add("Request8");
		w_list.add("Request9");
		w_list.add("Request10");
		w_list.add("Request11");
		w_list.add("Request12");
		w_list.add("Request13");
		w_list.add("Request14");
		w_list.add("Request15");
		w_list.add("Request16");
		w_list.add("Request17");
		w_list.add("Request18");
		w_list.add("Request19");
		w_list.add("Request20");
		w_list.add("Request21");
		w_list.add("Request22");
		
		rateLimiter(w_list);
		System.out.println(counter);
		System.out.println(counter == 0);
		
		w_curTimeStr = "01-06-2021 12:02:40";
		w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		rateLimiter(w_list);
		
		System.out.println(counter);
		System.out.println(counter == 0);
	}
	 

	@org.junit.Test
	public void testRequestCountLessThanTwenty() throws ParseException {
		w_curTimeStr = "01-06-2021 12:00:40";
		
		ArrayList<String> w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		rateLimiter(w_list);
		
		assertTrue((counter > 0 && counter <= 20));
	}
	
	@org.junit.Test
	public void testRequestCountGreaterThanTwenty() throws ParseException {
		w_curTimeStr = "01-06-2021 12:00:40";
		
		ArrayList<String> w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		w_list.add("Request3");
		w_list.add("Request4");
		w_list.add("Request5");
		w_list.add("Request6");
		w_list.add("Request7");
		w_list.add("Request8");
		w_list.add("Request9");
		w_list.add("Request10");
		w_list.add("Request11");
		w_list.add("Request12");
		w_list.add("Request13");
		w_list.add("Request14");
		w_list.add("Request15");
		w_list.add("Request16");
		w_list.add("Request17");
		w_list.add("Request18");
		w_list.add("Request19");
		w_list.add("Request20");
		w_list.add("Request21");
		w_list.add("Request22");
		rateLimiter(w_list);
		
		assertTrue(counter == 0);
	}
	
	@org.junit.Test
	public void testRequestCountInOneMin() throws ParseException
	{
		w_curTimeStr = "01-06-2021 12:02:40";
		ArrayList<String> w_list =  new ArrayList<String>();
		w_list.add("Request1");
		w_list.add("Request2");
		rateLimiter(w_list);
		
		assertTrue((counter == 0));
	}
	
	public static int rateLimiter(ArrayList<String> a_req) throws ParseException {
		
		Date w_initialTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(w_initialTimeStr);
		Date w_curTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(w_curTimeStr);
		long difference_In_Time = w_curTime.getTime() - w_initialTime.getTime();
		long difference_In_Sec = (difference_In_Time / 1000);
		System.out.println(difference_In_Sec);
		
		if (difference_In_Sec <= 60 && a_req.size() <= 2) {
			counter = a_req.size();
			return counter;
		}
		else {
			counter = 0;
			return counter;
		}
	}
}
