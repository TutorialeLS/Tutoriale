package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class CompanyApp {

	public static void main(String[] args) throws InputMismatchException, NumberFormatException, NoSuchElementException,
			FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Program do sprawdzania wyplat pracowników, v.0.1");
		CompanyControl c = new CompanyControl();
		c.controlLoop();

	}

}
