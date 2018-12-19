package app;

import data.Doctor;
import data.Hospital;
import data.Nurse;
import data.Person;

public class HospitalApp {

	public static void main(String[] args) {
		Hospital hosp=new Hospital();
		Person person1=new Nurse("dupa","wolowa",1200,100);
		Person person2=new Nurse("dupa","wolowa",1500,100);
		Person person3=new Doctor("dupa","wolowa",120000,50);
		hosp.add(person1);
		hosp.add(person2);
		hosp.add(person3);
		System.out.println(hosp);
		

	}

}
