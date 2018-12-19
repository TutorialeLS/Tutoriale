package app;

public class Numbers {
	private int[] numbers;

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	public Numbers() {
		numbers=new int[10];
	}
	public void add(int index, int number) throws ArrayIndexOutOfBoundsException{
		if(index<0||index>=numbers.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		numbers[index]=number;
	}
	public int get(int index) throws ArrayIndexOutOfBoundsException{
		if(index<0||index>=numbers.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return numbers[index];
	}
}
