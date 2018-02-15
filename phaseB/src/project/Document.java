package project;
import javax.print.Doc;
import java.security.Timestamp;
/*
 * Class that represents a Document
 *  Can be an input file on which plagiarism test needs to be run OR
 *  An output Report with plagiarism test results
 */
public class Document {
    /**
     * Parameters
     */
    private String name;        // name of this document
    private Timestamp timeUsed; // used time of this document

    /**
     * Functions
     */

    /**
     * getter function of parameter name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter function of parameter name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter function of parameter timeUsed
     * @return
     */
    public Timestamp getTimeUsed() {
        return timeUsed;
    }

    /**
     * setter function of parameter timeUsed
     * @param timeUsed
     */
    public void setTimeUsed(Timestamp timeUsed) {
        this.timeUsed = timeUsed;
    }
}

