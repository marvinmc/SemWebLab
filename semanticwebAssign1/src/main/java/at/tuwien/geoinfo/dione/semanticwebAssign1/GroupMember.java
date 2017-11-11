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

public class GroupMember
{
	Resource instance;
	
	
	public GroupMember(Model model, String NS, String groupURI, String studentURI, String courseURI)
	{
		//First create a UID- its a combination of the student-URI, the course-URI, and, groupID
		String UID			= studentURI+courseURI+groupURI;
							model.createResource(NS+UID)
							.addProperty(TUM.isMember,groupURI)
							.addProperty(TUM.isStudent, studentURI)
							.addProperty(RDFS.subClassOf, FOAF.Person)
							.addProperty(RDF.type,TUM.GroupMember);			
	}
	
	
	

}
