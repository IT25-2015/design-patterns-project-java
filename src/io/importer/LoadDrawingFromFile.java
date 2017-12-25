package io.importer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import util.DialogsHelper;
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
			String msg = "Error while importing shapes, error message:" + ex.getMessage();
			ex.printStackTrace();
			DialogsHelper.showErrorMessage(msg);
			Logger.getInstance().log(msg, true);
		}
		return null;
	}

}
