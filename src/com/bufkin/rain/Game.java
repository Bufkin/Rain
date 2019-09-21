package com.bufkin.rain;

public class Game implements Runnable {

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;

	public synchronized void start() {
		this.thread = new Thread(this, "Display");
		this.thread.start();
	}

	public synchronized void stop() {
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}

}
