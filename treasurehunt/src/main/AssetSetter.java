package main;

import java.awt.Graphics2D;

import objects.OBJ_Chest;
import objects.OBJ_Door;
import objects.OBJ_IronDoor;
import objects.OBJ_IronKey;
import objects.OBJ_Key;
import objects.Obj_Boots;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldx= 15 * gp.tileSize;
		gp.obj[0].worldy= 11 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldx= 34 * gp.tileSize;
		gp.obj[1].worldy= 11 * gp.tileSize;
		
		gp.obj[2] = new OBJ_IronKey();
		gp.obj[2].worldx= 44 * gp.tileSize;
		gp.obj[2].worldy= 21 * gp.tileSize;
		
		gp.obj[3] = new OBJ_IronKey();
		gp.obj[3].worldx= 5 * gp.tileSize;
		gp.obj[3].worldy= 21 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldx= 8 * gp.tileSize;
		gp.obj[4].worldy= 21 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldx= 41 * gp.tileSize;
		gp.obj[5].worldy= 21 * gp.tileSize;
		
		gp.obj[6] = new OBJ_IronDoor();
		gp.obj[6].worldx= 32 * gp.tileSize;
		gp.obj[6].worldy= 30 * gp.tileSize;
		
		gp.obj[7] = new OBJ_IronDoor();
		gp.obj[7].worldx= 17 * gp.tileSize;
		gp.obj[7].worldy= 30 * gp.tileSize;
		
		gp.obj[8] = new OBJ_IronDoor();
		gp.obj[8].worldx= 24 * gp.tileSize;
		gp.obj[8].worldy= 39 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Chest();
		gp.obj[9].worldx= 24 * gp.tileSize;
		gp.obj[9].worldy= 42 * gp.tileSize;
		
		gp.obj[10] = new Obj_Boots();
		gp.obj[10].worldx= 10 * gp.tileSize;
		gp.obj[10].worldy= 21 * gp.tileSize;
		
	}
	
}
