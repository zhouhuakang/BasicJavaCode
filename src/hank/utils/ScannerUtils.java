package hank.utils;

import java.util.Scanner;

/**
 * 各种输入形式的工具类
 * 
 * @author zhouhuakang
 *
 */
public class ScannerUtils {

	public static void main(String[] args) {
//		inputString();
		
	}

	/**
	 * 从终端接收一行字符串
	 */
	public static void inputString() {
		// 比如从终端输入输入字符串 "1,2017-07-25 06:00:00,2017-07-25 06:40:00"
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(s);
	}
	
}
