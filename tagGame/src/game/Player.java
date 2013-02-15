package game;

import java.awt.Color;

public class Player {

	private int X=0, Y=0, D=0, timeIt=0;
	private String name="";
		public Player()
		{
			D=0;
		}

		public Player(int Xaxis, int Yaxis)
		{
			X=Xaxis;
			Y=Yaxis;
		}
		
		public Player(int Xaxis, int Yaxis, String n)
		{
			X=Xaxis;
			Y=Yaxis;
			name=n;
		}
		
		public Player(int Xaxis, int Yaxis, int Direction, String n)
		{
			D=Direction;
			X=Xaxis;
			Y=Yaxis;
			name=n;
		}
		
		/*public Player(Player p)
		{
			p = new Player(p.getX(), p.getY(), p.getName());
		}*/
		
		public Player toPlayer(Player p)
		{
			p = new Player(p.getX(), p.getY(), p.getD(), p.getName());
			return p;
		}
		
		public Player toItPlayer(Player p)
		{
			p = new ItPlayer(p.getX(), p.getY(), p.getD(), p.getName());
			return p;
		}
		
		public Color getColor()
		{
			return Color.BLACK;
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
			return "Xaxis = "+X+" Yaxis = "+Y+" Name ="+name;
		}
}

