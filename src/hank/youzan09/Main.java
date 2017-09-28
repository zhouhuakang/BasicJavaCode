package hank.youzan09;

import hank.dp.leetcode198HouseRobber;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
//		Scanner scanner = new Scanner(System.in);
//		String sentence = scanner.nextLine();
//		System.out.println(new String((reverseWord(sentence.toCharArray()))));
//		
		int i = 0;
//		System.out.println(i--);
//		System.out.println(i++);
		System.out.println(i++-i--);
//		System.out.println(i);
//		System.out.println(i+'0');
	}
	
	public static void reverse(char[] data, int start, int end) {
	    if (null == data || data.length < 1 || start < 0 || end > data.length) {
	        return;
	    }
	    while (start < end) {
	        char tmp = data[start];
	        data[start] = data[end];
	        data[end] = tmp;
	        start++;
	        end--;
	    }
	}
	
	public static char[] reverseWord(char[] sentence) {
	    if (null == sentence || sentence.length < 1) {
	        return sentence;
	    }
	    //全部旋转一遍
	    reverse(sentence, 0, sentence.length - 1);
	    //然后旋转每个单词，还原单词本来顺序
	    int start = 0;
	    int end = 0;
	    while (start < sentence.length) { 
	        if (sentence[start] == ' '||  !(sentence[start]>='A' &&  sentence[start]<='Z')  ||   !(sentence[start]>='a' &&  sentence[start]<='z')) {
	            start++;
	            end++;
	        } else if (end == sentence.length || sentence[end] == ' ') {
	        	
	            reverse(sentence, start, end - 1);
	            end++;
	            start = end;
	        } else {
	        	
	            end++;
	        }
	    }
	    return sentence;
	}
}
