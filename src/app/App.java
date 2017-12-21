package app;

import javax.swing.DefaultListModel;

import controller.CanvasController;
import controller.InformationPaneController;
import model.ShapeModel;

public class App {

	/**
	 * Initializes everything needed for app to start
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeModel model = new ShapeModel();
		DefaultListModel<String> dlmLogger = new DefaultListModel<String>();

		MainFrame frame = new MainFrame(800, 600);
		CanvasController canvasController = new CanvasController(frame, model);
		dlmLogger.addElement("Test 1");
		dlmLogger.addElement("Test 2");
		dlmLogger.addElement("Test 3");
		dlmLogger.addElement("Test 4");
		dlmLogger.addElement("Test 5");
		dlmLogger.addElement("Test 6");
		dlmLogger.addElement("Test 7");
		dlmLogger.addElement("Test 8");
		dlmLogger.addElement("Test 9");
		dlmLogger.addElement("Test 10");
		dlmLogger.addElement("Test 11");
		dlmLogger.addElement("Test 12");
		frame.getFooterWrapperView().getLoggerView().setDlm(dlmLogger);
		frame.setCanvasController(canvasController);
		frame.setInformationPaneController(new InformationPaneController());
		frame.getCanvasView().setModel(model);
	}

}
