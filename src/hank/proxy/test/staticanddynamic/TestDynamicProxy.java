package hank.proxy.test.staticanddynamic;

public class TestDynamicProxy {
	public static void main(String[] args){
		// 目标对象
		IUserDao target = new UserDao();
		// 目标对象的原始类型
		System.out.println(target.getClass());
		// 给目标对象，创建代理对象
		IUserDao proxy  = (IUserDao)new ProxyFactory(target).getProxyInstance();
		// 内存中动态生成的代理对象
		System.out.println(proxy.getClass());
		proxy.save();
		
	}

}
