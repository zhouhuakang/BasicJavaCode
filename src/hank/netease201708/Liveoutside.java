package hank.netease201708;

import java.util.Scanner;

/**
 * 1.每天1水果和x元房租
 * 2.现有f个水果和d元现金
 * 3.商店卖p元1个水果
 * 4.问：可在外最多活几天？
 * @author zhouhuakang
 *
 */
public class Liveoutside {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int x = in.nextInt();
    	int f = in.nextInt();
    	int d = in.nextInt();
    	int p = in.nextInt();
    	int min = 0;
    	int ans = 0;
    	int day1 = 0,day2 = 0;
    	//买水果y元
    	for (int y = 0; y <= d ; y+=10) {
			day1 = y/p +f;
			day2 = (d-y)/x;
			min = Math.min(day1, day2);
			if(min > ans)
				ans = min;
		}
    	System.out.println(ans);   
    }
    
}
