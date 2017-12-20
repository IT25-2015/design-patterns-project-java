package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import lombok.Getter;
import view.DrawingView;

public class MainFrame extends JFrame {

	private @Getter DrawingView drawingView;

	/**
	 * Initialize frame and all its properties
	 */
	public MainFrame(int width, int height) {
		// Frame related stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);

		// DrawingView related stuff
		drawingView.setBackground(Color.WHITE);
		getContentPane().add(drawingView, BorderLayout.CENTER);
		drawingView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked!");
			}
		});
	}

}
