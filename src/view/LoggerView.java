package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class LoggerView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoggerView() {
		setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrTLogger = new JTextArea();
		txtrTLogger.setEditable(false);
		txtrTLogger.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		add(txtrTLogger, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		add(scrollBar, BorderLayout.EAST);

	}
}
