package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import data.Employee;

public class DataPrinter {

    public Employee readEmployee() throws FileNotFoundException, IOException, ClassNotFoundException {
        Employee e = null;
        try(
        FileInputStream fis = new FileInputStream(DataReader.FILE_STORE);
        ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
             
            e = (Employee)ois.readObject();
             
        } catch (FileNotFoundException ex) {
            System.err.println("Nie odnaleziono pliku " + DataReader.FILE_STORE);
            throw ex;
        } catch (IOException ex) {
            System.err.println("Błąd podczas zapisu danych do pliku " + DataReader.FILE_STORE);
            throw ex;
        } catch (ClassNotFoundException ex) {
            System.err.println("Nieprawidłowy format pliku");
            throw ex;
        }
         
        return e;
    }
}
