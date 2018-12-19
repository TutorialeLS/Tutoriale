package app;

import data.Pair;

public class Test {

	public static void main(String[] args) {
		Pair<Integer,String> pair1=new Pair<Integer, String>();//z pustym konstruktorem
		//lub
	//	Pair<Integer,String> pair1=new Pair<>(123,"456"); - z niepustym konstruktorem z klasy Pair
		Pair<String,String> pair2=new Pair<String, String>();
		Pair<Integer,Integer> pair3=new Pair<Integer, Integer>();
		pair1.setArrayT(123);
		pair1.setArrayV("456");
		
		pair2.setArrayT("123");
		pair2.setArrayV("456");
		
		pair3.setArrayT(123);
		pair3.setArrayV(456);
		
		
		pair1.printObjects();
		pair2.printObjects();
		pair3.printObjects();
	}

}
