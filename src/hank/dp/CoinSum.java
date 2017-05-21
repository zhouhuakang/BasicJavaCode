package hank.dp;

import java.util.Scanner;

/**
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * http://www.hawstein.com/posts/dp-novice-to-advanced.html
 * @author zhouhuakang
 *
 */
public class CoinSum {
	
	public void dp(int totalCoinValue){
		int[] singleCoinValue = {1,3,5};
		int[] min = new int[totalCoinValue+1]; //防止越界，加1
		//设置min[i] (i=1 to i =totolCoinValue)为无穷大
		for (int i = 0; i < min.length; i++) {
			min[i]= Integer.MAX_VALUE;
		}
		//定义初始子问题，即初始状态，即总面值0元需要0个硬币（此状态特殊，不考虑硬币面额）
		min[0]=0;
		
		for(int i = 1;i<=totalCoinValue;i++){
			for (int j = 0; j < singleCoinValue.length; j++) {
				if (singleCoinValue[j]<=i && min[i-singleCoinValue[j]]+1<min[i]) {
					min[i] = min[i-singleCoinValue[j]]+1;
				}
			}
			System.out.println("min["+i+"]="+min[i]);
		}
		
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int totalCoinValue = scanner.nextInt();
		System.out.println(totalCoinValue);
		new CoinSum().dp(totalCoinValue);
	}

}
