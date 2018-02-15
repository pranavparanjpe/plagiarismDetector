package project;

/**
 * Factory for creating different types of documents
 *
 */
public class DocumentFactory {
	/**
	    * factory method for creating a FileInput
	    */
	   public FileInput createFileInput(){
		   return new FileInput();
	   };
	   
	   /**
	    * factory method for creating a Report
	    */
	   public Report createReport(){
		   return new Report();
	   };
}
