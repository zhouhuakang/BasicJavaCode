package hank.proxy.test.cglib;

import java.lang.reflect.Method;
import java.security.spec.EncodedKeySpec;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 * @author zhouhuakang
 *
 */
public class ProxyFactory implements MethodInterceptor{

	public Object target;
	public  ProxyFactory(Object target) {
		this.target = target;
	}
	// 给目标对象创建一个代理对象
	public Object getProxyInstance(){
		//1.工具类
		Enhancer enhancer = new Enhancer();
		//2.设置父类
		enhancer.setSuperclass(target.getClass());
		//3.设置回调函数
		enhancer.setCallback(this);
		//4.创建子类（创建代理类）
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("开始事务2...");
		// 执行目标对象的方法
		Object returnValue = method.invoke(target, args);
		System.out.println("提交事务2...");
		return returnValue;
	}


}
