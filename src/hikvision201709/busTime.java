package hikvision201709;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS 内存限制：C/C++语言 65536KB；其他语言 589824KB 题目描述：
 * 有一环形公交站
 * ，包含N(N>=3)个站点【站点序号：1…N】，每个站点停留5分钟，相邻两个站点之间行驶时间都是10分钟，循环行驶，已知第一圈第一个站点的进入时间为X
 * ，现在公交行驶时间为Y，请计算当前公交行驶的圈数，以及处在哪个站点之间M-N【如果是停在某个站点Z,则输出Z-Z】. 输入 一行字符串:
 * 3,2017-07-25 06:00:00,2017-07-25 06:06:00 3,2017-07-25 06:00:00,2017-07-25
 * 06:05:00【整数、时间字符串、时间字符串，时间精确到分钟】分别表示站点数，第一圈第一个站点的进入时间，目前时间； 数据之间使用逗号分隔；
 * 要求至少三个站点。 如输入条件不满足，则输出“incorrect data” 输出 1;1-2
 * 数据表示：公交正在行驶第一圈，在第一个站点和第二个站点之间；圈数与行驶站点之间使用分号分隔
 * 
 * 如果是1;2-2则表示公交正在行驶第一圈，目前停留在第二个站点
 * 
 * 样例输入 
 * 3,2017-07-25 06:00:00,2017-07-25 06:40:00 
 * 3,2017-07-25 06:00:00,2017-07-25 08:45:00 
 * 1,2017-07-25 06:00:00,2017-07-25 06:40:00
 * 3,2017-07-25 06:00:66,2017-07-25 06:40:99 
 * 样例输出 
 * 1;1-1 
 * 4;3-3 
 * incorrect data
 * incorrect data
 * 
 * @author zhouhuakang
 *
 */

public class busTime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(",");
		int n = Integer.parseInt(input[0]);
		//先把不合理情况排除
		if (n < 3 || !input[1].substring(17).equals("00")
				|| !input[2].substring(17).equals("00")) {
			System.out.print("incorrect data");
		} else {
			SimpleDateFormat simpleFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm");
			long from = 0;
			long to = 0;
			try {
				from = simpleFormat.parse(input[1].substring(0, 16)).getTime();
				to = simpleFormat.parse(input[2].substring(0, 16)).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int minutes = (int) ((to - from) / (1000 * 60));
			int cn = minutes / (15 * n) + 1;
			System.out.print(cn + ";");
			int minutes2 = minutes % (15 * n); //
			int temp1 = minutes2 % 15;  // 
			int temp2 = minutes2 / 15;
			if (minutes2 <= (n - 1) * 15) {  //如果当前的bus在  1  到 n-1站 之间
				if (temp1 == 0) {
					System.out.print(temp2 + 1 + "-" + (temp2 + 1));
				} else if (temp1 < 10) {
					System.out.print(temp2 + 1 + "-" + (temp2 + 2));
				} else {
					System.out.print(temp2 + 2 + "-" + (temp2 + 2));
				}
			} else if (temp1 < 10) {    // minutes2 > (n - 1) * 15时的情况分析
				System.out.print(n + "-" + 1); // n-1，从最后一站驶往首发站
			} else {
				System.out.print(1 + "-" + 1); // 1-1，在第一站等待
			}
		}
		scanner.close();
	}
}
