package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x,y,side;
	private Color col;
	public Player(){
		side=100;
		x=200;
		y=200;
		col=Color.black;
	}
	public void setX(int n){
		x+=n;
	}
	public void setY(int n){
		y+=n;
	}
	public String toString(){
		return " "+x+" "+y;
	}
	public void draw(Graphics window) {
		window.setColor(col);
		window.fillRect(x, y, side, side);
	}
}
