package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import graphic_for_game.ShapeRunner;
import input.KeyInput;
import input.MouseInput;
import rendering.textures.ui.Button;

public class Menu 
{
	private final Button[] options;
	private int currentSel; //either 0,1,2
	
	public Menu()
	{
		options = new Button[3];
		options[0] = new Button("Play", 200 + 0 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[1] = new Button("Options", 200 + 1 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[2] = new Button("Exit", 200 + 2 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
	}
	
	public void tick() 
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
			select();
		}
		
		if(clicked)
		{
			select();
		}
	}
	
	private void select() {
		switch(currentSel) {
		case 0:
			System.out.println("play");
			break;
		case 1:
			System.out.println("Options");
			break;
		case 2:
			System.out.println("Exit");
			ShapeRunner.INSTANCE.stop();
			break;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ShapeRunner.WIDTH, ShapeRunner.HEIGHT);
		Fonts.drawString(g,new Font("Arial",Font.BOLD,72) ,Color.BLUE, ShapeRunner.TITLE,80);

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
	
}
