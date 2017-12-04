package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import graphic_for_game.Game;
import input.KeyInput;
import input.MouseInput;
import rendering.textures.ui.Button;
import utilities.Fonts;

public class options implements State {

	private Button[] options;
	private int currentSel; //either 0,1,2
	
	@Override
	public void init()
	{
		options = new Button[3];
		options[0] = new Button("Resolution", 200 + 0 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[1] = new Button("Audio", 200 + 1 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[2] = new Button("Back", 200 + 2 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
	}
	
	@Override
	public void enter() {}
	
	@Override
	public void tick(StateManager stateManager) 
	{
		boolean clicked = false;		
		if(KeyInput.wasPressed(KeyEvent.VK_UP) || KeyInput.wasPressed(KeyEvent.VK_W))
		{
			currentSel--;
			if(currentSel < 0)
			{
				currentSel = options.length - 1;
			}
		}
		if(KeyInput.wasPressed(KeyEvent.VK_DOWN) || KeyInput.wasPressed(KeyEvent.VK_S))
		{
			currentSel++;
			if(currentSel >= options.length)
			{
				currentSel = 0;
			}
			
		}
		for(int i = 0; i < options.length;i++)
		{
			if(options[i].intersects(new Rectangle(MouseInput.getX(),MouseInput.getY(),1,1)))
			{
				currentSel = i;
				clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
			}
		}
		if(clicked || KeyInput.wasPressed(KeyEvent.VK_ENTER))
		{
			select(stateManager);
		}
	}
	
	private void select(StateManager stateManager) {
		switch(currentSel) {
		case 0:
			System.out.println("dont work");
			//stateManager.setState("game");
			break;
		case 1:
			System.out.println("dont work");
			break;
		case 2:
			System.out.println("Back");
			stateManager.setState("menu");
			//Game.INSTANCE.stop();
			break;
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		Fonts.drawString(g,new Font("Arial",Font.BOLD,72) ,Color.BLUE, "options",80);

		for(int i = 0;i < options.length;i++)
		{
			if(i == currentSel)
			{
				options[i].setSelected(true);
				
			}
			else
			{
				options[i].setSelected(false);
			}
			options[i].render(g);
		}
	}
	@Override
	public void exit() {}
	
	@Override
	public String getName() {
		return "options";
	}
	
	public boolean nextState() {
		// TODO Auto-generated method stub
		return false;
	}
}
	
