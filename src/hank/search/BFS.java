package hank.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1.首先将edge-pair转换成邻接表
 * @author zhouhuakang
 * 2.edge list表示图的话，则是一个E * 2的二维矩阵。
 * 3.本题中[A,B]代表的是完成课程B，需要先完成课程A，从有向图上来讲，则是 A 指向 B，即1号位置的B指向了0号位置的A。故下面初始化代码，是取1号位置的元素，作为邻接表的数组的元素
 */

public class BFS {
	public static void main(String[] agrs){
		List<Set> adjacentList = new ArrayList<Set>();
		
	}
	
    List<Set> edgePairToAajacentList(int nodeNum,int[][] edgePair){
    	List<Set> adjacentList = new ArrayList<Set>();
    	for (int i = 0; i < nodeNum; i++) {
			adjacentList.add(new HashSet<Integer>());
		}
    	int edgeNum = edgePair.length;
    	for (int i = 0; i < edgeNum; i++) {
			adjacentList.get(edgePair[i][0]).set
		}
    }
}
