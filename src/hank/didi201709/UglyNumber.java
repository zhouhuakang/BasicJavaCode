package hank.didi201709;

import java.util.Scanner;

public class UglyNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int numberOfUgly = 0;
		int ans = 0;
		while (numberOfUgly < N) {
			++ans;
			if(isUgly(ans)){
				++numberOfUgly;
			}
		}
		System.out.println(ans);
	}

	public static boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return (number == 1) ? true : false;
	}
}
