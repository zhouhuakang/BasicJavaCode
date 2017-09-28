package hank.testbasic.generic;

import java.util.List;

/**
 * 因为类型擦除，所以无法用参数列表所谓的类型不同来重载方法
 * @author zhouhuakang
 *
 */
public class Erasure {
	public void test(List<String> ls){
		System.out.println("String");
	}
	public void test(List<Integer> li){
		System.out.println("Integer");
	}
}
