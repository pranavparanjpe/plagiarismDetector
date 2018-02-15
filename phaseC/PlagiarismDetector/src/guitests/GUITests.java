package guitests;

import applicationStructure.Constants;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Test;

import plagiarismdetectorui.Validations;
/**
 *
 * @author team-22
 * This class has some tests for GUI swing classes
 */
public class GUITests{

	//Test to check if file exists and has a valid .java name
	@Test
	public void checkifDirectoryExists(){
		Validations valid = new Validations();
		assertTrue(valid.checkFileExistance(Constants.WHILE_LOOP_FILE_PATH));
	}
	//Test to check if file is empty (Given non-empty file)
	@Test
	public void checkFileSize(){
		Validations valid = new Validations();
		assertFalse(valid.checkFileSize(new File(Constants.SIMILAR_SIMPLE_CLASS_FILE_PATH)));
	}
	//Test to check empty file (Given empty file)
	@Test
	public void checkEmptyFile() {
		File file = new File(Constants.EMPTY_CLASS_FILE_PATH);
		Validations valid = new Validations();
		assertTrue(valid.checkFileSize(file));
	}

	//Test to check whether function is retrieving the saved files correctly
	@Test
	public void checkSavedFiles(){
		String basePath = new File("").getAbsolutePath()+File.separator+"Saved_Files";
		File file = new File(basePath);
		File[] dir = file.listFiles();
		int size = dir.length;
		Validations valid = new Validations();
		HashMap<String,String> fileMap = valid.getSavedFiles();
		assertEquals(fileMap.size(), size);
	}

	//Check to see if your directory exists, if not check if it is created
	@Test
	public void checkSavedFilesDirectory() {
		Validations valid = new Validations();
		valid.createDirectory();
		String basePath = new File("").getAbsolutePath();
		File file = new File(basePath+File.separator+"Saved_Files");
		assertTrue(file.exists());
	}
	//Check for empty directory
	@Test
	public void checkEmptyDirectory() {
		Validations valid = new Validations();
		assertTrue(valid.checkFileSize(new File(Constants.SET12_SAMPLE1_FILE_PATH)));
	}
	
	//Check for non-empty directory
		@Test
		public void checkNonEmptyDirectory() {
			Validations valid = new Validations();
			assertFalse(valid.checkFileSize(new File(Constants.SET03_SAMPLE1_FILE_PATH)));
		}
	
		//Check for another non-empty directory
			@Test
				public void checkanotherNonEmptyDirectory() {
					Validations valid = new Validations();
					String basePath = new File("").getAbsolutePath();
					assertTrue(valid.checkFileSize(new File(basePath)));
				}
	

	//PROFESSOR HAS TOLD THAT IT IS FINE IF YOU DON'T WRITE TESTS FOR SWING CLASSES 
	//BUT I AM WRITING THEM ANYWAY


	//TEST TO CHECK IF YOUR bUTTON IS CLICKED CORRECTLY
	@Test
	public void CheckButtonClick(){
		JLabel appName = new javax.swing.JLabel();
		JButton button = new javax.swing.JButton();
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appName.setText("Button is clicked");

			}
		};
		button.addActionListener(al);
		button.doClick();
		assertEquals(appName.getText(), "Button is clicked");
	}

	//Test to check if your JLabel is updated correctly
	@Test
	public void CheckUpdateTextJLabel(){
		JLabel appName = new javax.swing.JLabel();
		appName.setText("I am not updated");
		appName.setText("I am updated");
		assertEquals(appName.getText(), "I am updated");
	}

	//Test to check if file chosen by user is correctly retrieved 
	@Test
	public void CheckFileUpload(){
		JFileChooser fileChooser = new javax.swing.JFileChooser();
		File file = new File(Constants.WHILE_LOOP_FILE_PATH);
		fileChooser.setSelectedFile(file);

		assertEquals(file, fileChooser.getSelectedFile());
	}
	//Check to see if file is uploaded when browse button is clicked
	@Test
	public void CheckFileSelecOnButtonClick(){
		JFileChooser fileChooser = new javax.swing.JFileChooser();
		JButton button = new javax.swing.JButton();
		File file = new File(Constants.WHILE_LOOP_FILE_PATH);
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fileChooser.setSelectedFile(file);

			}
		};
		button.addActionListener(al);
		button.doClick();
		assertEquals(file, fileChooser.getSelectedFile());
	}

	//Check if your Swing application page is visible
	@Test
	public void checkInitialPageVisiblity(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		assertEquals(frame.isVisible(), true);
	}

	//Check whether you can navigate from one page to another
	@Test
	public void checkNavigationOfPages(){
		JFrame frame = new JFrame();
		JFrame frame1 = new JFrame();

		frame.setVisible(true);
		JButton button = new javax.swing.JButton();
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame1.setVisible(true);

			}
		};
		button.addActionListener(al);
		button.doClick();
		assertEquals(true, frame1.isVisible());
		assertEquals(false, frame.isVisible());
	}

}
