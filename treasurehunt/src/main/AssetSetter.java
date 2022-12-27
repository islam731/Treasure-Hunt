package main;

import java.awt.Graphics2D;

import objects.OBJ_Chest;
import objects.OBJ_Door;
import objects.OBJ_Key;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldx= 23 * gp.tileSize;
		gp.obj[0].worldy= 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldx= 23 * gp.tileSize;
		gp.obj[1].worldy= 40 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldx= 37 * gp.tileSize;
		gp.obj[2].worldy= 7 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldx= 10 * gp.tileSize;
		gp.obj[3].worldy= 11 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldx= 8 * gp.tileSize;
		gp.obj[4].worldy= 28 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldx= 12 * gp.tileSize;
		gp.obj[5].worldy= 22 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Chest();
		gp.obj[6].worldx= 10 * gp.tileSize;
		gp.obj[6].worldy= 8 * gp.tileSize;
		
	}
	
}
