package hank.proxy.test.staticanddynamic;

public class UserDaoProxy implements IUserDao{

	// 被代理的对象
	private IUserDao target;
	public UserDaoProxy(IUserDao target) {
		this.target = target;
	}
	@Override
	public void save() {
		System.out.println("开始事务");
		target.save();// 被代理对象的方法的前后加上了额外的功能，类似于Srping中的AOP功能
		System.out.println("结束事务");
	}
	
}
