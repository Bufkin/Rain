package com.bufkin.rain.graphics;

import java.util.Random;

public class Screen {

	private int width;
	private int height;
	public int[] pixels;
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = this.MAP_SIZE - 1;
	public int[] tiles = new int[this.MAP_SIZE * this.MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];

		for (int i = 0; i < this.tiles.length; i++) {
			this.tiles[i] = this.random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < this.pixels.length; i++) {
			this.pixels[i] = 0;
		}
	}

	public void render() {
		for (int y = 0; y < this.height; y++) {
			int yy = y;
			// if (yy < 0 || yy >= this.height) break;
			for (int x = 0; x < this.width; x++) {
				int xx = x;
				// if (xx < 0 || xx >= this.width) break;
				int tileIndex = ((xx >> 4) & this.MAP_SIZE_MASK) + ((yy >> 4) & this.MAP_SIZE_MASK) * this.MAP_SIZE;
				this.pixels[x + y * this.width] = this.tiles[tileIndex];
			}
		}
	}
}
