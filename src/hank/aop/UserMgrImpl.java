package hank.aop;

public class UserMgrImpl implements UserMgr{

	@Override
	public void addUser() {
		System.out.println("添加用户");
		
	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");
	}
	
}
