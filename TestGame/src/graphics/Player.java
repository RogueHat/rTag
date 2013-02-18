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
	public Player(String []line){
		setAll(line);
	}
	public void moveX(int n){
		x+=n;
	}
	public void moveY(int n){
		y+=n;
	}
	public void setAll(String []line){
		x=Integer.parseInt(line[1]);
		y=Integer.parseInt(line[2]);
		col= new Color(Integer.parseInt(line[3]));
	}
	public String toString(){
		return " "+x+" "+y+" "+col.getRGB();
	}
	public void draw(Graphics window) {
		window.setColor(col);
		window.fillRect(x, y, side, side);
	}
	
	public static void main(String[]args){
		System.out.println(new Player());
	}
	
}
