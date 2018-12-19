package data;

public class Pair<T,V> {
	private T arrayT;
	private V arrayV;
	public static int i=1;
	
	public T getArrayT() {
		return arrayT;
	}

	public void setArrayT(T arrayT) {
		this.arrayT = arrayT;
	}


	public V getArrayV() {
		return arrayV;
	}

	public void setArrayV(V arrayV) {
		this.arrayV = arrayV;
	}
//	public Pair(T t, V v) {
//        setArrayT(t);
//        setArrayV(v);
//    }
	public void printObjects() {
		System.out.println("Obiekt: "+i);
		System.out.println("ArrayT: "+getArrayT()+", klasa: "+arrayT.getClass());
		System.out.println("ArrayV: "+getArrayV()+", klasa: "+arrayV.getClass());
		i++;
		
}
}
