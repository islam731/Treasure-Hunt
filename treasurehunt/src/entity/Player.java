package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
		screenx= gp.screenWidth/2 - (gp.tileSize/2);
		screeny= gp.screenHight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle(8,16,32,32);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		
		setDefaultValue();
	    getPlayerImage();
		
	}
	public void setDefaultValue() {
		worldx=gp.tileSize*23;
		worldy=gp.tileSize*21;
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
			   
		   }
		   else if(keyH.downPressed == true) {
			   direction="down";
			   
		   }
		   else if (keyH.leftPressed == true) {
			   direction="left";
			  
		   }
		   else if (keyH.rightPressed == true) {
			   direction="right";
			     
		   }
		collisionOn = false;
		gp.cChecker.checkTile(this);
		int objIndex =gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);
		
		if(collisionOn == false) {
			switch(direction) {
			
			case "up":
				 worldy -= speed;
				break;
				
			case "down":
				 worldy += speed; 
				break;
				
			case "right":
				worldx += speed; 
			break;
				
			case "left":
				worldx-= speed; 
				break;
			}
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
		public int hasKey=0;
    public void pickUpObject(int index) {
		if(index != 999) {
			String objectName = gp.obj[index].name;
			
			switch(objectName) {
			case "key":
				gp.playSE(1);
				hasKey++;
				gp.obj[index]=null;
				gp.ui.showMessage(" you got a key! ");
				break;
			case "Door":
				if(hasKey > 0) {
					gp.playSE(3);
				gp.obj[index]=null;
				hasKey--;
				gp.ui.showMessage(" you opened a door ! ");
				}
				else {
					gp.ui.showMessage(" you need a key! ");
				}
				System.out.println(hasKey);
			break;
			case "Boots":
				gp.playSE(2);
				speed +=2;
				gp.obj[index]=null;
				gp.ui.showMessage(" speed up! ");
			gp.obj[index]=null;
			break;
			
			case "Chest":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			}
				}	
		
		
	}
	public void draw(Graphics2D g2) {
		
		 //    g2.setColor(Color.white);
		 //  g2.fillRect(x, y,gp.tileSize, gp.tileSize);
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
		g2.drawImage(image, screenx, screeny, gp.tileSize ,gp.tileSize,null);
	}

}
