package project;

/**
 * Class Grader that is a specialized type of user
 */
public class Grader extends User {
    /**
     * Parameters
     */
    private String major;       // major of this Grader
    private String semester;    // semester of this Grader

    /**
     * Initialization
     */
    public Grader(){

    }

    /**
     * Functions
     */

    /**
     * getter function of parameter major
     * @return
     */
    public String getMajor() {
        return major;
    }

    /**
     * setter function of parameter major
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * getter function of parameter semester
     * @return
     */
    public String getSemester() {
        return semester;
    }

    /**
     * setter function of parameter semester
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

}

