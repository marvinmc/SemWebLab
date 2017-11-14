package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDFS;


public class Exercises {

	public static void main(String[] args) 
	{
	
		/*
		 * Exercise I
		 */
		//Namespace and its prefix
		//tui
		String NS 			= "http://data.ifs.tuwien.ac.at/study/resource/";
		String NSPrefix 	= "tui";
		//tum
		String tumNS 		= "http://data.ifs.tuwien.ac.at/study.rdf/";
		String tumNSprefix  = "tum";
		//FOAF
		String foafNS		= FOAF.NAMESPACE.getNameSpace();
		String foafNSprefix	= "foaf";
		//RDFS
		String rdfsNS 		= RDFS.getURI();
		String rdfsNSPrefix = "rdfs";
		//Create model first
		Model model 	= 	ModelFactory.createDefaultModel();
		model.setNsPrefix(NSPrefix, NS);
		model.setNsPrefix(foafNSprefix,foafNS);
		model.setNsPrefix(rdfsNSPrefix, rdfsNS);
		model.setNsPrefix(tumNSprefix, tumNS);
		
		//use matrikel# as UID,
		Student marvin = new Student(model, NS,"0830619","Marvin", "Mc Cutchan", "marvin.mccutchan@geo.tuwien.ac.at", "GIS" ,"https://www.kth.se/", "10-88","https://www.geo.tuwien.ac.at/staff/marvin-mc-cutchan/");
		try 
		{
			//write to turtle file
			System.out.println("outup");
			FileWriter out = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/1_FOAF/"+"Foaf_04_mccutchan.ttl" );
			model.write(out, "Turtle");
			out.close();
			
			
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// END EXERCISE I
		
	}

}
