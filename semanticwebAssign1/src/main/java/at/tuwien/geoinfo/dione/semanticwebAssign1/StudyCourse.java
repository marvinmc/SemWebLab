package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class StudyCourse 
{
	public StudyCourse(Model model, String NS, String NSprefix, String UID, String label, String StudyProgram)
	{
		super();
		Resource res = 	model.createResource(NS+UID)
						.addProperty(TUM.withinStudyProgram, StudyProgram)
						.addProperty(RDFS.label, label)
						.addProperty(RDF.type, TUM.StudyCourse);
		
	}
}
