package app;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class test {
	public static void main (String args[]) {
		Queue<Person> qA=new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person arg0, Person arg1) {
				return -arg0.getPriority().compareTo(arg1.getPriority());
			}
		});

		qA.offer(new Person("Lucjan","Sakowicz",Person.Priority.valueOf("LOW")));
		qA.offer(new Person("Lucjan2","Sakowicz2",Person.Priority.valueOf("MID")));
		qA.offer(new Person("Lucjan3","Sakowicz3",Person.Priority.valueOf("HIGH")));
		qA.offer(new Person("Lucjan3","Sakowicz4",Person.Priority.valueOf("HIGH")));
		qA.offer(new Person("Lucjan4","Sakowicz5",Person.Priority.valueOf("MID")));
		System.out.println(qA.peek());
		System.out.println(qA.size());
		System.out.println(qA);
		qA.poll();
		System.out.println(qA);
		qA.poll();
		System.out.println(qA);
		qA.poll();
		System.out.println(qA);
	}
}
