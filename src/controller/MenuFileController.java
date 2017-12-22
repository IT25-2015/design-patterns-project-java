package controller;

import java.util.ArrayList;

import app.MainFrame;
import io.ExportManager;
import io.SerializeShapesToFile;
import model.ShapeModel;

public class MenuFileController {
	private MainFrame frame;
	private ShapeModel model;

	public MenuFileController(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;
	}
	
	public void handleExportToFile() {
		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(model.getShapesList());
		bundle.add(ShapeModel.getUndoStack());
		bundle.add(ShapeModel.getRedoStack());
		ExportManager manager = new ExportManager(new SerializeShapesToFile());
		manager.export(bundle);
	}
}
