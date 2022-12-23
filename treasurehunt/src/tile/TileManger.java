package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManger {
	GamePanel gp;
	Tile[ ] tile;
	int mapTileNum[][];
	
	public TileManger(GamePanel gp) {
		
		this.gp=gp;
		tile=new Tile[10];
		mapTileNum=new int [gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/world.txt");
	}
	public void getTileImage() {
		
		try {
			
			tile[0]=new Tile();
			tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.jpg"));
			
			tile[1]=new Tile();
			tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall1.jpg"));
			
			tile[2]=new Tile();
			tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.jpg"));
			

			tile[3]=new Tile();
			tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.jpg"));
			

			tile[4]=new Tile();
			tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Sand.png"));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap (String filePatch) {
		 try {
			InputStream is = getClass().getResourceAsStream(filePatch);
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			
			int col=0;
			int row=0;
			
			while(col<gp.maxWorldCol && row<gp.maxWorldRow)
			{
				String  line = br.readLine();
				
				while (col<gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum [col][row]=num;
					col++;
			}
				if(col==gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			br.close();
			
		 }catch (Exception e) {
			 
		 }
	}
	
	public void draw(Graphics2D g2) {
		
		int Worldcol =0;
		int Worldrow=0;
		
		while(Worldcol<gp.maxWorldCol && Worldrow < gp.maxWorldRow )
		{
			
			int tileNum=mapTileNum[Worldcol][Worldrow];
			int worldx=Worldcol*gp.titleSize;
			int worldy=Worldrow *gp.titleSize;
			int screenx=worldx - gp.player.worldx + gp.player.screenx;
			int screeny=worldy - gp.player.worldy + gp.player.screeny;
			if (worldx +gp.titleSize>gp.player.worldx - gp.player.screenx &&
			    worldx -gp.titleSize <gp.player.worldx+ gp.player.screenx && 
			    worldy +gp.titleSize> gp.player.worldy- gp.player.screeny &&
				worldy -gp.titleSize< gp.player.worldy+ gp.player.screeny) {
			
				g2.drawImage(tile[tileNum].image, screenx, screeny, gp.titleSize, gp.titleSize, null);	
			}
			
			
			Worldcol++;
		
			
			if(Worldcol==gp.maxWorldCol) {
				Worldcol=0;
				Worldrow++;
			}
		}
	
	}

}
