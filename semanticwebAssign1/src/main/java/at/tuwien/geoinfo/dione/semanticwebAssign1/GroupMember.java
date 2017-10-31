package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;

public class GroupMember 
{
	Resource instance;
	Model model;
	
	
	public GroupMember(String UID, String firstname, String lastname, String email, String interest, String school, String birthday, String website)
	{
		super();
		
		this.model 	= 	ModelFactory.createDefaultModel();
		
		//create a resource for the group member
		model.setNsPrefix("tui", "http://data.ifs.tuwien.ac.at/study/resource");
		this.instance 	= 	model.createResource("tui:"+UID)
							.addProperty(FOAF.firstName, firstname)
							.addProperty(FOAF.family_name, lastname)
							.addProperty(FOAF.mbox, email)
							.addProperty(FOAF.interest, interest)
							.addProperty(FOAF.schoolHomepage, school)
							.addProperty(FOAF.birthday, birthday)
							.addProperty(FOAF.homepage, website);
				
	}
	
	//write the model to a turtle file
	public void writeTurtlefile(String path, String filename) throws IOException
	{
		FileWriter out = new FileWriter( path+filename );
		this.model.write(out, "Turtle");
		out.close();
	}
	

}
