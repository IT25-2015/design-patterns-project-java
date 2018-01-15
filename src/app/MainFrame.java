package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import controller.AdditionalActionsController;
import controller.CanvasController;
import controller.InformationPaneController;
import controller.MenuFileController;
import controller.MenuHelpController;
import controller.ToolboxController;
import view.AdditionalActionsView;
import view.CanvasView;
import view.FooterWrapperView;
import view.HeaderWrapperView;
import view.InformationPaneView;
import view.LoggerView;
import view.ShapePickerView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private HeaderWrapperView headerWrapperView = new HeaderWrapperView();
	private CanvasView canvasView = new CanvasView();
	private FooterWrapperView footerWrapperView = new FooterWrapperView(new LoggerView(), new InformationPaneView());
	private ShapePickerView shapePickerView = new ShapePickerView();
	private AdditionalActionsView additionalActionsView = new AdditionalActionsView();

	private ToolboxController toolboxController;
	private CanvasController canvasController;
	private InformationPaneController informationPaneController;
	private AdditionalActionsController additionalActionsController;
	private MenuFileController mfController;
	private MenuHelpController mhController;

	/**
	 * Initialize frame and all its properties
	 */
	public MainFrame(int width, int height) {
		// Frame related stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		// Calculate center of screen and set frame there
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
		setTitle("Aleksandar Babic IT53/2015 - Design Patterns Project");

		// HeaderWrapper and its components related stuff
		getContentPane().add(headerWrapperView, BorderLayout.NORTH);

		headerWrapperView.getMntmUndo().setAction(new AbstractAction("Undo") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toolboxController.handleUndoBtn();
			}
		});
		headerWrapperView.getMntmUndo()
				.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+Z
		headerWrapperView.getMntmRedo().setAction(new AbstractAction("Redo") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toolboxController.handleRedoBtn();
			}
		});
		headerWrapperView.getMntmRedo()
				.setAccelerator(KeyStroke.getKeyStroke('Y', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+Y
		headerWrapperView.getMntmParseNext().setAction(new AbstractAction("Parse next log line") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.parseNextLogLine();
			}
		});
		headerWrapperView.getMntmParseNext()
				.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+P
		headerWrapperView.getMntmParseNext().setEnabled(false);

		headerWrapperView.getMntmNew().setAction(new AbstractAction("New drawing") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.writeNewDrawing();
			}
		});
		headerWrapperView.getMntmNew()
				.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+N

		headerWrapperView.getMntmExportFile().setAction(new AbstractAction("Export to drawing file") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.handleExportToFile();
			}
		});
		headerWrapperView.getMntmExportFile()
				.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+S

		headerWrapperView.getMntmExportLog().setAction(new AbstractAction("Export to log file") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.handleExportToLog();
			}
		});
		headerWrapperView.getMntmExportLog()
				.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK)); // Ctrl+Shift+S

		headerWrapperView.getMntmImportLog().setAction(new AbstractAction("Import from log file") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.handleImportFromLog();
			}
		});
		headerWrapperView.getMntmImportLog()
				.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK)); // Ctrl+Shift+O

		headerWrapperView.getMntmImportFile().setAction(new AbstractAction("Import from drawing file") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.handleImportFromFile();
			}
		});
		headerWrapperView.getMntmImportFile()
				.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+O

		headerWrapperView.getMntmExit().setAction(new AbstractAction("Quit app") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mfController.exitApp(0);
			}
		});
		headerWrapperView.getMntmExit()
				.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl+Q

		// HeaderWrapper - Help menu
		headerWrapperView.getMntmAbout().setAction(new AbstractAction("About") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mhController.handleAbout();
			}
		});
		headerWrapperView.getMntmAbout().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0)); // F1
		headerWrapperView.getMntmViewCode().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mhController.showSrcGithub();
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
		headerWrapperView.getToolboxView().getTglBtnSelect().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				toolboxController.handleSelectBtnStateChange(ev);
			}
		});
		headerWrapperView.getToolboxView().getBtnModify().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleModify();
			}
		});
		headerWrapperView.getToolboxView().getBtnDelete().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleDelete();
			}
		});
		headerWrapperView.getToolboxView().getBtnInnerColor().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleColorButtonClick(headerWrapperView.getToolboxView().getBtnInnerColor());
			}
		});
		headerWrapperView.getToolboxView().getBtnOuterColor().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				toolboxController.handleColorButtonClick(headerWrapperView.getToolboxView().getBtnOuterColor());
			}
		});

		// CanvasView related stuff
		canvasView.setBackground(Color.WHITE);
		getContentPane().add(canvasView, BorderLayout.CENTER);
		canvasView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!headerWrapperView.getToolboxView().getTglBtnSelect().isSelected()) {
					canvasController.handleCanvasClick(e,
							headerWrapperView.getToolboxView().getBtnInnerColor().getBackground(),
							headerWrapperView.getToolboxView().getBtnOuterColor().getBackground());

				} else if (headerWrapperView.getToolboxView().getTglBtnSelect().isSelected()) {
					toolboxController.handleSelect(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (!headerWrapperView.getToolboxView().getTglBtnSelect().isSelected()) {
					canvasController.handleCanvasRelease(e,
							headerWrapperView.getToolboxView().getBtnInnerColor().getBackground(),
							headerWrapperView.getToolboxView().getBtnOuterColor().getBackground());
				}
			}
		});
		canvasView.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (!headerWrapperView.getToolboxView().getTglBtnSelect().isSelected())
					canvasController.handleCanvasDrag(e,
							headerWrapperView.getToolboxView().getBtnInnerColor().getBackground(),
							headerWrapperView.getToolboxView().getBtnOuterColor().getBackground());
			}

		});

		// ShapePicker related stuff
		getContentPane().add(shapePickerView, BorderLayout.WEST);

		shapePickerView.getRdbtnPoint().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});

		shapePickerView.getRdbtnLine().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});
		
		shapePickerView.getRdbtnCircle().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});
		
		shapePickerView.getRdbtnSquare().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});
		
		shapePickerView.getRdbtnRectangle().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});
		
		shapePickerView.getRdbtnHexagon().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				toolboxController.handleShapePickerChange();
			}

		});

		// AdditionalAaction related stuff
		getContentPane().add(additionalActionsView, BorderLayout.EAST);
		additionalActionsView.getBtnBringToFront().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				additionalActionsController.doBringToFront();
			}
		});
		additionalActionsView.getBtnBringToBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				additionalActionsController.doBringToBack();
			}
		});
		additionalActionsView.getBtnToFront().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				additionalActionsController.doToFront();
			}
		});
		additionalActionsView.getBtnToBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				additionalActionsController.doToBack();
			}
		});

		additionalActionsView.getBtnParseLog().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mfController.parseNextLogLine();
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

		// IMPORTANT : If setVisible is not on end of constructor some of components
		// wont be visible on Windows/MacOS
		setVisible(true);
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

	public HeaderWrapperView getHeaderWrapperView() {
		return headerWrapperView;
	}

	public MenuFileController getMfController() {
		return mfController;
	}

	public ShapePickerView getShapePickerView() {
		return shapePickerView;
	}

	public void setShapePickerView(ShapePickerView shapePickerView) {
		this.shapePickerView = shapePickerView;
	}

	public MenuHelpController getMhController() {
		return mhController;
	}

	public void setMhController(MenuHelpController mhController) {
		this.mhController = mhController;
	}

	public AdditionalActionsView getAdditionalActionsView() {
		return additionalActionsView;
	}

	public void setAdditionalActionsView(AdditionalActionsView additionalActionsView) {
		this.additionalActionsView = additionalActionsView;
	}

	public AdditionalActionsController getAdditionalActionsController() {
		return additionalActionsController;
	}

	public void setAdditionalActionsController(AdditionalActionsController additionalActionsController) {
		this.additionalActionsController = additionalActionsController;
	}

}
