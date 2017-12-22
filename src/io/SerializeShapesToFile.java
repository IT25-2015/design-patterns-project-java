package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializeShapesToFile implements Exporter, Serializable {

	/**
	 * Will serialize given array list and save it to path given
	 */
	@Override
	public void export(ArrayList<Object> objects, String path) {
		if(path == null) return;
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(path))) {

			oos.writeObject(objects);
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
