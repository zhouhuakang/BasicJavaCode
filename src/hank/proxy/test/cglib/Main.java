package hank.proxy.test.cglib;

public class Main {
	public static void main(String[] args){
		//生成目标对象
		UserDao userDao = new UserDao();
		//生成代理对象
		UserDao userDaoProxy = (UserDao)new ProxyFactory(userDao).getProxyInstance();
		//执行代理对象的方法
		userDaoProxy.save();
	}
}
