
package plagiarismdetectorui;

/**
 *
 * @author team-22
 * This class has all constant String fields that will be used in all the Swing classes
 */

public class UIConstants {
    //Plagiarism threshhold value
    public static final double PLAGIARISM_THRESHOLD = 55.0;
    //Message for user when files are plagiarised
    public static final String TEXT_FILES_PLAGIARISED="Files are Plagarised. Report to OSCCR";
    //Message for user when files are not plagiarised
    public static final String TEXT_FILES_NOT_PLAGIARISED="Files are not Plagarised";
    ////Message for user when he tries to save a file at a destination where file file whith that name already exists
    public static final String SAME_FILENAME_EXISTS="File with same name already exists. Please rename";
    
    public static final int MIN_RESULT_LENGTH= 5;
    //Message for user when he upload invalid input file 1
    public static final String INVAILD_FILE1_MESSAGE = "Please select a valid .java file or a directory in the first input box";
    //Message for user when he uploads invalid input file 2
     public static final String INVAILD_FILE2_MESSAGE = "Please select a valid .java file or a directory in the second input box";
     //Message for user when there are no saved files
     public static final String NO_SAVED_FILES_MESSAGE = "You have no previously saved files";
     //Message for user when he uploads an empty file
     public static final String EMPTY_FILES_MESSAGE = "The selected file is empty, Or selected directory has no .java files. Please choose another file or directory";
     //Message for user when he renames saved file with invalid name
     public static final String INVALID_RENAME_MESSAGE="Please rename the file as a valid .java file";
}
