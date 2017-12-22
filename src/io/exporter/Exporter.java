package io.exporter;

import java.util.ArrayList;

public interface Exporter {
	/**
	 * Exports given objects
	 * @param objects
	 * @param path
	 */
	void exportData(ArrayList<Object> objects, String path);
}
