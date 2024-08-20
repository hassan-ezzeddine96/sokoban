package sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Player extends Pixel {
	public Player(int x,int y){
		super(x,y);
		URL loc = getClass().getResource("Character.jpg");
		ImageIcon iia = new ImageIcon(loc);
		Image image =iia.getImage();
		this.setImage(image);
		
	}
	public void Move(int x,int y){
		int nx = this.getPosX() + x;
		int ny = this.getPosY() + y;
		this.setPosX(nx);
		this.setPosY(ny);
	}
}
