package game;

import java.awt.Color;

public class ItPlayer extends Player {

	private int X=0, Y=0, D=0;
	private String name="";
	public ItPlayer()
	{
		
	}
	
	public ItPlayer(int Xaxis, int Yaxis)
	{
		X=Xaxis;
		Y=Yaxis;
	}
	
	public ItPlayer(int Xaxis, int Yaxis, String n)
	{
		X=Xaxis;
		Y=Yaxis;
		name=n;
	}
	
	public ItPlayer(int Xaxis, int Yaxis, int Direction, String n)
	{
		D=Direction;
		X=Xaxis;
		Y=Yaxis;
		name=n;
	}
	
	/*public ItPlayer(Player p)
	{
		p=new ItPlayer(p.getX(), p.getY(), p.getName());
	}*/
	
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
	
	public void setD(int d)
	{
		D=d;
	}
	
	public int getD()
	{
	 return D;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "Xaxis = "+X+" Yaxis = "+Y+" Name = "+name+" ItPlayer";
	}
}

