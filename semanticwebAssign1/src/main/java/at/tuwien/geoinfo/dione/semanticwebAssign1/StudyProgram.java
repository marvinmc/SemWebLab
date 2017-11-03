package at.tuwien.geoinfo.dione.semanticwebAssign1;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class StudyProgram 
{

		public StudyProgram(Model model, String NS, String NSprefix, String UID, String label)
		{
			super();
			Resource res= 	model.createResource(NS+UID)
							.addProperty(RDFS.label,label)
							.addProperty(RDF.type, RDFS.Class);
			
			
		}
}
