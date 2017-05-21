package hank.dp;

import java.util.Scanner;

/**
 * http://www.hawstein.com/posts/dp-novice-to-advanced.html dp入门教程
 * 
 * @author zhouhuakang
 *
 */
public class LongestIncreseSubsequence {
	public void getLongestIncreseSubsequence(int[] A) {
		int[] d = new int[A.length];
		int len = 1;// 配合 if(len<d[i]) {len = d[i];}找出一个最长的非递减自序列的长度。
		for (int i = 0; i < A.length; i++) {
			d[i] = 1;// 定义初始值
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && d[j] + 1 > d[i]) { // 这里是找出各个子序列的最长非递减序列
					d[i] = d[j] + 1;
				}			
			}
			System.out.println("d["+i+"]="+d[i]);
			if (len < d[i]) {// 在各个自序列中的最长非递减长度中找出最长的
				len = d[i];
			}

		}
		System.out.println("len= " + len);

	}

	public static void main(String[] args) {
		int A[] = { 5, 3, 4, 8, 6, 7 };
		new LongestIncreseSubsequence().getLongestIncreseSubsequence(A);
	}
}
