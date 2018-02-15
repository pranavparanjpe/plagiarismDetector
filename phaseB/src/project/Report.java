package project;
/*
 * Class that represents a specialized type of Document 
 * Consists details about the plagiarism test
 */

public class Report extends Document {
    /**
     * Parameters
     */
    private float similarityPercentage;     // percent of similarity between two files
    private int numLinesCopied;             // number of lines that might be copied
    private String similarCodeSnippet;      // snippet of similar code

    /**
     * Initialization
     */
    public Report(){

    }

    /**
     * Functions
     */

    /**
     * getter function of parameter similarityPercentage
     * @return
     */
    public float getSimilarityPercentage() {
        return similarityPercentage;
    }

    /**
     * setter function of parameter similarityPercentage
     * @param similarityPercentage
     */
    public void setSimilarityPercentage(float similarityPercentage) {
        this.similarityPercentage = similarityPercentage;
    }

    /**
     * getter function of parameter numberLinesCopied
     * @return
     */
    public int getNumLinesCopied() {
        return numLinesCopied;
    }

    /**
     * setter function of parameter numberLinesCopied
     * @param numLinesCopied
     */
    public void setNumLinesCopied(int numLinesCopied) {
        this.numLinesCopied = numLinesCopied;
    }

    /**
     * getter function of parameter similarCodeSnipper
     * @return
     */
    public String getSimilarCodeSnipper() {
        return similarCodeSnippet;
    }

    /**
     * setter function of parameter similarCodeSnipper
     * @param similarCodeSnipper
     */
    public void setSimilarCodeSnipper(String similarCodeSnippet) {
        this.similarCodeSnippet = similarCodeSnippet;
    }

}

