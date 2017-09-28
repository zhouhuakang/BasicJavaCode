package hank.testbasic.generic;

/**
 * 泛型类的  静态变量  是共享的
 * @author zhouhuakang
 *
 */
public class StaticTest {
	public static void main(String[] args){
		GT<Integer> gti = new GT<Integer>();
		gti.var = 1;
		GT<String> gts = new GT<String>();
		gts.var = 2;
		System.out.println(gti.var);
	}
}
class GT<T>{
	public static int var = 0;
}