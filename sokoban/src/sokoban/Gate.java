package sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Gate extends Pixel {
	public Gate(int x,int y){
		super(x,y);
		URL loc = getClass().getResource("Gate_blue.png");
		ImageIcon g = new ImageIcon(loc);
		Image image =g.getImage();
		this.setImage(image);
		
	}
}
