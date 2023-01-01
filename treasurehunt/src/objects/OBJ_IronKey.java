package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_IronKey extends SuperObject{
	public OBJ_IronKey(){
	name = "Iron Key";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ironkey.png"));
	}
	catch(IOException e){
		e.printStackTrace();
	}
	collision = true;
	
	}
}
