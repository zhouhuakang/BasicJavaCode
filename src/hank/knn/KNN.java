package hank.knn;

/**
 * http://www.voidcn.com/blog/skylovedaim/article/p-1645195.html
 * 
 * @author zhouhuakang
 *
 */
public class KNN {

	private static double[][] DATA = { { 5.1, 3.5, 1.4, 0.2, 0 },
			{ 4.9, 3.0, 1.4, 0.2, 0 },
			{ 4.7, 3.2, 1.3, 0.2, 0 },
			{ 4.6, 3.1, 1.5, 0.2, 0 },
			{ 5.0, 3.6, 1.4, 0.2, 0 },
			{ 7.0, 3.2, 4.7, 1.4, 1 },
			{ 6.4, 3.2, 4.5, 1.5, 1 },
			// { 6.9, 3.1, 4.9, 1.5, 1 }, //测试数据
			{ 5.5, 2.3, 4.0, 1.3, 1 }, { 6.5, 2.8, 4.6, 1.5, 1 },
			{ 5.7, 2.8, 4.5, 1.3, 1 }, { 6.5, 3.0, 5.8, 2.2, 2 },
			{ 7.6, 3.0, 6.6, 2.1, 2 }, { 4.9, 2.5, 4.5, 1.7, 2 },
			{ 7.3, 2.9, 6.3, 1.8, 2 }, { 6.7, 2.5, 5.8, 1.8, 2 },
			{ 6.9, 3.1, 5.1, 2.3, 2 } };

	private static int K = 6;
	private static int CLASSFIY = 3;

	public static void main(String[] args) {
		// 待求解数组
		double distince[] = { 6.9, 3.1, 4.9, 1.5, 1 };

//		KNN knn = new KNN();
//		// 求出求解的分类与二维数组间元素的临近距离
//		double[] questionDistinces = new double[DATA.length];
//		for (int i = 0; i < DATA.length; i++) {
//			double[] item = DATA[i];
//			questionDistinces[i] = knn.distince(item, distince);
//		}
//		System.out.println("临近距离集合：" + Arrays.toString(questionDistinces));
//		int nearest[] = knn.paraseKDistince(questionDistinces, K);
//		System.out.println("K 个最临近距离下标集合：" + Arrays.toString(nearest));
//
//		System.out.println("{ 6.9, 3.1, 4.9, 1.5, x }的 x 位置求解为："
//				+ knn.vote(nearest));
	}

	// 计算临近距离[除开求解分类]
	public double distince(double[] paraFirstData, double[] paraSecondData) {
		double tempDistince = 0;
		if ((paraFirstData != null && paraSecondData != null)
				&& paraFirstData.length == paraSecondData.length) {
			for (int i = 0; i < paraFirstData.length - 1; i++) {
				tempDistince += Math.abs(paraFirstData[i] - paraSecondData[i]);
			}
		} else {
			System.out.println("firstData 与 secondData 数据结构不一致");
		}
		return tempDistince;
	}
	
}
