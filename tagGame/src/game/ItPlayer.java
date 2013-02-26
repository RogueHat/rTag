package game;

import java.awt.Color;
import java.awt.Graphics;

public class ItPlayer extends Player {

	private int X=0, Y=0, D=0, boost=0;
	private String name="";
	
	//Constructors.
	public ItPlayer()
	{
		
	}
	
	public ItPlayer(int Xaxis, int Yaxis)
	{
		setX(Xaxis);
		setY(Yaxis);
	}
	
	public ItPlayer(int Xaxis, int Yaxis, String n)
	{
		setX(Xaxis);
		setY(Yaxis);
		name=n;
	}
	
	public ItPlayer(int Xaxis, int Yaxis, int Direction, int i, String n)
	{
		index=i;
		D=Direction;
		setX(Xaxis);
		setY(Yaxis);
		name=n;
		boost=1000;
	}
	
	// these methods return variables.
	public Color getColor()
	{
		return Color.RED;
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
	
	public String getName()
	{
		return name;
	}
	
	/* these methods set variables
	 */
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
	
	public void setBoost(int b)
	{
		boost=b;
	}
	
	public void draw(Graphics window)
	{
		window.setColor(this.getColor());
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
	
	//boosts player
	public void Boost()
	{
		if(boost>=5)
			boost-=5;
			//setSpeed(10);
	}
	public void addBoost()
	{
		if(boost<100) boost++;
		System.out.println(boost);
	}
	
	//toString
	public String toString()
	{
		return "Xaxis = "+X+" Yaxis = "+Y+" Name = "+name+" ItPlayer";
	}
}

