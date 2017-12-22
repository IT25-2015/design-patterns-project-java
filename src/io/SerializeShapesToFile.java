package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializeShapesToFile implements Exporter, Serializable {

	@Override
	public void export(ArrayList<Object> objects) {
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("test.dat"))) {

			oos.writeObject(objects);
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
