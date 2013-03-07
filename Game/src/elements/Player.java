package elements;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y, side, spd, xSpd, ySpd, nextX, nextY;
	private Color col;
	private boolean itStatus =false;

	public Player() {
		x = y = 200;
		side = 10;
		col = Color.black;
		spd = 5;
	}

	public Player(String line[]){
		this();
		set(line);
	}
	
	public Player(int xPos, int yPos, Color color){
		this();
		x = xPos;
		y = yPos;
		col = color;
	}
	
	public void move(int xS, int yS){
		xSpd = xS;
		ySpd = yS;
		x=x+xSpd;
		y=y+ySpd;
	}

	public void set(int xPos, int yPos, int color) {
		x = xPos;
		y = yPos;
		col = new Color(color);
	}
	public void set(String xPos, String yPos, String color) {
		set(Integer.parseInt(xPos),Integer.parseInt(yPos),Integer.parseInt(color));
	}
	public void set(String line[]){
		set(line[1],line[2],line[3]);
		itStatus = new Boolean(line[4]);
	}
	
	public void draw(Graphics window) {
		window.setColor(col);
		window.fillRect(x, y, side, side);
	}

	public int getSpd() {
		return spd;
	}
	public boolean isIt(){
		return itStatus;
	}
	public void changeItStatus(){
		itStatus = !itStatus;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getS(){
		return side;
	}
	
	public Color getCol(){
		if (isIt()) return Color.black;
		return col;
	}
	
	
	public boolean collidedWith(Player a){
		nextX = x + xSpd;
		nextY = y + ySpd;
		return xCheck(a) && yCheck(a);
	}
	private boolean xCheck(Player a){
		return ((a.getX() >= nextX && a.getX() <= nextX+side) || 
				(a.getX()+a.getS()<= nextX+side && a.getX()+a.getS()>nextX));
	}
	private boolean yCheck(Player a){
		return ((a.getY() >= nextY && a.getY() <= nextY+side) || 
				(a.getY()+a.getS()<= nextY+side && a.getY()+a.getS()>nextY));
	}

	public String toString() {
		return "" + x + " " + y + " " + getCol().getRGB() + " " + isIt();
	}

}
