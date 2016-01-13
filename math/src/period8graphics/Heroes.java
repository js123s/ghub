package period8graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Heroes {
 
		BufferedImage sprite;
		String name;
		int x;
		int y;
		
		public Heroes(String name, String imageLocation, int locationX, int locationY)
		{
			this.name = name;
			int width = 100;
			int height = 200;
			x = locationX;
			y = locationY;
			sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			URL url = getClass().getResource(imageLocation);
			try {
				BufferedImage original = ImageIO.read(url);
				Graphics2D g = (Graphics2D) sprite.getGraphics();
				int w = original.getWidth();
				int h = original.getHeight();
				//(whatTodraw, x, y, widthOfCanvas, heightOfCanvas, fromOriginalx, fromOriginaly, widthOfOri, and height, null)
				g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public BufferedImage getImage()
		{
			return sprite;
		}
		
		public String getName()
		{
			return name;
		}
		
		public int getX()
		{
			return x;
		}
		public int getY()
		{
			return y;
		}

		public void moveUp() {
			// TODO Auto-generated method stub
			y--;
			
		}

		public void moveDown() {
			// TODO Auto-generated method stub
			y++;
			
		}

		public void moveRight() {
			// TODO Auto-generated method stub
			x++;
		}

		public void moveLeft() {
			// TODO Auto-generated method stub
			x--;
		}
}
