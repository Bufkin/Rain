package com.bufkin.rain.graphics;

public class Screen {

    public int[] pixels;
    private int width;
    private int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }

    public void clear() {
        for (int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = 0;
        }
    }

    public void render() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.pixels[30 + 40 * this.width] = 0xff00ff;
            }
        }
    }
}
