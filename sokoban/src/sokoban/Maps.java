package sokoban;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class Maps extends JPanel {
private ArrayList<Wall> arrWall = new ArrayList<Wall>();
private ArrayList<Ball> arrBall = new ArrayList<Ball>();
private ArrayList<Gate> arrGate = new ArrayList<Gate>();
private ArrayList<Object> arrMaps = new ArrayList<Object>();
private Player soko;
private int width=0;
private int high = 0;
private int d = 20;

private File myfile;

public Maps(File file){
	setMap(file);
}
public void setMap(File file){
	try{
		if(file != null){
			FileInputStream input = new FileInputStream(file);
			myfile = file;
			int posX = 0;
			int posY = 0;
			Wall wall;
			Ball b;
			Gate a;
			int data;
			while((data=input.read())!=-1){
				char item =(char) data;
				if(item == '\n'){
					posY+=d;
					if(this.width<posX)
						this.width=posX;
					posX=0;
				}
				else if(item=='#'){
					wall=new Wall (posX , posY);
					arrWall.add(wall);
					posX +=d;
				}
				else if(item=='x'){
					b=new Ball(posX , posY);
					arrBall.add(b);
					posX +=d;
				}
				else if(item=='o'){
					a=new Gate(posX , posY);
					arrGate.add(a);
					posX +=d;
				}
				else if(item=='@'){
					soko=new Player(posX , posY);
					posX +=d;
				}
				else if(item=='.'){
					posX +=d;
				}
				high=posY; 
				}
			input.close();
			}
			
		}
	catch(IOException ex){
		Logger.getLogger(Maps.class.getName()).log(Level.SEVERE, null, ex);
	}
}
@Override
public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(new Color(255,255,255));
	g.fillRect(0, 0, this.getWidth(), this.getHigh());
	arrMaps.addAll(arrWall);
	arrMaps.addAll(arrGate);
	arrMaps.addAll(arrBall);
	arrMaps.add(soko);
	for(int i=0;i<arrMaps.size();i++){
		if(arrMaps.get(i)!=null){
			Pixel item = (Pixel) arrMaps.get(i);
			g.drawImage(item.getImage(),item.getPosX(),item.getPosY(),this);

		}
	}
}
public int getWidth(){
	return this.width;
}
public int getHigh(){
	return this.high;
}
public void PrintMotion(String input){
	
	
		
			
			if(input.equalsIgnoreCase("u")){
				
					if(CheckObjectWall(soko,"u")){
						return;
						}
					else if(CheckBallPlayerWall("u")){
						return;
					}else{
						soko.Move(0,-d);
						repaint();
					
					}
				
			}
			else if (input.equalsIgnoreCase("d")){
				
					if(CheckObjectWall(soko,"d")){
						return;
						}
					else if(CheckBallPlayerWall("d")){
						return;
					}else{
						soko.Move(0,d);
						repaint();
					
					}
				}
				
			else if (input.equalsIgnoreCase("r")){
				
					if(CheckObjectWall(soko,"r")){
						return;
						}
					else if(CheckBallPlayerWall("r")){
						return;
					}else{
						soko.Move(d,0);
						repaint();
				
					
					}
				}
				
			
			else if (input.equalsIgnoreCase("l")){
				
					if(CheckObjectWall(soko,"l")){
						return;
						}
					else if(CheckBallPlayerWall("l")){
						return;
					}else{
						soko.Move(-d,0);
						repaint();
					
					}
				}
				
			
			
			
			
		}
				
	

private boolean CheckObjectWall (Pixel player,String input){
	boolean help = false;
	if(input.equalsIgnoreCase("l")){
		for(int i=0;i<arrWall.size();i++){
			Wall wall=(Wall) arrWall.get(i);
			if(player.LeftPositionObject(wall)){
				help=true;
				break;
			}
		}
		
	}
	else if(input.equalsIgnoreCase("r")){
		for(int i=0;i<arrWall.size();i++){
			Wall wall=(Wall) arrWall.get(i);
			if(player.RightPositionObject(wall)){
				help=true;
				break;
			}
		}
		
	}
	else if(input.equalsIgnoreCase("u")){
		for(int i=0;i<arrWall.size();i++){
			Wall wall=(Wall) arrWall.get(i);
			if(player.UpPositionObject(wall)){
				help=true;
				break;
			}
		}
		
	}
	else if(input.equalsIgnoreCase("d")){
		for(int i=0;i<arrWall.size();i++){
			Wall wall=(Wall) arrWall.get(i);
			if(player.DownPositionObject(wall)){
				help=true;
				break;
			}
		}
		
	}
	return help;
}

private boolean CheckBallGate(Pixel object,String input){
	boolean help=false;
	if(input.equalsIgnoreCase("l")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol = (Ball) arrBall.get(i);
			if(object.LeftPositionObject(bol)){
				help=true;
				break;
			}
		}
	}
	else if(input.equalsIgnoreCase("u")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol = (Ball) arrBall.get(i);
			if(object.UpPositionObject(bol)){
				help=true;
				break;
			}
		}
	}
	else if(input.equalsIgnoreCase("r")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol = (Ball) arrBall.get(i);
			if(object.RightPositionObject(bol)){
				help=true;
				break;
			}
		}
	}
	else if(input.equalsIgnoreCase("d")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol = (Ball) arrBall.get(i);
			if(object.DownPositionObject(bol)){
				help=true;
				break;
			}
		}
	}
	return help;
}
private boolean CheckBallPlayerWall(String input){
	boolean help=false;
	if(input.equalsIgnoreCase("l")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol1=(Ball) arrBall.get(i);
			if(soko.LeftPositionObject(bol1)){
				if(CheckBallGate(bol1,"l")){
					help=true;
					break;
				
				}
				else if(CheckObjectWall(bol1,"l")){
					help=true;
					break;
					
				}
				else{bol1.Move(-d,0);
				isCompleted();
				}
			}
		}
	}
	else if(input.equalsIgnoreCase("r")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol1=(Ball) arrBall.get(i);
			if(soko.RightPositionObject(bol1)){
				if(CheckBallGate(bol1,"r")){
					help=true;
					break;
				
				}
				else if(CheckObjectWall(bol1,"r")){
					help=true;
					break;
					
				}
				else{bol1.Move(d,0);
				isCompleted();
				}
			}
		}
	}
	else if(input.equalsIgnoreCase("u")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol1=(Ball) arrBall.get(i);
			if(soko.UpPositionObject(bol1)){
				if(CheckBallGate(bol1,"u")){
					help=true;
					break;
				
				}
				else if(CheckObjectWall(bol1,"u")){
					help=true;
					break;
					
				}
				else{bol1.Move(0,-d);
				isCompleted();
				}
			}
		}
	}
	else if(input.equalsIgnoreCase("d")){
		for(int i=0;i<arrBall.size();i++){
			Ball bol1= (Ball) arrBall.get(i);
			if(soko.DownPositionObject(bol1)){
				if(CheckBallGate(bol1,"d")){
					help=true;
					break;
				
				}
				else if(CheckObjectWall(bol1,"d")){
					help=true;
					break;
					
				}
				else{bol1.Move(0,d);
				isCompleted();
				}
			}
		}
	}
	return help;
	
	

}

public void isCompleted(){
	int balls = arrBall.size();
	int goal =0;
	for(int i =0;i<arrBall.size();i++){
		Ball bol=(Ball) arrBall.get(i);
		for(int j=0;j<arrGate.size();j++){
			Gate gaw=(Gate) arrGate.get(j);
			if(bol.getPosX()==gaw.getPosX() && bol.getPosY()==gaw.getPosY()){
				goal +=1;
			}
		}
	}
	if(goal==balls){
		JOptionPane.showMessageDialog(null, "Congratulations game finish!!");
	}
}
public void restartLevel(){
	
	arrGate.clear();
	arrBall.clear();
	arrWall.clear();
	arrMaps.clear();
	setMap(myfile);
	repaint();
	
}
}

