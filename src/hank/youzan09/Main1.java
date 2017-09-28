package hank.youzan09;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int r1 = -1, c2 = -1;
		int[][] matrix = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				matrix[i][j] = scanner.nextInt();

		int row = r - 1;
		int col = 0;
		while (row >= 0 && col <= matrix[0].length - 1) {
			if (k == matrix[row][col]) {
				r1 = row;
				c2 = col;
				break;
			} else if (k > matrix[row][col]) {
				col++;
			} else {
				row--;
			}
		}
		System.out.println(r1 + " " + c2);
		scanner.close();
	}
	

}
