package controller;

import java.util.ArrayList;

import app.MainFrame;
import io.ExportManager;
import io.SaveLogToFile;
import io.SerializeShapesToFile;
import model.LoggerModel;
import model.ShapeModel;
import util.FileOperationsHelper;

public class MenuFileController {
	private MainFrame frame;
	private ShapeModel model;
	private LoggerModel loggerModel;

	public MenuFileController(MainFrame frame, ShapeModel model, LoggerModel loggerModel) {
		this.frame = frame;
		this.model = model;
		this.loggerModel = loggerModel;
	}

	/**
	 * Bundles all 3 shape collections to Object ArrayList, opens File Dialog and
	 * calls export to file method
	 */
	public void handleExportToFile() {
		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(model.getShapesList());
		bundle.add(ShapeModel.getUndoStack());
		bundle.add(ShapeModel.getRedoStack());
		ExportManager manager = new ExportManager(new SerializeShapesToFile());
		manager.export(bundle, FileOperationsHelper.showFileDialog());
	}

	/**
	 * Adds log lines list to bundle, opens FIle Dialog and calls save log to file
	 * method
	 */
	public void handleExportToLog() {
		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(loggerModel.getLogLines());
		ExportManager manager = new ExportManager(new SaveLogToFile());
		manager.export(bundle, FileOperationsHelper.showFileDialog());
	}

}
