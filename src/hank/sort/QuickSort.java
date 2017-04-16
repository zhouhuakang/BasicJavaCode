package hank.sort;

import java.util.Arrays;

public class QuickSort {

	public void sort(int a[], int low, int high) {
		if (low > high) {
			return;
		}
		int index = a[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (i < j && a[j] >= index) {
				j--;
			}
			if (i < j) {
				a[i++] = a[j];
			}
			while (i < j && a[i] < index) {
				i++;
			}
			if (i < j) {
				a[j--] = a[i];
			}
		}
		a[i] = index;// i现在所指的位置是中间位置
		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}

	public static void main(String[] args) {
		int a[] = { 9, 20, 3, 5, 6, 8, 22, 11 };
		int high = a.length - 1;
		new QuickSort().sort(a, 0, high);
		System.out.println(Arrays.toString(a));
	}
}
