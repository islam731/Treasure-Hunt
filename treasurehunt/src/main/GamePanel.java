package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManger;

public class GamePanel extends JPanel implements Runnable  {
	//SCREEN SETTINGS
	final int originalTitleSize = 16;
	final int scale = 3;
	public final int titleSize = originalTitleSize * scale ;
	public final int maxScreenCol =16;
	public final int maxScreenRow = 12;
	public final int screenWidth = titleSize * maxScreenCol ; //768 pixels
	public final int screenHight = titleSize * maxScreenRow ;// 576 pixels
	//WORLD SETTINGS
	public final int maxWorldCol=50;
	public final int maxWorldRow=50;
	public final int worldWidth = titleSize * maxWorldCol;
	public final int worldHeight = titleSize * maxWorldRow;
	
	int FPS = 60;
	TileManger tileM= new TileManger(this);
	
	
    KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this,keyH);
	
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	
	
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		while(gameThread != null) {
		long currentTime1 = System.nanoTime();
		delta +=(currentTime1 - lastTime)/drawInterval;
		lastTime = currentTime1;
		if(delta >=1) {
			
			//System.out.println("the game is running");
			update();
			repaint();
			delta--;
		}
		}
		
	}
   public void update() {
	   player.update();
	   
   }
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   Graphics2D g2 = (Graphics2D)g;
	   tileM.draw(g2);
	   player.draw(g2);
	   g2.dispose();
   }
}
