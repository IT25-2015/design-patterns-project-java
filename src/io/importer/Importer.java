package io.importer;

import java.util.ArrayList;

public interface Importer {
	/**
	 * Imports given objects
	 * @param bundle
	 * @param path
	 */
	ArrayList<Object> importData(String path);
}
