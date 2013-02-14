package game;

import javax.swing.JFrame;
import javax.swing.JFrame;

public class Main extends JFrame
{

	public static void main(String args[])
	{
	Player P = new Player(23,34,"person");
	System.out.println(P);
	
	P=P.toItPlayer(P);
	System.out.println(P);
	
	P=P.toPlayer(P);
	System.out.println(P);
	
	Main run = new Main();
	}
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Main()
	{
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH,HEIGHT);

		getContentPane().add(new DrawPlayer());

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

