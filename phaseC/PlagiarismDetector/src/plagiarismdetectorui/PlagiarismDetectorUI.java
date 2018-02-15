package plagiarismdetectorui;

/**
 *
 * @author team-22
 * Main class which invokes the index page of UI
 */
public class PlagiarismDetectorUI {

    public static void main(String[] args) {
        /* Create and display the form */
    	//Main method to call the Homepage of our application
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }
    
}
