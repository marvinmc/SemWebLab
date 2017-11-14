package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDFS;

public class Exercise3 {

	public static void main(String[] args) 
	{
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
		Model uni 	= 	ModelFactory.createDefaultModel();
		uni.setNsPrefix(NSPrefix, NS);
		uni.setNsPrefix(foafNSprefix,foafNS);
		uni.setNsPrefix(rdfsNSPrefix, rdfsNS);
		uni.setNsPrefix(tumNSprefix, tumNS);
		
		//create study programes first
		StudyProgram BusinessInformatics 		= new StudyProgram(uni,NS,"066926", "Business Informatics");
		StudyProgram MedizinischeInformatik 	= new StudyProgram(uni,NS,"066936", "Medizinische Informatik");
		StudyProgram TechnInformatik 			= new StudyProgram(uni,NS,"033535", "Bachelorstudium Technische Informatik");
		StudyProgram VisualComputing 			= new StudyProgram(uni,NS,"066932", "Masterstudium Visual Computing");
		StudyProgram PhDGeoIT					= new StudyProgram(uni,NS,"786660", "Dr.-Studium der techn. Wissenschaften Vermessung und Geoinformation");
		
		
		//now create some courses
		
		StudyCourse semweb			= new StudyCourse(uni,NS,"188.399", "Introduction to semantic Web", new String[]{BusinessInformatics.getResource().getURI(), MedizinischeInformatik.getResource().getURI()});
		StudyCourse Ecommerce		= new StudyCourse(uni,NS,"188.427", "E-Commerce",new String[]{BusinessInformatics.getResource().getURI()});
		StudyCourse ITBasedManag	= new StudyCourse(uni,NS,"330.232", "IT-based Management", new String[]{BusinessInformatics.getResource().getURI(),MedizinischeInformatik.getResource().getURI()});
		StudyCourse	ModelingSim		= new StudyCourse(uni,NS,"101.455", "Modeling and Simulation", new String[]{BusinessInformatics.getResource().getURI()});
		StudyCourse SeminarDerGeow	= new StudyCourse(uni,NS,"120.025", "Seminar der Geowissenschaften (GeoIT)", new String[]{PhDGeoIT.getResource().getURI()});
		
		//create students
		Student marvin	= new Student(uni, NS, "0830619","Marvin", "Mc Cutchan", "marvin.mccutchan@geo.tuwien.ac.at", "GIS" ,"https://www.kth.se/", "10-88","https://www.geo.tuwien.ac.at/staff/marvin-mc-cutchan/");
		marvin.visitsCourse(semweb);
		marvin.visitsCourse(SeminarDerGeow);
		
		
		

		
		//write to turtle file
		System.out.println("write out file");
		FileWriter out;
		try 
		{
			
		out = new FileWriter( "C:/EigeneUebungen/EinfuehrungSemWeb/Assignment1/3_RDFS-Instances/"+"RDFS_Model_04.ttl" );
		
		uni.write(out, "Turtle");
		out.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//... other students
		System.out.println("finished");
	}

}
