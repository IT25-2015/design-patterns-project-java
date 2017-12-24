package io.importer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import util.Logger;

public class LoadDrawingFromFile implements Importer {

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Object> importData(String path) {
		if (path == null)
			return null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

			return (ArrayList<Object>) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getInstance().log("Error while importing shapes, error message:" + ex.getMessage(), true);
		}
		return null;
	}

}
