package com.jl.test;

public class DeadLock2 implements Runnable{

	private  Object obj1;
	
	private  Object obj2;
	
	public DeadLock2(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + " acquired lock on "+obj1);
          
            synchronized (obj2) {
                System.out.println("After, "+name + " acquired lock on "+obj2);
      
            }
            System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
	}

}
