package project;

/**
 * class to represent a person using the application
 */
public class User {
    /**
     * Parameters
     */
    private String name;    // name of user
    private String email;   // email of user

    /**
     * Initialization
     */
    public User(){

    }

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
     * getter function of parameter email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter function of parameter email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
