package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Teacher 
{
	public Teacher(Model model, String NS,String firstname, String lastname, String UID ,String[] courseURIs)
	{
		model.createResource(NS+UID)
		.addProperty(RDF.type, TUM.Teacher)
		.addProperty(FOAF.firstName, firstname)
		.addProperty(FOAF.family_name, lastname)
		.addProperty(RDFS.subClassOf, FOAF.Person);
		//now add courses
		Resource teacher = model.getResource(NS+UID);
		
		//add each course one by one
		for(int i = 0; i<courseURIs.length;i++)
		{
			teacher.addProperty(TUM.teaches, courseURIs[i]);
		}
		
		
	}
}
