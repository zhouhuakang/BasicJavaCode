package hank.netease201708;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * n个棋子，第i个棋子放x[i]，y[i]的位置，移动棋子，每次上下左右一次，求棋盘中某个格子出现至少i个棋子的移动次数
 * 输入例子
 * 4
 * 1 2 4 9 
 * 1 1 1 1 
 * 代表4个棋子可放在(1,1)(2,1)(4,1)(9,1)
 * 输出例子：序号代表的是某个格子至少出现的棋子的个数
 * 0 1 3 10
 * 某个格子至少1个，移动0次
 * 某个格子至少2个，移动1次 将前两个棋子放在（1，1）中
 * 某个格子至少3个，移动3次 将前3个棋子放在（2，1）中
 * 某个格子至少4个，移动1次 将全部棋子放在（3，1）中
 * @author zhouhuakang
 *
 */
public class ChessMoveCount {
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			ArrayList<Integer> x =  new ArrayList<Integer>();
			ArrayList<Integer> y =  new ArrayList<Integer>();
//			for(int i= 0;i< n;i++)
				
			}
	    }
}
	
}
