package main;

public class Launcher {
	
	public static final String VERSION_ID = "1.0";
	
	public static void main(String[] args) {
		Game game = new Game("YouTube Tutorial " + VERSION_ID, 960, 720);
		game.start();
	}
	
}
