package app;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.UIManager;

import controller.AdditionalActionsController;
import controller.CanvasController;
import controller.InformationPaneController;
import controller.MenuFileController;
import controller.MenuHelpController;
import controller.ToolboxController;
import model.ShapeModel;
import util.Logger;

public class App {
	private static ShapeModel model;
	private static MainFrame frame;

	/**
	 * Initializes everything needed for app to start
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					// Get Logger singleton object
					Logger logger = Logger.getInstance();

					// Init all collections
					model = new ShapeModel();
					DefaultListModel<String> dlmLogger = logger.getDlmLogger();

					// Init main frame with resolution 800x600
					frame = new MainFrame(800, 600);

					// Set Logger DLM to Logger view so actions can be logged in real time
					frame.getFooterWrapperView().getLoggerView().setDlm(dlmLogger);

					// Set all controllers
					frame.setCanvasController(new CanvasController(frame, model));
					frame.setInformationPaneController(new InformationPaneController());
					frame.setToolboxController(new ToolboxController(model, frame));
					frame.setAdditionalActionsController(new AdditionalActionsController(model, frame));
					frame.setMfController(new MenuFileController(frame, model, logger.getLoggerModel()));
					frame.setMhController(new MenuHelpController());

					// Set shape model for Canvas View (View where all shapes are drawn)
					frame.getCanvasView().setModel(model);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public static ShapeModel getModel() {
		return model;
	}

	public static MainFrame getFrame() {
		return frame;
	}

}
