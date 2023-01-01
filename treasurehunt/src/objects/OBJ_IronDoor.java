package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_IronDoor extends SuperObject{
	public OBJ_IronDoor(){
	name = "Iron Door";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/door_iron.png"));
	}
	catch(IOException e){
		e.printStackTrace();
	}
	collision = true;
	
	}
}
