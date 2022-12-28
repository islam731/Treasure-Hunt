package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objects.OBJ_Key;

public class UI {
	GamePanel gp;
	Font arial_40,arial_80B;
	BufferedImage keyimage;
	public boolean messageon = false;
	public String message ="";
	int messagecounter=0;
	public boolean gameFinished = false;

	public UI(GamePanel gp) {
	this.gp = gp;

	arial_40 = new Font("Arial", Font.PLAIN, 40);
	arial_80B = new Font("Arial", Font.BOLD, 80);
	OBJ_Key key=new OBJ_Key();
	keyimage=key.image;
	}
	public void showMessage (String text) {

		message = text;
		messageon = true;
		}
	public void draw(Graphics2D g2) {
if ( gameFinished == true) {
	
	g2.setFont (arial_40);
	g2.setColor (Color.white) ;

	String text;
	int textLength;
	int x;
	int y;

	text = "You found the treasure!";
	textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

	x = gp.screenWidth/2 - textLength/2;
	y = gp.screenHight/2 - (gp.tileSize*3);
	g2.drawString(text, x, y);
	
	
	g2.setFont(arial_80B);
	g2.setColor(Color.yellow);
	text = "congratulation !";
	textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
	x = gp.screenWidth/2 - textLength/2;
	y = gp.screenHight/2 +(gp.tileSize*2);
	g2.drawString(text, x, y);
	gp.gameThread=null;
}
else {
	
	g2.setFont (arial_40);
	g2.setColor (Color.white) ;
	g2.drawImage(keyimage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize,null);
	g2.drawString("Key = "+ gp.player.hasKey, 74, 65);
	
	if(messageon == true) {
		g2.setFont (g2.getFont().deriveFont(30F));
		g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
        messagecounter++;
				if(messagecounter > 120) {
				messagecounter = 0;
				messageon = false;
				}

	}
	}
	}}	

	
