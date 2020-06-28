package com.dhammikepiyumal.aztec;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import com.dhammikepiyumal.aztec.graphics.Screen;
import com.dhammikepiyumal.aztec.input.Keyboard;

public class Game extends Canvas implements Runnable {
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Aztec";

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;
	private Screen screen;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();

		addKeyListener(key);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long LastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - LastTime) / ns;
			LastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("ups : " + updates + ", fps : " + frames);
				frame.setTitle(title + " | " + "ups : " + updates + ", fps : " + frames);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	int x = 0, y = 0;

	public void update() {
		key.update();
		if (key.up) {
			y--;
		}
		if (key.down) {
			y++;
		}
		if (key.left) {
			x--;
		}
		if (key.right) {
			x++;
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		screen.render(x, y);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}

/*
 * 'Canvas' can be called as a window which the programmer can manipulate in any
 * manner
 */
/*
 * 'Runnable' allows the Game class to be used as a thread process
 */
/*
 * 'width' and 'height' are the dimensions of the window.
 */
/*
 * 'scale' is the factor that the window is to be stretched
 */
/*
 * 'title' is what displays in the title bar of the window
 */
/*
 * 'private static final long serialVersionUID = 1L' is added as the 'Game'
 * class extends the 'Canvas' class. It is some kind of a convention in Java to
 * add it
 */
/*
 * A 'thread' can be called as sub process other than the main process of
 * running the program. Here it is used to keep the game process of running the
 * game separated from the main process of executing the program
 */
/*
 * 'JFrame' is basically a type of Window. There are other types of Windows
 */
/*
 * 'Keyboard' object 'key' is created to interact with the keyboard inputs
 */
/*
 * 'addKeyListener(key)' is required component in order to listen to the
 * keystrokes
 */
/*
 * 'BufferedImage' is an image with an accessible buffer. Width, height and the
 * color type has been provided when creating the object.
 */
/*
 * 'Screen' is a class created in the graphics folder in order to handle the
 * graphics of the Game.
 */
/*
 * 'Dimension' is a way of providing coordinates in java
 */
/*
 * 'running' is the condition that keeps the Game loop running
 */
/*
 * '((DataBufferInt).image.getRaster().getDataBuffer()).getData())' converting
 * the image into an array of integers that represents the colors of each pixel
 * in the image. 'getRaster()' crates a rectangular array of pixels which can be
 * used to write data. Basically is saves the array of pixels that make up the
 * image. And, 'getDataBuffer()' returns the data of the Raster.
 */
/*
 * 'synchronized' is used to prevent the interferences between the threads and
 * to avoid memory consistency errors
 */
/*
 * 'thread = new Thread(this, "Display')' means passing this game class to
 * create a new thread object and provide it with the name 'Display'
 */
/*
 * 'thread.join()' is joining all the threads together to perform a certain task
 * applying the result for all of them. example : Stop running all the threads
 * to stop the program running
 */
/*
 * 'e.printStackTrace()' is used to print the error message if a certain error
 * has encountered
 */
/*
 * 'long LastTime = System.nanoTime()' is a very precise technique to receive
 * the computer's current time in nanoseconds to be stored in a variable of the
 * type 'long'. Similarly, 'long timer = System.currentTimeMillis()' is also an
 * instance where the current time is stored in milliseconds at 'timer'
 * variable.
 */
/*
 * 'final' means the value of that particular variable is not going to be
 * changed
 */
/*
 * 'frames' is a variable that has been defined to keep track of the number of
 * times than an image can be rendered in a second. Basically to get an
 * understanding of how fast the game can be run.
 */
/*
 * 'updates' is going to measure the number of times that 'update' method is
 * called in every second. In here, the value of this 'updates' variable should
 * always be 60.
 */
/*
 * 'update()' handles the logic and basically it updates the game. This is
 * planned to be restricted to 60 frames per second
 */
/*
 * 'render()' is displaying images in the screen. This is not going to be
 * restricted.
 */
/*
 * 'frame.setTitle(title + " | " + "Updates : " + updates + ", Frames : " +
 * frames)' is to update the title of the window to show the actual frames per
 * second and the number of screen updates we are doing per second. It can be
 * differ from computer to computer.
 */
/*
 * 'BufferStratergy' comes from the 'Canvas' and it is basically used as a
 * container to store the previously rendered images that need to be put on to
 * the window next. This is done due to the fact that real time updating of the
 * screen is not practical. Previously rendered image is kept at the buffer for
 * about 1/60 of a second.
 */
/*
 * 'screen.render()' is running the render method of the screen class which is
 * filling the entire pixels array with the rendered colors.
 */
/*
 * 'getBufferStratergy()' returns if there is already defined 'BufferStratergy'.
 * If it returns 'null', then 'createBufferStratergy(3)' creates a buffer
 * strategy. 3 here is the usual standard to go. What happens in here is that we
 * are creating 3 images at the same time. The one which is visible and two
 * other windows which are yet to come to the window. 3 is usually used for the
 * smooth running of the game. By going higher than 3, there is no actual real
 * world advantage.
 */
/*
 * 'bs.getDrawGraphics()' is basically creating a link between drawing
 * 'Graphics' on the screen and the actual buffer. It creates a graphics context
 * for the drawing buffer.
 */
/*
 * 'g.setColor(Color.BLACK)' is used to set the Graphical color of the Graphics
 * object g to be black
 */
/*
 * 'g.fillRect(0, 0, getWidth(), getHeight())' will fill a rectangle of given
 * Coordinate size. Here, 'getWidth()' and 'getHeight()' are methods written in
 * 'Canvas' to return the width and the height of the window /* 'g.dispose()'
 * just dispose(remove or clean) all of the Graphics that have been created.
 */
/*
 * 'g.drawImage(image, 0, 0, getWidth(), getHeight(), null)' is going to fill
 * the rectangular space provided with coordinate with the image provided.
 * 'null' is provided in the space where the name of the image should be
 * included.
 */
/*
 * 'bs.show()' will show the buffer that has been calculated
 */
/*
 * 'add' is used to add the game component to the window
 */
/*
 * 'pack' is used to size up the frame to be the same size of the component
 */
/*
 * 'setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)' is simply says terminate the
 * application when the close button on the top right corner of the window is
 * pressed
 */
/*
 * 'setLocationRealativeTo(null)' is making the window stay at the center of the
 * frame
 */
/*
 * 'setVisible(true)' is actually making the window visible on the screen to be
 * seen by the viewers
 */