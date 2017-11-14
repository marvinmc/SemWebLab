package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Exercise2 
{
	public static void main(String[] args) 
	{
		try {
		
		Model temp = TUM.TUModel;	
		
		//Set Prefixes
		//tum
		String tumNS 		= "http://data.ifs.tuwien.ac.at/study.rdf/";
		String tumNSprefix  = "tum";
		//FOAF
		String foafNS		= FOAF.NAMESPACE.getNameSpace();
		String foafNSprefix	= "foaf";
		//RDFS
		String rdfsNS 		= RDFS.getURI();
		String rdfsNSPrefix = "rdfs";
		//RDF
		String rdfNS		= RDF.getURI();
		String rdfNSPrefix	= "rdf";
		//set Prefixes
		temp.setNsPrefix(foafNSprefix,foafNS);
		temp.setNsPrefix(rdfsNSPrefix, rdfsNS);
		temp.setNsPrefix(tumNSprefix, tumNS);
		temp.setNsPrefix(rdfNSPrefix, rdfNS);
		FileWriter out = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/2_RDFS-Model/"+"TUM_04.ttl" );
		temp.write(out, "Turtle");
		
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
