package app;

import data.DataStore;

public class NotebookShop {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        dataStore.add(new Computer(12345, "ASUS"));
        dataStore.add(new Computer(12345, "ASUS"));
        dataStore.add(new Computer(5, "APPLE"));
        dataStore.add(new Computer(6, "APPLE"));
        dataStore.add(new Computer(8871927, "HP"));
         
        Computer compToFind = new Computer(12345, "ASUS");
        int computersFound = dataStore.checkAvailability(compToFind);
        System.out.println("Liczba komputerów " + compToFind + ": " + computersFound);
         
        System.out.println("Wszystkie dostępne komputery: ");
        for(Computer c: dataStore.getComputers()) {
            System.out.println(c);
        }
        System.out.println(dataStore.getComputers().length);
    }
}