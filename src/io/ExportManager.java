package io;

import java.util.ArrayList;

public class ExportManager implements Exporter {
	private Exporter exporter;

	public ExportManager(Exporter exporter) {
		this.exporter = exporter;
	}

	@Override
	public void export(ArrayList<Object> objects, String path) {
		exporter.export(objects, path);
	}

}
