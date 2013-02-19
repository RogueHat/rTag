package game;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFrame;

public class Main extends JFrame
{
	public static ArrayList<Player> players=new ArrayList<Player>();
	
	public static void main(String args[])
	{
	Player P = new Player(23,34,"person");
	players.add(P);
	System.out.println(players.get(0));
	
	P=P.toItPlayer(P);
	System.out.println(P);
	
	P=P.toPlayer(P);
	System.out.println(P);
	
	Main run = new Main();
	}
	
	public static ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Main()
	{
		super("Tag");

		setSize(WIDTH,HEIGHT);

		getContentPane().add(new DrawPlayer());

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

