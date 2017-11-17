package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Group 
{
	
	Resource localres;
	
	public Group(Model model, String NS, String UID, String grouplabel, Resource course)
	{
		this.localres	= 	model.createResource(NS+UID)
							.addProperty(TUM.groupWithin, course)
							.addProperty(RDFS.label, grouplabel) //the number of the group
							.addProperty(RDF.type, TUM.Group);
	}
	
	public Resource getResource()
	{
		return this.localres;
	}

}
