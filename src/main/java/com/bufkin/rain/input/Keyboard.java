package com.bufkin.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;

    public void update() {
        this.up = this.keys[KeyEvent.VK_UP] || this.keys[KeyEvent.VK_W];
        this.down = this.keys[KeyEvent.VK_DOWN] || this.keys[KeyEvent.VK_S];
        this.left = this.keys[KeyEvent.VK_LEFT] || this.keys[KeyEvent.VK_A];
        this.right = this.keys[KeyEvent.VK_RIGHT] || this.keys[KeyEvent.VK_D];

        System.out.println(this.up);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keys[e.getKeyCode()] = false;
    }
}
