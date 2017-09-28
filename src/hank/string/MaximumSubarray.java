package hank.string;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		// 枚举起点
		int ans = -2147483647;
		for (int st = 0; st < nums.length; st++) {
			// 枚举终点
			for (int ed = st+1; ed <=nums.length; ed++) {
				// 求和
				int sum = 0;
				for (int i = st; i < ed; i++) {
					sum += nums[i];
				}
				if (sum > ans) {
					ans = sum;
				}
			}
		}
		return ans;
	}
}
