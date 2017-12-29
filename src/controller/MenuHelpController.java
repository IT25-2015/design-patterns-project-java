package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import util.DialogsHelper;

public class MenuHelpController {

	/**
	 * Will show JOptionPane with informations about this project and author
	 */
	public void handleAbout() {
		// TODO Implement this
		DialogsHelper.showInformationMessage("TODO");
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
