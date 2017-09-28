package hank.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://ac.hustoj.com/problem.php?cid=1000&pid=3 题目描述 小 x
 * 正在做他的数学作业，可是作业实在太难了。题目是这样的：
 * 
 * 1.给定一个含有 N 个数的数列 V。
 * 
 * 2.你可以从数列中恰好移除 K 个数,定义移除后的数列为 V’。
 * 
 * 3.定义 M 为 V’中任意两个数的差的最大值，m 为 V’中任意两个数的差的最小值。
 * 
 * 4.请你选择删去的 K 个数，使得 M+m 最小。
 * 
 * 小 x 的数学十分之差，于是他只能向你求助了。
 * 
 * 输入 第一行两个整数 N 和 K。 第二行 N 个整数 Vi。
 * 
 * 输出 一行一个整数，为最小的 M+m 的和。
 * 
 * 样例输入 5 2 -3 -2 3 8 6 样例输出 7 提示
 * 
 * 【样例解释】
 * 
 * 
 * 删去-3 和-2，得到 V’={3,6,8}，M=5,m=2,M+m=7。
 * 
 * 
 * 【数据范围】
 * 
 * 
 * 对于 60%的数据：3 ≤ N ≤ 2 000
 * 
 * 
 * 对于 100%的数据：
 * 
 * 
 * 3 ≤ N ≤ 200 000
 * 
 * 
 * 1 ≤ K ≤ N - 2
 * 
 * 
 * -5 000 000 ≤V i ≤ 5 000 000
 * 
 * @author zhouhuakang
 *
 */
public class minMaxPlusMin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numsLength = scan.nextInt();
		int deleteNum = scan.nextInt(); //要删除的数字的个数
		System.out.println("输入数组的每一个元素时，请同时回车表示该元素输入结束\n");
		int[] nums = new int[numsLength];
		for (int i = 0; i < numsLength; i++) {
			nums[i] = scan.nextInt();
		}
		Arrays.sort(nums);          //排序
		int[] path = new int[nums.length - deleteNum]; //留下来的数字的数组
		int[] dp = new int[nums.length];
		System.out.println(deal(nums, 0, nums.length - deleteNum, path, dp));
	}

	public static int deal(int[] nums, int idx, int k, int[] path, int[] dp) {
		if (k == 0) {              //当删除0个数字时，这是递归调用的终止条件
			int max = Math.abs(path[path.length - 1] - path[0]);
			int tpMin = Integer.MAX_VALUE;
			for (int i = 1; i < path.length; i++) {
				int tp = Math.abs(path[i] - path[i - 1]);
				if (tp < tpMin) {
					tpMin = tp;
				}
			}
			return max + tpMin;
		} else if (k >= nums.length - idx - 1) {
			return Integer.MAX_VALUE;
		} else {               
			path[idx] = nums[idx];
			int a = deal(nums, idx + 1, k - 1, path, dp);
			int b = deal(nums, idx + 1, k, path, dp);
			if (a > b) {
				dp[idx] = b;
			} else {
				dp[idx] = a;
			}
		}
		return dp[idx];
	}

}
