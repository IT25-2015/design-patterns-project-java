package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import controller.CanvasController;
import controller.InformationPaneController;
import lombok.Getter;
import lombok.Setter;
import view.CanvasView;
import view.InformationPaneView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private @Getter CanvasView canvasView = new CanvasView();
	private @Getter InformationPaneView informationPaneView = new InformationPaneView();
	private @Getter @Setter CanvasController canvasController;
	private @Getter @Setter InformationPaneController informationPaneController;

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

		// InformationPaneView related stuff
		getContentPane().add(informationPaneView, BorderLayout.SOUTH);
		canvasView.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				informationPaneController.handleCursorMovement(e, informationPaneView.getLblCo());
			}
		});
	}

}
