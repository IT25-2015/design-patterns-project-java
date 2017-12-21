package view;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class LoggerView extends JPanel {
	private JScrollPane scrollPane;
	private JTextArea txtrTLogger;
	private JList lstLogger;
	private DefaultListModel<String> dlm;

	/**
	 * Create the panel.
	 */
	public LoggerView() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		lstLogger = new JList();
		scrollPane.setViewportView(lstLogger);
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
		if (dlm != null) {
			lstLogger.setModel(dlm);
		}
	}
}
