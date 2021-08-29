package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64;
	private static final int height = 64;

	public static SpriteSheet testSheet;
	
	public static BufferedImage test;
	public static BufferedImage testSheetImg[] = new BufferedImage[4];
	
	public static void init() {
		
		testSheet = new SpriteSheet(ImageLoader.loadImage("/testSheet.png"));
		
		test = ImageLoader.loadImage("/test.png");
		
		testSheetImg[0] = testSheet.crop(0, 0, width, height);
		testSheetImg[1] = testSheet.crop(width, 0, width, height);
		testSheetImg[2] = testSheet.crop(0, height, width, height);
		testSheetImg[3] = testSheet.crop(width, height, width, height);
	}
	
}
