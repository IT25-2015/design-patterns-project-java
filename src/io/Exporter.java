package io;

import java.util.ArrayList;

public interface Exporter {
	/**
	 * Exports given objects
	 * @param objects
	 * @param path
	 */
	void export(ArrayList<Object> objects, String path);
}
