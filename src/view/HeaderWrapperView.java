package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class HeaderWrapperView extends JPanel {
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpenFile;
	private JMenuItem mntmOpenLog;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenu mnEdit;
	private JMenu mnAbout;
	private ToolboxView toolboxView;
	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;

	/**
	 * Create the panel.
	 */
	public HeaderWrapperView() {
		setLayout(new BorderLayout(0, 0));

		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmOpenFile = new JMenuItem("Open from file");
		mnFile.add(mntmOpenFile);

		mntmOpenLog = new JMenuItem("Open from log");
		mnFile.add(mntmOpenLog);

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

		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

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
		return mntmOpenFile;
	}

	public JMenuItem getMntmOpenLog() {
		return mntmOpenLog;
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

	public JMenu getMnAbout() {
		return mnAbout;
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

}
