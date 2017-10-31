package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.IOException;


public class Exercises {

	public static void main(String[] args) 
	{
	
		/*
		 * Exercise I
		 */
		
		//use matrikel# as UID,
		GroupMember marvin = new GroupMember("0830619","Marvin", "Mc Cutchan", "marvin.mccutchan@geo.tuwien.ac.at", "GIS" ,"Royal Institute of Technology (KTH), Stockholm", "10-88","https://www.geo.tuwien.ac.at/staff/marvin-mc-cutchan/");
		try 
		{
			//write to turtle file
			System.out.println("outup");
			marvin.writeTurtlefile("C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/Ex1/", "marvin.ttl");
			
			
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// END EXERCISE I
		
	}

}
