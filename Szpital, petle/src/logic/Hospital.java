package logic;

import data.Patient;

public class Hospital {
    public static final int MAX_PATIENTS_NUM = 10;
    private Patient[] patients;
    private int regPatiens;
 
    public Hospital() {
        patients = new Patient[MAX_PATIENTS_NUM];
        regPatiens = 0;
    }
 
    public void addPatient(Patient patient) {
        if (regPatiens < MAX_PATIENTS_NUM) {
            patients[regPatiens] = patient;
            regPatiens++;
        } else {
            System.out.println("Zapisano maxymalną liczbę pacjentów, zapraszamy jutro!");
        }
    }
 
    public void printPatients() {
        for(int i=0; i<regPatiens; i++) {
            System.out.println(patients[i].getName() + " " + patients[i].getLastName() + " "
                    + patients[i].getPESEL());
        }
    }
}