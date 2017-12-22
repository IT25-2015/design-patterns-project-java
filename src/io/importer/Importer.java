package io.importer;

import java.util.ArrayList;

public interface Importer {
	/**
	 * Imports given objects
	 * @param objects
	 * @param path
	 */
	void importData(ArrayList<Object> objects, String path);
}
