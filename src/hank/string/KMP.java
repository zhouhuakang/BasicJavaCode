package hank.string;

public class KMP {

	// public int[] getNext(String needle) {
	// char p[] = needle.toCharArray();
	// int size = p.length;
	// int next[] = new int[size];
	// int index = 0;
	// next[0] = -1;
	// for (int i = 1; i < size; i++) {
	// int =
	// }
	//
	// }
	/**
	 * 暴力求解，查看模式串needle在主串中是否存在 存在，返回模式串在主串中的位置（首字母的位置）
	 * 
	 * @param haystack
	 *            主串，
	 * @param needle
	 *            子串，即模式串
	 */
	public static int violent(String haystack, String needle) {
		char[] sArr = haystack.toCharArray();
		char[] pArr = needle.toCharArray();
		int sLength = sArr.length;
		int pLength = pArr.length;

		int i = 0;
		int j = 0;
		while (i < sLength && j < pLength) {
			// ①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
			if (sArr[i] == pArr[j]) {
				i++;
				j++;
			} else {
				// ②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0 相当于每次匹配失败时，i 回溯，j
				// 被置为0。
				i = i - (j - 1);
				j = 0;
			}
		}
		if (j == pLength) {
			return i - j;
		} else
			return -1;
	}

	public static void main(String[] args) {
		String haystack = "BBC ABCDAB ABCDABCDABDE";
		String needle = "ABCDABD";
		System.out.println(violent(haystack, needle));
	}
}
