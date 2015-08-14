package com.dum;

import java.util.Random;

/**to run this class you need main method maybe better in an other class
 * and make 3times  : Thread t1 = new Thread(Apple);
 * t1.start();*/
public class Apple implements Runnable {
	String name;
	int time;
	Random rnd = new Random();

	public Apple(String name) {
		this.name = name;
		time = rnd.nextInt(999);
	}

	@Override
	public void run() {
		// method
		System.out.printf("%s is sleeping for %d\n", name, time);
		try {
			Thread.sleep(time);
			System.out.printf("%s is done\n" , name);
		} catch (InterruptedException e) {
			// catch block
			e.printStackTrace();
		}
	}

}
