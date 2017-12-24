package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import controller.CanvasController;
import controller.InformationPaneController;
import controller.MenuFileController;
import controller.ToolboxController;
import view.CanvasView;
import view.FooterWrapperView;
import view.HeaderWrapperView;
import view.InformationPaneView;
import view.LoggerView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private HeaderWrapperView headerWrapperView = new HeaderWrapperView();
	private CanvasView canvasView = new CanvasView();
	private FooterWrapperView footerWrapperView = new FooterWrapperView(new LoggerView(), new InformationPaneView());

	private ToolboxController toolboxController;
	private CanvasController canvasController;
	private InformationPaneController informationPaneController;
	private MenuFileController mfController;

	/**
	 * Initialize frame and all its properties
	 */
	public MainFrame(int width, int height) {
		// Frame related stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
		setTitle("Aleksandar Babic IT53/2015 - Dizajn Paterni");

		// HeaderWrapper and its components related stuff
		getContentPane().add(headerWrapperView, BorderLayout.NORTH);
		// HeaderWrapper - Main Menu
		headerWrapperView.getMntmUndo().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleUndoBtn();
			}
		});
		headerWrapperView.getMntmRedo().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleRedoBtn();
			}
		});
		headerWrapperView.getMntmExportFile().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mfController.handleExportToFile();
			}
		});
		headerWrapperView.getMntmExportLog().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mfController.handleExportToLog();
			}
		});
		headerWrapperView.getMntmImportLog().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mfController.handleImportFromLog();
			}
		});
		headerWrapperView.getMntmImportFile().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mfController.handleImportFromFile();
			}
		});

		// HeaderWrapper - Toolbox
		headerWrapperView.getToolboxView().getBtnUndo().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleUndoBtn();
			}
		});
		headerWrapperView.getToolboxView().getBtnRedo().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleRedoBtn();
			}
		});

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
				informationPaneController.handleCursorMovement(e,
						footerWrapperView.getInformationPaneView().getLblCo());
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

	public FooterWrapperView getFooterWrapperView() {
		return footerWrapperView;
	}

	public void setToolboxController(ToolboxController toolboxController) {
		this.toolboxController = toolboxController;
	}

	public ToolboxController getToolboxController() {
		return toolboxController;
	}

	public void setMfController(MenuFileController mfController) {
		this.mfController = mfController;
	}

}
