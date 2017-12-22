package io.importer;

import java.util.ArrayList;

public class ImportManager implements Importer {
	private Importer importer;

	public ImportManager(Importer importer) {
		this.importer = importer;
	}

	@Override
	public void importData(ArrayList<Object> objects, String path) {
		importer.importData(objects, path);
	}

}
