package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Student 
{
	Resource localres;
	public Student(Model model, String NS, String UID, String firstname, String lastname, String email, String interest, String school, String birthday, String website)
	{
		super();
		this.localres =		model.createResource(NS+UID)
							.addProperty(FOAF.firstName, firstname)
							.addProperty(FOAF.family_name, lastname)
							.addProperty(FOAF.mbox, email)
							.addProperty(FOAF.interest, interest)
							.addProperty(FOAF.schoolHomepage, school)
							.addProperty(FOAF.birthday, birthday)
							.addProperty(FOAF.homepage, website)
							.addProperty(RDF.type,TUM.Student);
		
	}
	public Resource getResource()
	{
		return this.localres;
	}
	public void visitsCourse(StudyCourse course)
	{
		this.getResource().addProperty(TUM.attends, course.getResource());
	}
}
