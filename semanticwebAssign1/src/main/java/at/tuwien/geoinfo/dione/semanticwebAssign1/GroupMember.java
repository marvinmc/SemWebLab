package at.tuwien.geoinfo.dione.semanticwebAssign1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class GroupMember extends Student
{
	Resource instance;
	
	
	public GroupMember(Model model, String NS, String NSprefix, String UID, String firstname, String lastname, String email, String interest, String school, String birthday, String website, Integer groupnumber)
	{
		super(model,NS,NSprefix,UID,firstname,lastname,email,interest,school,birthday,website);
							model.getResource(NS+UID)
							.addProperty(TUM.isMember,groupnumber.toString());
							//remove old type (Student)
							model.getResource(NS+UID)
							.getProperty(RDF.type).remove();
							//set new type (GroupMember)
							model.getResource(NS+UID)
							.addProperty(RDF.type, TUM.GroupMember);
				
	}
	
	
	

}
