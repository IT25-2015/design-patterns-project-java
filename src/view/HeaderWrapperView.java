package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class HeaderWrapperView extends JPanel {
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmImportFile;
	private JMenuItem mntmImportLog;
	private JMenuItem mntmExportFile;
	private JMenuItem mntmExportLog;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private ToolboxView toolboxView;
	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;
	private JMenuItem mntmViewCode;
	private JMenuItem mntmAbout;

	/**
	 * Create the panel.
	 */
	public HeaderWrapperView() {
		setLayout(new BorderLayout(0, 0));

		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmImportFile = new JMenuItem("Import from file");
		mnFile.add(mntmImportFile);

		mntmImportLog = new JMenuItem("Import from log file");
		mnFile.add(mntmImportLog);
		
		mntmExportFile = new JMenuItem("Export to file");
		mnFile.add(mntmExportFile);

		mntmExportLog = new JMenuItem("Export to log file");
		mnFile.add(mntmExportLog);

		separator = new JSeparator();
		mnFile.add(separator);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmUndo = new JMenuItem("Undo action");
		mnEdit.add(mntmUndo);

		mntmRedo = new JMenuItem("Redo action");
		mnEdit.add(mntmRedo);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmViewCode = new JMenuItem("View GitHub repository");
		mnHelp.add(mntmViewCode);

		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);

		toolboxView = new ToolboxView();
		add(toolboxView, BorderLayout.CENTER);

	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getMnFile() {
		return mnFile;
	}

	public JMenuItem getMntmOpenFile() {
		return mntmImportFile;
	}

	public JMenuItem getMntmOpenLog() {
		return mntmImportLog;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JMenu getMnEdit() {
		return mnEdit;
	}

	public JMenu getMnHelp() {
		return mnHelp;
	}

	public ToolboxView getToolboxView() {
		return toolboxView;
	}

	public JMenuItem getMntmUndo() {
		return mntmUndo;
	}

	public JMenuItem getMntmRedo() {
		return mntmRedo;
	}

	public JMenuItem getMntmImportFile() {
		return mntmImportFile;
	}

	public JMenuItem getMntmImportLog() {
		return mntmImportLog;
	}

	public JMenuItem getMntmExportFile() {
		return mntmExportFile;
	}

	public JMenuItem getMntmExportLog() {
		return mntmExportLog;
	}

	public JMenuItem getMntmViewCode() {
		return mntmViewCode;
	}

	public JMenuItem getMntmAbout() {
		return mntmAbout;
	}

}