import hank.search.BinarySearch;



public class Main {
	public static void main(String[] args) {
		int[] a = { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(new BinarySearch().binarySearch(a, 33));
		System.out.println(new BinarySearch().binarySearch(a, 1));
		System.out.println(new BinarySearch().binarySearch(a, 10));
	}
}
