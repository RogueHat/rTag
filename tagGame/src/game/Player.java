package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private static int indexes=-1;
	protected int index=0;
	private int X=0, Y=0, D=0, timeIt=0, spd=5;
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
			return Color.BLUE;
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
		public void moveX(int n){
			X+=n;
		}
		public void moveY(int n){
			Y+=n;
		}
		
		//toString
		public String toString()
		{
			return "Xaxis = "+X+" Yaxis = "+Y+" Name ="+name;
		}
}

