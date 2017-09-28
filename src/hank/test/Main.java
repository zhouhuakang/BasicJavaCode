package hank.test;

import java.util.Scanner;

public class Main {
	/** 请完成下面这个process函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;

	public static class Box {
		int price;
		int length;
		int width;
		int height;
	}

	public static class Item {
		int price;
		int length;
		int width;
		int height;
	}

	private static int process(Box box, Item[] items) {
		return search(0, 0, 0, 0, 0, box, items);
	}

	private static int search(int idx, int currentPrice, int currentLength,
			int currentHeight, int currentWidth, Box box, Item[] items) {
		if (idx >= items.length)
			return -1;
		if (currentPrice == box.price || currentLength == box.length || currentLength ==box.width|| currentLength ==box.height
				|| currentHeight == box.height || currentHeight == box.width|| currentHeight == box.length  
				|| currentWidth == box.width|| currentWidth == box.height|| currentWidth == box.length
				) {
			return 0;
		}
		Item item = items[idx];
		if (((item.price + currentPrice < box.price)
				&& (item.length + currentLength < box.length)
				&& (item.height + currentHeight < box.height) && (item.width
				+ currentWidth < box.width))
				|| ((item.price + currentPrice < box.price)
						&& (item.length + currentLength < box.length)
						&& (item.width + currentHeight < box.height) && (item.height
						+ currentWidth < box.width))
				|| ((item.price + currentPrice < box.price)
						&& (item.width + currentLength < box.length)
						&& (item.height + currentHeight < box.height) && (item.length
						+ currentWidth < box.width))
				|| ((item.price + currentPrice < box.price)
						&& (item.width + currentLength < box.length)
						&& (item.length + currentHeight < box.height) && (item.height
						+ currentWidth < box.width))
				|| ((item.price + currentPrice < box.price)
						&& (item.height + currentLength < box.length)
						&& (item.width + currentHeight < box.height) && (item.length
						+ currentWidth < box.width))
				|| ((item.price + currentPrice < box.price)
						&& (item.height + currentLength < box.length)
						&& (item.length + currentHeight < box.height) && (item.width
						+ currentWidth < box.width))) {

			return search(idx, item.price + currentPrice, item.length
					+ currentLength, item.height + currentHeight, item.width
					+ currentWidth, box, items);
		} else {
			return search(idx + 1, 0, 0, 0, 0, box, items) + 1;
		}
	}

	public static void main(String args[]) {
		Box box = new Box();
		Scanner scanner = new Scanner(System.in);

		box.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

		while (scanner.hasNext()) {
			box.length = scanner.nextInt();
			box.width = scanner.nextInt();
			box.height = scanner.nextInt();
			// 商品数量
			int itemNum = scanner.nextInt();
			Item[] items = new Item[itemNum];
			for (int i = 0; i < itemNum; i++) {
				Item item = new Item();
				item.price = scanner.nextInt();
				item.length = scanner.nextInt();
				item.width = scanner.nextInt();
				item.height = scanner.nextInt();
				items[i] = item;
			}

			long startTime = System.currentTimeMillis();
			int boxMinNum = Integer.MAX_VALUE;
			System.out.println(process(box, items));
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		}
	}

}