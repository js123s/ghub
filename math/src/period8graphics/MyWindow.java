package period8graphics;

import java.awt.Color;
import java.util.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener
{
	int width1 = 600;
	int height1 = 600;
//	Hero girl;
	Heroes yes;
	Heroes potion;
	
	boolean itemPickedUp;
	BufferedImage Landscape;

	public static void main(String[] args)
	{
		new MyWindow();
	}
	
	public MyWindow()
	{
		setSize(width1,height1);
		itemPickedUp = false;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width - w)/2;
		int y = (dim.height - h)/2;
			 yes  = new Heroes("Yes", "/images/hero/download.jpg", 100, 100);
			 if(!itemPickedUp)potion  = new Heroes("potion", "/images/hero/download.jpg", 100, 100);
			 Landscape = new BufferedImage(width1,height1,BufferedImage.TYPE_INT_ARGB);
			 Graphics2D g2 = (Graphics2D)Landscape.getGraphics();
			 
			if(Math.abs(yes.getX()-potion.getX()) + Math.abs(yes.getY()-potion.getY())
				<10) {
			itemPickedUp = true;
			}
			// paintLandscape(g2);
			// g2.drawImagelandscape
			//gets iamge once in for all
			 
			 
			 
		setVisible(true);
		
		setLocation(x,y);
		//static constant for close operations.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make girl exist here
	addKeyListener(this);
	
		
	}
	public void paint(Graphics g)
	{
		//Graphics is crayon box
		BufferedImage image = new BufferedImage(width1,height1, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0,0, width1, height1);
		
		
		
		int squaredD = 20;
		int margin = 2;
	/**
		while(true)
		{
		for(int i = 0; i < width1; i+= 5)
		{
			for(int j = 0; j < height1; j+= 5)
			{
				int a = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				int c = (int)(Math.random()*256);
				Color ran = new Color(a,b,c);
				g2.setColor(ran);
				
				g2.drawOval((int)Math.sin(i)*width1 , (int)Math.sin(j)*height1, i/2, j/2);
			}
		}
		**/
	
		//(removed here becuase it could cause errors) yes  = new Heroes("Yes", "/images/hero/download.jpg", 100, 100);
		g2.drawImage(yes.getImage(), yes.getX(), yes.getY(), null);
		
		
		g.drawImage(image, 0,0, null);
		
		
		}
		
		/**
		g2.setColor(Color.red);
		g2.fillOval(squaredD*5, 5*squaredD, width1/2, height1/2);
		g2.setColor(Color.blue);
		g2.drawOval(squaredD*5, 5*squaredD, width1/2, height1/2);
		
		//x,y,width,height,startDegree, lengthRad
		g2.fillArc(300, 300, 200, 200, -180, 180);
		g2.drawArc(300, 300, 200, 200, -180, 180);
		
		//String,x,y
		g2.drawString("YEAAAAAAAHHHHHHHHH!!!", 300, 400);
		
		//startX,startY,endX,endY
		g2.drawLine(0,0,width1, height1);
		/**for(int i = 0; i < width; i += squaredD+margin)
		{
			for(int j = 0; j < height; j += squaredD+margin)
			{
				int a = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				int c = (int)(Math.random()*256);
				Color ran = new Color(a,b,c);
				g2.setColor(ran);
				
				g2.fillRect(i, j, squaredD, squaredD);
			}
		}**/
		
		
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key==KeyEvent.VK_UP){
			yes.moveUp();
		}
		else if(key==KeyEvent.VK_DOWN){
			yes.moveDown();
		}
		else if(key==KeyEvent.VK_RIGHT){
			yes.moveRight();
		}
		else if(key==KeyEvent.VK_LEFT){
			yes.moveLeft();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
