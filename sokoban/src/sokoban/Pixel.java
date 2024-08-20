package sokoban;
import java.awt.Image;;
public class Pixel {
private int posX;
private int posY;
private Image image;
private int d = 20;

public Pixel(int x,int y){
	this.posX=x;
	this.posY=y;
}
public int getPosX(){
	return posX;
}
public void setPosX(int posX){
	this.posX=posX;
}
public int getPosY(){
	return posY;
}
public void setPosY(int posY){
	this.posY=posY;
}
public Image getImage(){
	return image;
}
public void setImage(Image image){
	this.image=image;
}
public boolean LeftPositionObject (Pixel Object){
	if(((this.getPosX() - d) ==Object.getPosX()) && (this.getPosY()==Object.getPosY())){return true;}
	else{return false;}
}
public boolean RightPositionObject(Pixel Object){
	if(((this.getPosX() + d) ==Object.getPosX()) && (this.getPosY()==Object.getPosY())){return true;}
	else{return false;}
}
public boolean UpPositionObject(Pixel Object){
	if(((this.getPosY() - d) ==Object.getPosY()) && (this.getPosX()==Object.getPosX())){return true;}
	else{return false;}
}
public boolean DownPositionObject(Pixel Object){
	if(((this.getPosY() + d) ==Object.getPosY()) && (this.getPosX()==Object.getPosX())){return true;}
	else{return false;}
}



}
