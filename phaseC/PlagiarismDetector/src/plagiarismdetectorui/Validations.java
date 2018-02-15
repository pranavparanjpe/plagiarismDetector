
package plagiarismdetectorui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author team-22
 * This class has some common validation and check functions that will be used in the UI Swing classes
 */
public class Validations {
    
        //Make Saved_Files Directory for saving files if it doesnot exists
       public void createDirectory(){
        //If directory exists just return else create an empty directory
        String basePath = new File("").getAbsolutePath()+File.separator+File.separator+"Saved_Files";
        if(new File(basePath).exists()){
            return;
        }
        else{
            new File(basePath).mkdir();
        }
    } 
       
       //Check if file exists and if it does check if it is a vaild .java file
       public boolean checkFileExistance(String fileName12) {
           String extension = fileName12.substring(fileName12.length()-UIConstants.MIN_RESULT_LENGTH);
           return extension.equals(".java");
	}
       
       //Create a HashMap of File name as key and it's path as value in hashmap
       public HashMap<String,String> getSavedFiles(){
        String basePath = new File("").getAbsolutePath()+File.separator+File.separator+"Saved_Files";
        //Get all files from Saved_Files Directory
            File[] files = new File(basePath).listFiles();
             HashMap<String,String> fileMap=  new HashMap<>();
            for(int i=0; i<files.length; i++){
                
                String name = files[i].getAbsolutePath();
                fileMap.put(name.substring(name.lastIndexOf(File.separator)+1), name);
                
            }
            return fileMap;
            
        }
       //Check if given file is empty or not
       public boolean checkFileSize(File file){ 
           //If it is a file and is empty
           if(!file.isDirectory() && file.length()<=0){
               return true;
           }
           else if(!file.isDirectory()){
               return false;
           }
           //If it is a directory check if there are .java files recursively
           else if(file.isDirectory()) {
               //List files in directory
        	   File[] files = file.listFiles();
                   //If no files in directory
        	  ArrayList<File> fileList =  new ArrayList<>(Arrays.asList(files));
                   if(files.length==0)
        		   return true;
        	   else {
                       //Iterate through all files to find a valid .java file 
                       while(fileList.size()!=0){
                           File f = fileList.remove(0);
                           if(f.isDirectory()){
                               File[] childdir = f.listFiles();
                               ArrayList<File> childList =  new ArrayList<>(Arrays.asList(childdir));
                               fileList.addAll(childList);
                           }
                           else{
                                  String basePath = f.getAbsolutePath();
        			   if(basePath.length()<=UIConstants.MIN_RESULT_LENGTH)
        				   continue;
        			     String extension = basePath.substring(basePath.length()-UIConstants.MIN_RESULT_LENGTH);
                                     if(extension.equals(".java")){
                                         return false;
                                     }
                           }
                       }
        	   }
           }
               return true;
       }
}
