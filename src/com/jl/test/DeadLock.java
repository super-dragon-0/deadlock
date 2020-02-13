package com.jl.test;

public class DeadLock implements Runnable{

	private static Object obj1 = new Object();
	
	private static Object obj2 = new Object();
	
	private boolean flag;
	
	public DeadLock(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����");
		if(flag) {
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName() + "�Ѿ���סobj1");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					 // ִ�в�������
					 System.out.println("1���Ӻ�"+Thread.currentThread().getName()
	                         + "��סobj2");
				}
			}
			
		}else {
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName() + "�Ѿ���סobj2");
	            try {  
	                Thread.sleep(1500);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            } 
	            synchronized(obj1){
	                // ִ�в�������
	                System.out.println("1���Ӻ�"+Thread.currentThread().getName()
	                            + "��סobj1");
	            }
			}
            
		}
		
	}

}
