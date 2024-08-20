package sokoban;


import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Ball extends Pixel {
	public Ball(int x,int y){
		super(x,y);
		URL loc = getClass().getResource("EndPoint_Red.png");
		ImageIcon iia = new ImageIcon(loc);
		Image image =iia.getImage();
		this.setImage(image);
		
	}
	public void Move(int x,int y){
		int nx=this.getPosX() + x;
		int ny=this.getPosY() + y;
		this.setPosX(nx);
		this.setPosY(ny);
	}

}
