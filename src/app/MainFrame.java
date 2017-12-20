package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import controller.CanvasController;
import lombok.Getter;
import lombok.Setter;
import view.CanvasView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private @Getter CanvasView canvasView = new CanvasView();
	private @Getter @Setter CanvasController canvasController;

	/**
	 * Initialize frame and all its properties
	 */
	public MainFrame(int width, int height) {
		// Frame related stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);

		// DrawingView related stuff
		canvasView.setBackground(Color.WHITE);
		getContentPane().add(canvasView, BorderLayout.CENTER);
		canvasView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				canvasController.handleCanvasClick(e);
			}
		});
	}

}
