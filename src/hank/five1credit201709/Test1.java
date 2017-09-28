package hank.five1credit201709;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Test1 {

	class CandiateValue {
		public Integer voteNum = 0;
		public Integer finalScore = 0;
		@Override
		public String toString() {
			return "CandiateValue [voteNum=" + voteNum + ", finalScore="
					+ finalScore + "]";
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		String[] V = s1.split(" ");
		String[] W = s2.split(" ");
		HashMap<String, CandiateValue> candidate = new HashMap<String, CandiateValue>();
		Test1 test1 = new Test1();
		for (int i = 0; i < V.length; i++) {
			if (candidate.containsKey(V[i])) {
				CandiateValue candiateValue = candidate.get(V[i]);
				candiateValue.voteNum = candiateValue.voteNum+1;
				candiateValue.finalScore = candiateValue.finalScore
						+ Integer.valueOf(W[i]);
				candidate.put(V[i], candiateValue);
			} else {
				Test1.CandiateValue candiateValue = test1.new CandiateValue();
				candiateValue.voteNum = 1;
				candiateValue.finalScore = Integer.valueOf(W[i]);
				candidate.put(V[i], candiateValue);
			}
		}
		//排序
		List<Map.Entry<String, CandiateValue>> list = new ArrayList<Map.Entry<String, CandiateValue>>(
				candidate.entrySet());
		Collections.sort(list,
				new Comparator<Map.Entry<String, CandiateValue>>() {
					
					@Override
					public int compare(Entry<String, CandiateValue> o1,
							Entry<String, CandiateValue> o2) {

						if (o1.getValue().finalScore < o2.getValue().finalScore) {
							return 1;
						} else if (o1.getValue().finalScore > o2.getValue().finalScore) {
							return -1;
						} else {
							return 0;
						}
					}
				});
		
//		 for (Map.Entry<String, CandiateValue> mapping : list) {  
//	            System.out.println(mapping.getKey() + ":" + mapping.getValue());  
//	        }  
		
		Integer maxFinalScore = list.get(0).getValue().finalScore;
		List<Map.Entry<String, CandiateValue>> list2 = new ArrayList<Map.Entry<String, CandiateValue>>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Entry<String, CandiateValue> entry = (Entry<String, CandiateValue>) iterator
					.next();
			if(entry.getValue().finalScore == maxFinalScore){
				list2.add(entry);
			}
		}
		
		Collections.sort(list,
				new Comparator<Map.Entry<String, CandiateValue>>() {
					
					@Override
					public int compare(Entry<String, CandiateValue> o1,
							Entry<String, CandiateValue> o2) {

						if (o1.getValue().voteNum < o2.getValue().voteNum) {
							return 1;
						} else if (o1.getValue().voteNum > o2.getValue().voteNum) {
							return -1;
						} else {
							return 0;
						}
					}
				});
		
	
		System.out.println(list2.get(0).getKey());

	}

	

}
