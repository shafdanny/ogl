package fr.unice.polytech.ogl.islac;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.lang.*;

public class Test {

	
	public String a()
	{
		return "hhhh";
	}
	public String b()
	{
		return this.a();
		
	}

	public static void main(String[] args) 
	   {	  
	      try {
	    	  JSONParser parser=new JSONParser();
		      String s = "{\"creek\":\"creek_id\",\"budget\": 600,\"men\": 50,\"objective\": [ { \"resource\": \"WOOD\", \"amount\": 600 }]}"; 
		      JSONObject obj = (JSONObject)parser.parse(s);
		      System.out.println(obj.get("creek"));
		      System.out.println(obj.get("budget"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	  	Test t1=new Test();
		System.out.println(t1.a());
		System.out.println(t1.b());
	      
	   }
	
	
}

		



	


