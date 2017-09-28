package hank.testbasic.generic;

import java.util.LinkedList;

final public class Test {
	public static void main(String[] args) {
		LinkedList<NumericValue> numberList = new LinkedList<NumericValue>();
		numberList.add(new NumericValue((byte)0));
		numberList.add(new NumericValue((byte)1));
		NumericValue max = Collections.max(numberList);
		System.out.println(max.getValue());
	}
}
