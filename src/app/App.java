package app;

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
		MainFrame frame = new MainFrame(800, 600);
		CanvasController canvasController = new CanvasController(frame, model);
		frame.setCanvasController(canvasController);
		frame.setInformationPaneController(new InformationPaneController());
		frame.getCanvasView().setModel(model);
	}

}
