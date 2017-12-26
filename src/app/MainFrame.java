package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import view.ShapePickerView;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private HeaderWrapperView headerWrapperView = new HeaderWrapperView();
	private CanvasView canvasView = new CanvasView();
	private FooterWrapperView footerWrapperView = new FooterWrapperView(new LoggerView(), new InformationPaneView());
	private ShapePickerView shapePickerView = new ShapePickerView();

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
		// Calculate center of screen and set frame there
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
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
				if (!headerWrapperView.getToolboxView().getTglBtnSelect().isSelected()
						&& shapePickerView.getRdbtnPoint().isSelected()) {
					canvasController.handleCanvasClick(e,
							headerWrapperView.getToolboxView().getBtnInnerColor().getBackground(),
							headerWrapperView.getToolboxView().getBtnOuterColor().getBackground());

				} else if (headerWrapperView.getToolboxView().getTglBtnSelect().isSelected()) {
					toolboxController.handleSelect(e);
				}
			}
		});
		canvasView.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				System.out.println("Dragged!");
			}

		});

		// ShapePicker related stuff
		getContentPane().add(shapePickerView, BorderLayout.WEST);

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

}
