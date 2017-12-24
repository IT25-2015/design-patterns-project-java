package io.exporter;

import java.util.ArrayList;

public interface Exporter {
	/**
	 * Exports given objects
	 * @param bundle
	 * @param path
	 */
	void exportData(ArrayList<Object> bundle, String path);
}
