package graphic_for_game;

import javax.swing.JFrame;

public class ShapeRunner {
	public static void main(String[] args) 
	{
		Game game = new Game();
		JFrame frame = new JFrame(Game.TITLE);
		frame.add(game);
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocation(null);
		frame.setVisible(true);
		frame.requestFocus();
		game.start();
	}
}
