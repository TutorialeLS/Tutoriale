package test;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
	List<Object> ob=new ArrayList<>();
	ob.add(1);
	ob.add("cos");
	ob.add('a');
	ob.add(true);
//	for(int i=0;i<ob.size();i++) {
//		System.out.println(ob.get(i));
//	}
	String a = "123";
	int result = 1;
    result = 31 * result + ((a == null) ? 0 : a.hashCode());
	System.out.println(result);
	}

}
