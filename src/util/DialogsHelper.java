package util;

import javax.swing.JOptionPane;

public class DialogsHelper {
	/**
	 * Will open JOptionPane with ERROR_MESSAGE icon and given string as error
	 * message
	 * 
	 * @param message
	 */
	public static void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Will open JOptionPane with INFORMATION_MESSAGE icon and given string as
	 * message
	 * 
	 * @param message
	 */
	public static void showInformationMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Will open JOptionPane with PLAIN_MESSAGE icon and given string as message
	 * 
	 * @param message
	 */
	public static void showPlainsMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Will show JOptionPane confirm dialog, returns boolean based on user answer
	 * 
	 * @param question
	 * @return
	 */
	public static boolean askUserToConfirm(String question) {
		int response = JOptionPane.showConfirmDialog(null, question, "Confirm action", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		switch (response) {
		case JOptionPane.NO_OPTION:
			return false;
		case JOptionPane.YES_OPTION:
			return true;
		case JOptionPane.CLOSED_OPTION:
			return false;
		default:
			return false;
		}

	}
	
	/**
	 * Will show JOptionPane asking user to input value, returns user's input
	 * @param message
	 * @param title
	 * @param icon
	 * @return
	 */
	public static String getUserInput(String message, String title, int icon) {
		return JOptionPane.showInputDialog(null, message, title, icon);
	}

}
