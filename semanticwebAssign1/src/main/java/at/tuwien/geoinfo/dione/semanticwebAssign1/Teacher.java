package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Teacher 
{
	Resource localres;
	public Teacher(Model model, String NS,String firstname, String lastname, String UID)
	{
		this. localres = 	model.createResource(NS+UID)
							.addProperty(RDF.type, TUM.Teacher)
							.addProperty(FOAF.firstName, firstname)
							.addProperty(FOAF.family_name, lastname)
							.addProperty(RDFS.subClassOf, FOAF.Person);
		
	}
	
	public Resource getResource()
	{
		return this.localres;
	}
	
	//add a course the person teaches
	public void teaches(Resource course)
	{
		this.getResource().addProperty(TUM.teaches, course);
	}
}
