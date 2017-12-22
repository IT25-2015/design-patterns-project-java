package app;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.UIManager;

import controller.CanvasController;
import controller.InformationPaneController;
import controller.MenuFileController;
import controller.ToolboxController;
import model.ShapeModel;
import util.Logger;

public class App {

	/**
	 * Initializes everything needed for app to start
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeModel model = new ShapeModel();
		Logger logger = Logger.getInstance();
		DefaultListModel<String> dlmLogger = logger.getDlmLogger();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

					MainFrame frame = new MainFrame(800, 600);
					CanvasController canvasController = new CanvasController(frame, model);
					frame.getFooterWrapperView().getLoggerView().setDlm(dlmLogger);
					
					frame.setCanvasController(canvasController);
					frame.setInformationPaneController(new InformationPaneController());
					frame.setToolboxController(new ToolboxController());
					frame.setMfController(new MenuFileController(frame, model));
					
					frame.getCanvasView().setModel(model);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
