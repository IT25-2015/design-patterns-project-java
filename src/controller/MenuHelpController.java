package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import util.DialogsHelper;

@SuppressWarnings("serial")
public class MenuHelpController implements Serializable {

	/**
	 * Will show JOptionPane with informations about this project and author
	 */
	public void handleAbout() {
		String aboutText = "This app is written as final project for subject 'Design Patterns'.\n\n"
				+ "Idea is to create 2D Paint like application that can draw 6 kinds of shapes.\n\n"
				+ "Also, there are additional features like Undo/Redo, Real-Time action logs, \n"
				+ "Import/Export,Log Parsing, Z-Axis operations, all of them are implemented \n"
				+ "using various design patterns.\n"
				+ "Below are some of patterns thare were used for this project : \n"
				+ "Singleton, Command, Strategy, Observer, Adapter.\n\n"
				+ "Application GUI is written using Java Swing, project is structured with MVC pattern.\n\n"
				+ "Source code of this project is on GitHub with MIT licence.\n"
				+ "Go to Help->View Github Repository to take a look at it.";
		DialogsHelper.showInformationMessage(aboutText);
	}

	/**
	 * Will open default browser with URL pointed to Github repository of this
	 * project
	 */
	public void showSrcGithub() {
		String URL = "https://github.com/aleksandar-babic/design-patterns-project-java";
		try {
			Desktop.getDesktop().browse(new URI(URL));
		} catch (IOException e) {
			DialogsHelper.showErrorMessage("Error while opening Github repository");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			DialogsHelper.showErrorMessage("Error while opening Github repository");
			e.printStackTrace();
		}
	}
}
