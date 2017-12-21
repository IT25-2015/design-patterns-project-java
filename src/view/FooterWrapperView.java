package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class FooterWrapperView extends JPanel {
	LoggerView loggerView = new LoggerView();
	InformationPaneView informationPaneView = new InformationPaneView();
	/**
	 * Create the panel.
	 */
	public FooterWrapperView() {
		setLayout(new BorderLayout(0, 0));
		
		add(loggerView, BorderLayout.CENTER);
		
		add(informationPaneView, BorderLayout.SOUTH);
		
		JLabel lblHeader = new JLabel("Live action log");
		add(lblHeader, BorderLayout.NORTH);

	}
	public LoggerView getLoggerView() {
		return loggerView;
	}
	public InformationPaneView getInformationPaneView() {
		return informationPaneView;
	}

}
