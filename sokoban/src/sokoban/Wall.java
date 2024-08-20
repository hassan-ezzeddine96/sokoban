package sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Wall extends Pixel {
	public Wall(int x,int y){
		super(x,y);
		URL loc = getClass().getResource("wall.png");
		ImageIcon iia = new ImageIcon(loc);
		Image image =iia.getImage();
		this.setImage(image);
		
	}
}
