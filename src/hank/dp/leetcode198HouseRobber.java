package hank.dp;

public class leetcode198HouseRobber {
	/**
	 * 
	 * @param idx
	 *            当前正在考虑是否抢窃的房子的序号，即正在处理的nums中的下标
	 * @param nums
	 *            数组中的每个元素是房子中金额
	 * @return
	 */
	public int solve(int idx, int[] nums) {
		if (idx < 0) { // 假设我们从最大标号的房子往回抢劫，当idx<0的时候，代表抢劫结束,返回0
			return 0;
		}

		// 在遇到idx的房子时，有两种决策，抢劫还是不抢劫，我们得从这两种策略中选择一个较大的
		// 抢劫：则需要获取标号idx的房子中的金额，即nums[idx]代表我们现在抢劫标号为idx的房子，获得金额，
		// 但是代价是，不能抢劫相邻的房子的金额了，即不能搜索idx-1了，搜索的标号得从idx-2开始
		// 不抢劫：则直接开始搜索idx-1的房子

		return  Math.max(nums[idx] + solve(idx - 2, nums),
				solve(idx - 1, nums));

	}

	public int rob(int[] nums) {
        return solve(nums.length-1,nums);
    }

	public static void main(String[] args) {

	}
}
