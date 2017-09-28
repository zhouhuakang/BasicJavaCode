package hank.proxy.test.staticanddynamic;

public class Main {
	public static void main(String[] args){
		// 被代理对象，即目标对象
		UserDao target = new UserDao();
		// 代理对象
		UserDaoProxy userDaoProxy = new UserDaoProxy(target);
		userDaoProxy.save();
	}
}
