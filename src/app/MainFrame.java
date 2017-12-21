package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CanvasController;
import controller.InformationPaneController;
import view.CanvasView;
import view.FooterWrapperView;
import view.InformationPaneView;
import view.LoggerView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private CanvasView canvasView = new CanvasView();
	private FooterWrapperView footerWrapperView = new FooterWrapperView();
	private CanvasController canvasController;
	private InformationPaneController informationPaneController;

	/**
	 * Initialize frame and all its properties
	 */
	public MainFrame(int width, int height) {
		// Frame related stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
		setTitle("Aleksandar Babic IT53/2015 - Dizajn Paterni");

		// CanvasView related stuff
		canvasView.setBackground(Color.WHITE);
		getContentPane().add(canvasView, BorderLayout.CENTER);
		canvasView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				canvasController.handleCanvasClick(e);
			}
		});
		// FooterWrapper and its components related stuff
		getContentPane().add(footerWrapperView, BorderLayout.SOUTH);
		canvasView.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				informationPaneController.handleCursorMovement(e, footerWrapperView.getInformationPaneView().getLblCo());
			}
		});
	}

	public CanvasController getCanvasController() {
		return canvasController;
	}

	public void setCanvasController(CanvasController canvasController) {
		this.canvasController = canvasController;
	}

	public InformationPaneController getInformationPaneController() {
		return informationPaneController;
	}

	public void setInformationPaneController(InformationPaneController informationPaneController) {
		this.informationPaneController = informationPaneController;
	}

	public CanvasView getCanvasView() {
		return canvasView;
	}

}
