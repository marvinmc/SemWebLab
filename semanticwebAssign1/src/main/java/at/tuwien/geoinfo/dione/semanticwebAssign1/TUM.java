package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

/**
 * This class defines the vocabulary within TUM
 * @author Thyreal
 *
 */
public class TUM {

	//Namespace of TUM
	static String NS 			= "http://data.ifs.tuwien.ac.at/study.rdf/"; 
	static String NSprefix      = "tum";
	static Model TUModel		= ModelFactory.createDefaultModel();
	
	//CLASSES
	
	
	static Resource Student		= 	(Resource) TUModel.createResource(NS+"Student")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.subClassOf, FOAF.Person)
									.addProperty(RDFS.label, "Student Class");
	
	static Resource Teacher		= 	(Resource) TUModel.createResource(NS+"Teacher")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.subClassOf,FOAF.Person)
									.addProperty(RDFS.label, "Teacher Class");

	static Resource GroupMember	= 	(Resource) TUModel.createResource(NS+"GroupMember")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.subClassOf,Student)
									.addProperty(RDFS.label, "GroupMember Class");
	
	static Resource Group		= 	(Resource) TUModel.createResource(NS+"Group")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.label, "Group Class");
	
	static Resource StudyCourse = 	(Resource) TUModel.createResource(NS+"StudyCourse")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.label, "StudyCourse Class");
	
	static Resource StudyProgram = 	(Resource) TUModel.createResource(NS+"StudyProgram")
									.addProperty(RDF.type, RDFS.Class)
									.addProperty(RDFS.label, "StudyProgram Class");
	
	
	
	//hasCourse Relation: StudyCourse withinStudyProgram StudyProgram. E.g.:  Linear_Algebra withinStudyProgram Technische_Mathematik
	static Property withinStudyProgram 	= 	(Property) TUModel.createProperty(NS, "hasCourse")
											.addProperty(RDFS.range, StudyProgram)
											.addProperty(RDFS.domain, StudyCourse)
											.addProperty(RDF.type, RDF.Property);
	
	//student attends StudyCourse
	static Property attends 	= 	(Property) TUModel.createProperty(NS, "attends") 
									.addProperty(RDFS.domain, Student)
									.addProperty(RDFS.range, StudyCourse)
									.addProperty(RDF.type, RDF.Property);
	//teacher teaches StudyCourse
	static Property teaches		= 	(Property) TUModel.createProperty(NS, "teaches")
									.addProperty(RDFS.domain, Teacher)
									.addProperty(RDFS.range, StudyCourse)
									.addProperty(RDF.type, RDF.Property);
	//GroupMember isMember Group
	static Property isMember	=	(Property) TUModel.createProperty(NS, "isMember")
									.addProperty(RDFS.domain, Group)
									.addProperty(RDFS.range, GroupMember)
									.addProperty(RDF.type, RDF.Property);
	

	
	public TUM()
	{
		super();
	}
	
}
