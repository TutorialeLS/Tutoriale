package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import data.Employee;

public class DataSaver {

	public void saveEmployee(Employee e) {
		try (FileOutputStream fs = new FileOutputStream(DataReader.FILE_STORE,true);
				ObjectOutputStream os = new ObjectOutputStream(fs);

		)

		{
			os.writeObject(e);
		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

}
