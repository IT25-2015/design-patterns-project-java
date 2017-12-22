package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class SaveLogToFile implements Exporter {

	/**
	 * Will crate new empty file to save log to, save line by line into it
	 */
	@Override
	public void export(ArrayList<Object> objects, String path) {
		File logFile = new File(path);
		try {
			logFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		Path pathObj = Paths.get(path);
		for (String logLine : (ArrayList<String>) objects.get(0)) {
			logLine += "\n";
			byte[] strToBytes = logLine.getBytes();
		    try {
				Files.write(pathObj, strToBytes, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
