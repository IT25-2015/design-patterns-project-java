package controller;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JLabel;

public class InformationPaneController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1045257280694886628L;

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
