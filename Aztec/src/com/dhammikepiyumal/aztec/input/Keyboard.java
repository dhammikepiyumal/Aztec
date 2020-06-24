package com.dhammikepiyumal.aztec.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

		for (int i = 0; i < keys.length; i++) {
			if (keys[i]) {
				System.out.println("KEY :" + i);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
}

/*
 * 'Keyboard' is a class that is defined to detect and interact with the
 * keyboard inputs that put on to the 'Canvas'.
 */

/*
 * 'implements KeyListener' is listening to the keystrokes in the keyboard
 * bassed on a particular component. In this case, it is the 'Canvas'.
 */