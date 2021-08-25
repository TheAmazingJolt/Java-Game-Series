package main;

import display.Display;

public class Game implements Runnable{

	private int width, height;
	private String title;
	
	private boolean running;
	
	private Thread thread;
	private Display display;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}else {
			running = true;
			thread = new Thread(this);
			thread.start();
			return;
		}
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps; //nanoseconds in every frame
		double delta = 0.0D; //change between times
		long lastTime = System.nanoTime(); //current time at program start
		long timer = 0L;
		int ticks = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / timePerTick; //finds difference between last time and current time
			timer += now - lastTime;
			lastTime = now; //resets lastTime to now
			if(delta >= 1.0D) { //runs every tick
				if(ticks > 60) {
					delta--;
				}
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0L;
			}
		}
		stop();
	}
	
	private void init() {
		display = new Display(title, width, height);
	}
	
	private void tick() {
		width = display.getFrame().getWidth();
		height = display.getFrame().getHeight();
		
		if(!display.getFrame().isShowing())
			System.exit(0);
	}
	
	private void render() {}

}
