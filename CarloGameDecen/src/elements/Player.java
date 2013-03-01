package elements;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y, side, spd;
	private Color col;

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
	
	public void move(int xSpd, int ySpd){
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
	}
	
	public void draw(Graphics window) {
		window.setColor(col);
		window.fillRect(x, y, side, side);
	}

	public int getSpd() {
		return spd;
	}

	public String toString() {
		return "" + x + " " + y + " " + col.getRGB();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
