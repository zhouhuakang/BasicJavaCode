package hank.thread;

/**
 * java多线程的经典问题： 
 * 问题：有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C，要求, 同时启动三个线程, 按顺序输出ABC, 循环10次。
 * @author zhouhuakang
 *
 *
 *结果； ABCABCABCABCABCABCABCABCABCABC

结果分析：有三个对象 a b c 
1. 首先是在线程1 在执行结束后，由于执行了a.notify(),唤醒了线程2，再由于执行了c.wait(),使得线程1 
处于等待，所以while只执行了一次，需要等待有人唤醒了c，才能继续执行。 
2.然后由于是线程2被唤醒了，执行了b.notify(),唤醒了线程3，再由于执行了a.wait(),使得线程2 
处于等待，所以while只执行了一次，需要等待有人唤醒了a，才能继续执行。 
3..然后由于是线程3被唤醒了，执行了c.notify(),唤醒了线程1，再由于执行了b.wait(),使得线程3 
处于等待，所以while只执行了一次，需要等待有人唤醒了b，才能继续执行。 
需要注意的是：虽然在线程1中，执行了c.wait()，但却使得线程1处于等待的状态，并且由于wait释放了对象锁，使得在线程3中，能够获得c的对象锁（语句：synchronized(now)）。
 */
public class waitAndNotify {
	public static void main(String[] args) throws Exception{
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		MyRunnable mr1 = new MyRunnable("A", c, a);
		MyRunnable mr2 = new MyRunnable("B", a, b);
		MyRunnable mr3 = new MyRunnable("C", b, c);
		
		Thread thread1 = new Thread(mr1);
		Thread thread2 = new Thread(mr2);
		Thread thread3 = new Thread(mr3);
		
		thread1.start();
		Thread.sleep(1000);
		
		thread2.start();
		Thread.sleep(1000);
		
		thread3.start();
		Thread.sleep(1000);	
	}
	public static class MyRunnable implements Runnable{
		private String name = "";
		private Object pre;//上一个对象
		private Object now;//此次对象
		public MyRunnable(String name,Object pre,Object now){
			this.name = name;
			this.pre = pre;
			this.now = now;
		}
		@Override
		public void run(){
			int count = 10;
			while(count > 0 ){
				count --;
				synchronized (pre) {
					synchronized (now) {
							System.out.println(name);
							now.notify(); //当前线程随机唤醒下一个等待now对象的对象锁的线程，但是目前改线程依旧持有now的锁
					}
					try{
						pre.wait(); //wait()的作用1.让当前线程进入等待状态，2.也会让当前线程释放它所持有的锁,直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前等待的线程将被唤醒(进入“就绪状态”)，等待CPU调度。
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
    
}

