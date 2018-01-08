package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;

import app.MainFrame;
import io.exporter.ExportManager;
import io.exporter.SaveLogToFile;
import io.exporter.SerializeShapesToFile;
import io.importer.ImportManager;
import io.importer.LoadDrawingFromFile;
import io.importer.LoadLogFromFile;
import model.LoggerModel;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import shapes.ShapeObserver;
import util.FileOperationsHelper;
import util.Logger;

public class MenuFileController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2216489104960003132L;
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
		ExportManager manager = new ExportManager(new SerializeShapesToFile());
		String path = FileOperationsHelper.showFileDialog("drwg");
		if (path != null)
			manager.exportData(bundle, path);
	}

	/**
	 * Adds log lines list to bundle, opens FIle Dialog and calls save log to file
	 * method
	 */
	public void handleExportToLog() {
		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(loggerModel.getLogLines());
		ExportManager manager = new ExportManager(new SaveLogToFile());
		String path = FileOperationsHelper.showFileDialog("log");
		if (path != null)
			manager.exportData(bundle, path);
	}

	/**
	 * Imports all log lines from log file
	 */
	@SuppressWarnings("unchecked")
	public void handleImportFromLog() {
		ImportManager manager = new ImportManager(new LoadLogFromFile());
		String path = FileOperationsHelper.showFileDialog("log");
		if (path != null) {

			ArrayList<Object> bundle = manager.importData(path);
			for (String s : (ArrayList<String>) bundle.get(0)) {
				// TODO Implement this function fully
				Logger.getInstance().log("IMPORT", s, false);
			}
		}
	}

	/**
	 * Imports whole drawing from serialized file with .drwg extension
	 */
	@SuppressWarnings("unchecked")
	public void handleImportFromFile() {
		ImportManager manager = new ImportManager(new LoadDrawingFromFile());
		String path = FileOperationsHelper.showFileDialog("drwg");
		if (path != null) {
			ArrayList<Object> bundle = manager.importData(path);
			// If ArrayList setter was used observers wouldn't work at all
			for (Shape s : (ArrayList<Shape>) bundle.get(0)) {
				ShapeObserver observer = new ShapeObserver();
				observer.setShape(s);
				s.addObserver(observer);
				model.add(s);
			}
			Logger.getInstance().log("Imported drawing from " + path, true);
			frame.repaint();
		}
	}

}
