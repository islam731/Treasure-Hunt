package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH ;
	public final int screenx;
	public final int screeny;
	public Player(GamePanel gp,KeyHandler keyH ) {
		this. keyH =keyH;
		this. gp=gp;
		screenx=gp.screenWidth/2 - (gp.titleSize/2);
		screeny= gp.screenHight/2 - (gp.titleSize/2);
		setDefaultValue();
	    getPlayerImage();
		
	}
	public void setDefaultValue() {
		worldx=gp.titleSize*23;
		worldy=gp.titleSize*21;
		speed=4;
		direction ="down";
	}
	public void getPlayerImage() {
	  try {
		  up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
		  up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
		  down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
		  down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
		  right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
		  right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
		  left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
		  left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
		  
     	  }catch(IOException e) {
     		  e.printStackTrace();
     	  }
		
		
		
		
		
	}
	public void update() {
		if(keyH.upPressed == true ||keyH.downPressed == true ||keyH.leftPressed == true ||keyH.rightPressed == true ) {
		if(keyH.upPressed == true) {
			direction="up";
			 worldy -= speed;   
		   }
		   else if(keyH.downPressed == true) {
			   direction="down";
			  worldy += speed;   
		   }
		   else if (keyH.leftPressed == true) {
			   direction="left";
			worldx-= speed;   
		   }
		   else if (keyH.rightPressed == true) {
			   direction="right";
			   worldx += speed;   
		   }
		spirteCounter++;
		if(spirteCounter>9) {
			if(spriteNum == 1) {
			spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
				}
			spirteCounter =0;
		}
		}
		
		
	}
	public void draw(Graphics2D g2) {
		
		 //    g2.setColor(Color.white);
		 //  g2.fillRect(x, y,gp.titleSize, gp.titleSize);
		BufferedImage image = null;
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) {
			image=up1;
			}
			if(spriteNum == 2) {
				image=up2;
				}
			break;
			
		case "down":
			if(spriteNum == 1){ 
				image=down1;
				}
			if(spriteNum == 2){ 
				image=down2;
				}
			break;
			
		case "right":
			if(spriteNum == 1){ 
				image=right1;
				}
			if(spriteNum == 2){ 
				image=right2;
				}
		break;
			
		case "left":
			if(spriteNum == 1){ 
				image=left1;
				}
			if(spriteNum == 2){ 
				image=left2;
				}
			break;
		}
		g2.drawImage(image, screenx, screeny, gp.titleSize ,gp.titleSize,null);
	}

}
