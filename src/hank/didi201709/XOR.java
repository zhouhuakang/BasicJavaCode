package hank.didi201709;

import java.util.Scanner;

import javax.xml.transform.Templates;

/**
 * 给出n个数字a_1,...a_n,问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0
 * 即找出最大的k，使得存在k个区间（l[i],r[i]）,满足1<=l[i]<=r[i]<=n(1<=i<=k),
 * r[i]<l[i+1](1<=i<k),且a[l[i]] xor a[l[i]+1] xor ... xor a[r[i]] = 0 (1<=i<=k)
 * 
 * 输入描述 第1行一个整数n;第2行n个整数
 * a_1,....a_n,对于30%的数据，n<=20;对于100%的数据，n<=100000,a_i<=10000 输出描述 一个整数表示最多的区间个数
 * 示例：
 * 
 * 输入 4 3 0 2 2 输出 2 说明 [0] xor = 0 ,[2,2] 2 xor 2 = 0,所以是2个不重叠的非空区间。
 * 
 * 
 * @author zhouhuakang
 *
 */
public class XOR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < numbers.length; i++) {
			int temp = 0;
			for (int j = 0; j < numbers.length; j++) {
				if ((temp ^ numbers[j]) == 0) {
					temp = temp ^ numbers[j];
				}else{
					break;
				}
			}
			if(temp==0){
				ans++;
			}
		}
		System.out.println(ans);
	}

}
