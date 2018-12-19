package app;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	  System.out.println("Żeby rozpocząć pomiar czasu wciśnij ENTER");
          sc.nextLine();
          Instant i1 = Instant.now();
           
          System.out.println("Żeby zatrzymać pomiar czasu wciśnij ENTER");
          sc.nextLine();
          Instant i2 = Instant.now();
           
          Duration time = Duration.between(i1, i2);
          System.out.println("Czas, który upłynął: " + time.getSeconds());
    }
}
