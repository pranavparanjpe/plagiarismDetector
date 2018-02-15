package project;

import java.io.File;
import java.util.*;

/**
 * Class to represent the input files saved for future tests
 */
public class SavedDocs {
    /**
     * Parameters
     */
    private List<FileInput> filesSaved;     // list of saved Documents


    /**
     * Initialization
     */
    public SavedDocs(){

    }
    /**
     * Functions
     */

    /**
     * getter function of parameter fileSaved
     * @return
     */
    public List<FileInput> getFilesSaved() {
        return filesSaved;
    }

    /**
     * setter function of parameter fileSaved
     * @param filesSaved
     */
    public void setFilesSaved(List<FileInput> filesSaved) {
        this.filesSaved = filesSaved;
    }

    /**
     * addition function for list of fileInput
     * @param f
     */
    public void addFile(FileInput f){
        filesSaved.add(f);
    }

    /**
     * deletion function for list of fileInput
     * @param f
     */
    public void deleteFile(FileInput f){
        filesSaved.remove(f);
    }

    /**
     * reset function for list of fileInput
     */
    public void reset(){
        filesSaved.clear();
    }

    /**
     * check if the list of fileInput has fileInput with specific name
     * @param f
     * @return
     */
    public boolean containsFile(FileInput f){
        return filesSaved.contains(f);
    }
}

