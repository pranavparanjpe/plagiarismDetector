package project;

/**
 * Factory for creating different operations
 *
 */
public class OperationsFactory {
  
   /**
    * factory method for creating a compare operation
    */
   public CompareOp createCompareOp(FileInput f1, FileInput f2){
	   return new CompareOp(f1,f2);
   };
   
   /**
    * factory method for creating a Selection operation
    */
   public SelectionOp createSelectionOp(){
	   return new SelectionOp();
   };
   
   /**
    * factory method for creating a Upload operation
    */
   public Upload createUploadOp(FileInput[] files){
	   return new Upload(files);
   };
   
   /**
    * factory method for creating a 'ChooseExisting' operation
    */
   public ChooseExisting createChooseExistingOp(FileInput file){
	   return new ChooseExisting(file);
   };
   
   /**
    * factory method for creating a Download operation
    */
   public DownloadOp createDownloadOp(Report result){
	   return new DownloadOp(result);
   };
   
   /**
    * factory method for creating a Save operation
    */
   public SaveOp createSaveOp(FileInput file){
	   return new SaveOp(file);
   };
   
   /**
    * factory method for creating a View operation
    */
   public ViewOp createViewOp(Report result){
	   return new ViewOp(result);
   };
   
}
