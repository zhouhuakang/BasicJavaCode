package hank.search;

public class BinarySearch {
	/*
	 * 1.下标0不存数据,所有返回为0的话，则代表没有找到
	 */
	public int binarySearch(int[] array, int key) {
		int low = 1, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return 0;
	}
	

	 public static void main(String[] args) {
	 int[] a = { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	 System.out.println(new BinarySearch().binarySearch(a, 33));
	 System.out.println(new BinarySearch().binarySearch(a, 1));
	 System.out.println(new BinarySearch().binarySearch(a, 10));
	 }

}
