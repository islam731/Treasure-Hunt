package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import objects.SuperObject;
import tile.TileManger;

public class GamePanel extends JPanel implements Runnable  {
	//SCREEN SETTINGS
	final int originaltileSize = 16;
	final int scale = 3;
	public final int tileSize = originaltileSize * scale ;
	public final int maxScreenCol =16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol ; //768 pixels
	public final int screenHight = tileSize * maxScreenRow ;// 576 pixels
	//WORLD SETTINGS
	public final int maxWorldCol=50;
	public final int maxWorldRow=50;
	
	
	int FPS = 60;
	TileManger tileM= new TileManger(this);
	
	
    KeyHandler keyH = new KeyHandler(this);
    sound music= new sound();
    sound se = new sound();
	
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui=new UI (this);
	Thread gameThread;
	public Player player = new Player(this,keyH);
	public SuperObject obj[]= new SuperObject[12];
	
	public int gameState;
	public final int playState = 1 ;
	public final int pauseState = 2 ;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	
	public void setupGame() {
		aSetter.setObject();
		playMusic(0);
		gameState = playState;
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
	   if(gameState == playState) {
	   player.update();
	   }
	   if(gameState == pauseState) {
		   
	   }
	   
   }
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   Graphics2D g2 = (Graphics2D)g;
	   tileM.draw(g2);
	   for(int i =0 ; i<obj.length; i++) {
		   if(obj[i]!= null) {
			   obj[i].draw(g2,this);
		   }
	   }
	   player.draw(g2);
	   ui.draw(g2);
	   g2.dispose();
   }
   public void playMusic (int i) {
	     music. setFile (i);
	     music. play ();
	     music. loop ();
	 }
	public void stopMusic () {
		 music.stop ();
	 }
	public void playSE (int i) {
	     se. setFile (i);
	     se. play ();
	}

}
