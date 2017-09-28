package hank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		String Value = scanner.nextLine();
		String[] numsString = Value.split(" ");
		int[] nums = new int[numsString.length];
		for (int i = 0; i < numsString.length; i++) {
			nums[i] = Integer.parseInt(numsString[i]);
		}
		int k = scanner.nextInt();
		sort(nums, 0,nums.length-1);
//		for(int i = 0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
//		System.out.println("\n");
		System.out.println(nums[nums.length - k ]);

	}

	public static int maxSub(int[] num, int l, int r) {
		if (l > r)
			return 0;
		if (l == r)
			return num[l];
		int m = (l + r) / 2;

		int lmax = num[m], lsum = 0;
		for (int i = m; i >= l; i--) {
			lsum += num[i];
			if (lsum > lmax)
				lmax = lsum;
		}

		int rmax = num[m + 1], rsum = 0;
		for (int i = m + 1; i <= r; i++) {
			rsum += num[i];
			if (rsum > rmax)
				rmax = rsum;
		}
		int temp = Math.max(lmax + rmax, maxSub(num, l, m));
		return Math.max(temp, maxSub(num, m + 1, r));
	}
	
	public static void sort(int a[], int low, int high) {
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

}
