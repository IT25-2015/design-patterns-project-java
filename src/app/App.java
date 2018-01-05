package app;

import javax.swing.DefaultListModel;

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
		model = new ShapeModel();
		Logger logger = Logger.getInstance();
		DefaultListModel<String> dlmLogger = logger.getDlmLogger();

		frame = new MainFrame(800, 600);
		CanvasController canvasController = new CanvasController(frame, model);
		frame.getFooterWrapperView().getLoggerView().setDlm(dlmLogger);

		frame.setCanvasController(canvasController);
		frame.setInformationPaneController(new InformationPaneController());
		frame.setToolboxController(new ToolboxController(model, frame));
		frame.setAdditionalActionsController(new AdditionalActionsController(model, frame));
		frame.setMfController(new MenuFileController(frame, model, logger.getLoggerModel()));
		frame.setMhController(new MenuHelpController());

		frame.getCanvasView().setModel(model);
	}

	public static ShapeModel getModel() {
		return model;
	}

	public static MainFrame getFrame() {
		return frame;
	}

}
