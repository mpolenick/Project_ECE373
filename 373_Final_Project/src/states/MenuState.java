package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphic_for_game.Game;
import input.KeyInput;
import input.MouseInput;
import rendering.textures.ui.Button;
import utilities.Fonts;

public class MenuState  implements State
{
	private Button[] options;
	private int currentSel; //either 0,1,2,3
	
	@Override
	public void init()
	{
		options = new Button[4];
		options[0] = new Button("Play", 200 + 0 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[1] = new Button("Shop", 200 + 1 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[2] = new Button("Options", 200 + 2 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.GREEN,Color.WHITE);
		options[3] = new Button("Exit", 200 + 3 * 80,new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
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
			System.out.println("play");
			stateManager.setState("game1");
			break;
		case 1:
			System.out.println("Shop");
			stateManager.setState("shop");
			break;
		case 2:
			System.out.println("Options");
			stateManager.setState("options");
			break;
		case 3:
			System.out.println("Exit");
			Game.INSTANCE.stop();
			break;
		}
	}
	
	public void render(Graphics2D g)
	{	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	    try {
		g.drawImage(ImageIO.read(new File("./src/images/mainmenu.jpg")), 0, 0, 1280, 720,null);// ,0, 0, 1280, 720);
		}catch(IOException e){
			e.printStackTrace();
	}

		try {
		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("./src/font/8-BIT WONDER.ttf")).deriveFont(60f);
		    Fonts.drawString(g,customFont,Color.ORANGE, Game.TITLE,100);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		

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
		return "menu";
	}
	
	public boolean nextState() {
		// TODO Auto-generated method stub
		return false;
	}
	
}