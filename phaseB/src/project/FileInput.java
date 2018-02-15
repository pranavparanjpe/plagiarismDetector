package project;
/*
 * Class that represents a specialized type of Document 
 * Input files to be compared for plagiarism test
 */
public class FileInput extends Document{
    /**
     * Parameters
     */
    private Format type;    // type of this input file
    private float size;     // size of this input file

    /**
     * Initialization
     */
    public FileInput(){

    }

    /**
     * Functions
     */

    /**
     * getter function of parameter type
     * @return
     */
    public Format getType() {
        return type;
    }

    /**
     * setter function of parameter type
     * @param type
     */
    public void setType(Format type) {
        this.type = type;
    }

    /**
     * getter function of parameter size
     * @return
     */
    public float getSize() {
        return size;
    }

    /**
     * setter function of parameter size
     * @param size
     */
    public void setSize(float size) {
        this.size = size;
    }
}
