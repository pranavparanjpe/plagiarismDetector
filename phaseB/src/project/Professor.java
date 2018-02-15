package project;

import java.util.*;

/**
 * class of Professor that is a specialized type of  User
 */
public class Professor extends User {
    /**
     * Parameters
     */
    private List<String> subjects;

    /**
     * Initialization
     */
    public Professor(){

    }

    /**
     * Functions
     */

    /**
     * getter function of parameter subjects
     * @return
     */
    public List<String> getSubjects() {
        return subjects;
    }

    /**
     * setter function of parameter subjects
     * @param subjects
     */
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}

