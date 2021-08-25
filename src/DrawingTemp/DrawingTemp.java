package DrawingTemp;

import java.awt.Color;
import java.awt.Graphics;

public class DrawingTemp {

	public static void render(Graphics g) {
		g.drawRect(10, 10, 25, 30);
		g.setColor(Color.BLUE);
		g.fillOval(30, 50, 50, 80);
		g.setColor(Color.RED);
		g.drawString("Hello World!", 200, 200);
	}
	
}
