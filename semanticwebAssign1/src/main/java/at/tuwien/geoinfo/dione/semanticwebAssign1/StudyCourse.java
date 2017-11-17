package at.tuwien.geoinfo.dione.semanticwebAssign1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class StudyCourse 
{
	Resource localres;
	
	public StudyCourse(Model model, String NS, String UID, String label, Resource[] StudyProgramURIs)
	{
		super();
		this.localres = model.createResource(NS+UID)
						.addProperty(RDFS.label, label)
						.addProperty(RDF.type, TUM.StudyCourse);
		
		Resource course = model.getResource(NS+UID);
		
		for(int i = 0;i<StudyProgramURIs.length;i++)
			course.addProperty(TUM.withinStudyProgram, StudyProgramURIs[i]);
	}
	public Resource getResource()
	{
		return this.localres;
	}
	
	//sets in which study programs is mandatory....
	public void isMandatoryIn(Resource studyprogram)
	{
		this.getResource().addProperty(TUM.mandatoryIn, studyprogram);
	}
}
