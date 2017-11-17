package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
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
		
		//for another student
		Model model2 	= 	ModelFactory.createDefaultModel();
		model2.setNsPrefix(NSPrefix, NS);
		model2.setNsPrefix(foafNSprefix,foafNS);
		model2.setNsPrefix(rdfsNSPrefix, rdfsNS);
		model2.setNsPrefix(tumNSprefix, tumNS);
		
		//for the third student
		Model model3 	= 	ModelFactory.createDefaultModel();
		model3.setNsPrefix(NSPrefix, NS);
		model3.setNsPrefix(foafNSprefix,foafNS);
		model3.setNsPrefix(rdfsNSPrefix, rdfsNS);
		model3.setNsPrefix(tumNSprefix, tumNS);
		
		//use matrikel# as UID,
		Student marvin 	= new Student(model, NS,"0830619","Marvin", "Mc Cutchan", "marvin.mccutchan@geo.tuwien.ac.at", "GIS" ,"https://www.kth.se/", "10-88","https://www.geo.tuwien.ac.at/staff/marvin-mc-cutchan/");
		Student xheneta = new Student(model2, NS,"01527976","Xheneta", "Bilalli Shkodra", "xhenetabilalli@gmail.com", "Web Scraping" ,"Technische Universität Wien", "02-93","https://www.ait.ac.at/ueber-das-ait/researcher-profiles/?tx_aitprofile_pi1%5Bname%5D=Bilalli-Shkodra-Xheneta");
		Student rilind 	= new Student(model3, NS,"01527985","Rilind", "Shkodra", "rilindshkodra2@gmail.com", "Web development" ,"Technische Universität Wien", "06-93","https://tuwel.tuwien.ac.at/user/profile.php?id=84445");

		
		//Student indy		= new Student(model2,NS, "123456", "Indiana", "Jones", "indian.jones@geo.tuwien.ac.at", "Archeology", "", "07-88", "https://de.wikipedia.org/wiki/Indiana_Jones" );
		marvin.knowsStudent(xheneta);
		marvin.knowsStudent(rilind);
		
		xheneta.knowsStudent(rilind);
		xheneta.knowsStudent(marvin);
		
		rilind.knowsStudent(marvin);
		rilind.knowsStudent(xheneta);
		
		
		//marvin.knowsStudent(indy);
		//indy.knowsStudent(marvin);
		try 
		{
			//write to turtle file
			System.out.println("outup");
			FileWriter out = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/1_FOAF/"+"Foaf_04_mccutchan.ttl" );
			model.write(out, "Turtle");
			out.close();
			
			FileWriter out2 = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/1_FOAF/"+"Foaf_04_BilalliShkodra.ttl" );
			model2.write(out2, "Turtle");
			out2.close();
			
			FileWriter out3 = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/1_FOAF/"+"Foaf_04_Shkodra.ttl" );
			model3.write(out3, "Turtle");
			out3.close();

		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// END EXERCISE I
		
	}

}
