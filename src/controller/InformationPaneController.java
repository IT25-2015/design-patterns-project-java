package controller;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class InformationPaneController {

	/**
	 * Will be called on mouse movement, updates JLabel in information pane to match
	 * cursor coordinates
	 * 
	 * @param e
	 * @param coordinatesLabel
	 */
	public void handleCursorMovement(MouseEvent e, JLabel coordinatesLabel) {
		coordinatesLabel.setText(String.format("Cursor at X:%d | Y:%d", e.getX(), e.getY()));
	}
}
