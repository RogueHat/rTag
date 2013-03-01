package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private static int indexes=-1;
	protected int index=0;
	private int X=0, Y=0, D=0, timeIt=0, spd=5;
	private Color col=Color.BLUE;
	private String name="";
	
		//Constructors.
		public Player()
		{
			D=0;
		}

		public Player(int Xaxis, int Yaxis)
		{
			setX(Xaxis);
			setY(Yaxis);
		}
		
		public Player(String line[]){
			this();
			set(line);
		}
		
		public Player(int xPos, int yPos, Color color){
			this();
			X = xPos;
			Y = yPos;
			col = color;
		}
		
		public Player(int Xaxis, int Yaxis, String n)
		{
			indexes++;
			index=indexes;
			setX(Xaxis);
			setY(Yaxis);
			name=n;
		}
		
		public Player(int Xaxis, int Yaxis, int Direction,int i, String n)
		{
			index=i;
			D=Direction;
			setX(Xaxis);
			setY(Yaxis);
			name=n;
		}
		
		public void set(int xPos, int yPos, int color) {
			X = xPos;
			Y = yPos;
			col = new Color(color);
		}
		
		public void set(String xPos, String yPos, String color)
		{
			set(Integer.parseInt(xPos),Integer.parseInt(yPos),Integer.parseInt(color));
		}
		
		public void set(String line[]){
			set(line[1],line[2],line[3]);
		}

		//changes player between it and not it.
		public Player toPlayer(Player p)
		{
			p = new Player(getX(), getY(), getD(), p.index, getName());
			return p;
		}
		
		public Player toItPlayer(Player p)
		{
			p = new ItPlayer(getX(), getY(), getD(), p.index, getName());
			return p;
		}
		
		// these methods return variables.
		public Color getColor()
		{
			return col;
		}
		
		public int getX()
		{
		 return X;
		}
		
		public int getY()
		{
		 return Y;
		}
		
		public int getD()
		{
		 return D;
		}
		
		public int getSpeed()
		{
			return spd;
		}
		
		public String getName()
		{
			return name;
		}
		
		// these methods set variables
		public void setX(int x)
		{
			X=x;
		}
		
		public void setY(int y)
		{
			Y=y;
		}
		
		public void setD(int d)
		{
			D=d;
		}
		
		public void setSpeed(int s)
		{
			spd=s;
		}
		
		public void draw(Graphics window)
		{
			window.setColor(getColor());
			window.fillRect(getX(),getY(),10,10);
		}
		
		//moves player
		public void moveUp(int n){
			Y-=n;
		}
		public void moveDown(int n){
			Y+=n;
		}
		public void moveRight(int n){
			X+=n;
		}	
		public void moveLeft(int n){
			X-=n;
		}
		
		//toString
		public String toString()
		{
			return "" + X + " " + Y + " "+col;
		}
}

