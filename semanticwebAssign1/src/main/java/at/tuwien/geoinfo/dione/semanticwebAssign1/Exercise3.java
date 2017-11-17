package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
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
		
	//create study programes first (at least 5)
		StudyProgram BusinessInformatics 		= new StudyProgram(uni,NS,"066926", "Business Informatics");
		StudyProgram MedizinischeInformatik 	= new StudyProgram(uni,NS,"066936", "Medizinische Informatik");
		StudyProgram TechnInformatik 			= new StudyProgram(uni,NS,"033535", "Bachelorstudium Technische Informatik");
		StudyProgram VisualComputing 			= new StudyProgram(uni,NS,"066932", "Masterstudium Visual Computing");
		StudyProgram PhDGeoIT					= new StudyProgram(uni,NS,"786660", "Dr.-Studium der techn. Wissenschaften Vermessung und Geoinformation");
		
		
	//now create some courses (at least 5)
		
		StudyCourse semweb			= new StudyCourse(uni,NS,"188.399", "Introduction to semantic Web", new Resource[]{BusinessInformatics.getResource(), MedizinischeInformatik.getResource()});
		
		//for BusinessInformatics
		StudyCourse Ecommerce		= new StudyCourse(uni,NS,"188.427", "E-Commerce",new Resource[]{BusinessInformatics.getResource()});
		Ecommerce.isMandatoryIn(BusinessInformatics.getResource());
		
		StudyCourse ITBasedManag	= new StudyCourse(uni,NS,"330.232", "IT-based Management", new Resource[]{BusinessInformatics.getResource(),MedizinischeInformatik.getResource()});
		ITBasedManag.isMandatoryIn(BusinessInformatics.getResource());
		
		StudyCourse	ModelingSim		= new StudyCourse(uni,NS,"101.455", "Modeling and Simulation", new Resource[]{BusinessInformatics.getResource()});
		
		//for GeoIT 
		StudyCourse SeminarDerGeow	= new StudyCourse(uni,NS,"120.025", "Seminar der Geowissenschaften (GeoIT)", new Resource[]{PhDGeoIT.getResource()});
		SeminarDerGeow.isMandatoryIn(PhDGeoIT.getResource());
		
		
		
		
	//create students (at least 5)
		Student marvin	= new Student(uni, NS, "0830619","Marvin", "Mc Cutchan", "marvin.mccutchan@geo.tuwien.ac.at", "GIS" ,"https://www.kth.se/", "10-88","https://www.geo.tuwien.ac.at/staff/marvin-mc-cutchan/");
		marvin.visitsCourse(semweb);
		marvin.visitsCourse(SeminarDerGeow);
		
		
		//fiktive students (we need at least 5 of them)
		Student indy		= new Student(uni,NS, "123456", "Indiana", "Jones", "indian.jones@geo.tuwien.ac.at", "Archeology", "", "07-88", "https://de.wikipedia.org/wiki/Indiana_Jones" );
		indy.visitsCourse(SeminarDerGeow);
		indy.visitsCourse(semweb);
		
		Student dagobert 	= new Student(uni, NS, "123654", "Dagobert", "Duck", "dagobert.duck@geo.tuwien.ac.at", "Money", "", "12-47", "https://de.wikipedia.org/wiki/Dagobert_Duck");
		dagobert.visitsCourse(Ecommerce);
		dagobert.visitsCourse(semweb);
	//Create Groups
		//our group
		Group gr4 		= new Group(uni, NS, "group04_188.399", "04", semweb.getResource());
		
		//fiktive (other) group
		Group gr400 	= new Group(uni, NS, "group400_188.399","400", semweb.getResource());
		
	//Create groupmembers
		//group 04
		GroupMember marv_mem = new GroupMember(uni, NS,"group04_188.399_mccutchan", gr4.getResource(), marvin.getResource());
		// others come here....
		
		//group 400 (fiktive group)
		GroupMember indy_mem 		= new GroupMember(uni, NS,"group400_188.399_indy", gr400.getResource(),indy.getResource());
		GroupMember dagobert_mem 	= new GroupMember(uni, NS,"group400_188.399_dagobert", gr400.getResource(),dagobert.getResource());
		
	//	Teachers...
		//semantic web
		Teacher ElmarKiesling 	= new Teacher(uni, NS,"Elmar", "Kiesling", "ElmarKieslingTUWien");
		ElmarKiesling.teaches(semweb.getResource());
		
		//Ecommerce
		Teacher IvonaBrandic	= new Teacher(uni, NS, "Ivona", "Brandic", "IvonaBrandicTUWien");
		IvonaBrandic.teaches(Ecommerce.getResource());
		
		//IT-based Management
		Teacher WalterSchwaiger = new Teacher(uni, NS, "Walter", "Schwaiger", "WalterSchwaigerTUWien");
		WalterSchwaiger.teaches(ITBasedManag.getResource());
		
		//Modeling and Simulation
		Teacher NikolasPopper 	= new Teacher(uni, NS,"Nikolas", "Popper", "NikolasPopperTUWien");
		NikolasPopper.teaches(ModelingSim.getResource());
		
		//Seminar der Geowissenschaften
		Teacher GerhardNavratil = new Teacher(uni, NS, "Gerhard", "Navratil", "GerhardNavratilTUWien");
		GerhardNavratil.teaches(SeminarDerGeow.getResource());
		
		
		
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
