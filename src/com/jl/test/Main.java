package com.jl.test;

public class Main {

	public static void main(String[] args) {
		/*Thread t1 = new Thread(new DeadLock(true), "线程1");
		Thread t2 = new Thread(new DeadLock(false), "线程2");
		t1.start();
		t2.start();*/
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Thread t1 = new Thread(new DeadLock2(obj1,obj2), "t1");
		Thread t2 = new Thread(new DeadLock2(obj2,obj3), "t2");
		Thread t3 = new Thread(new DeadLock2(obj3,obj1), "t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
