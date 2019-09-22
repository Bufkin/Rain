package com.bufkin.rain;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		this.setPreferredSize(size);

		this.frame = new JFrame();
	}

	public synchronized void start() {
		this.running = true;
		this.thread = new Thread(this, "Display");
		this.thread.start();
	}

	public synchronized void stop() {
		this.running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (this.running) {
			this.update();
			this.render();
		}
	}

	public void update() {

	}

	public void render() {

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
