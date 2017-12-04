package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import graphic_for_game.Game;
import graphic_for_game.ShapeRunner;
import input.KeyInput;
import input.MouseInput;
import rendering.textures.ui.Button;
import storeObjects.Lives;
import textures.Sprite;
import textures.SpriteSheet;
import textures.Texture;
import utilities.Fonts;
import world.Tile;

public class ShopState implements State {

	private Button[] options;
	private int currentSel; //either 0,1,2
	
	@Override
	public void init()
	{
		options = new Button[1];
		options[0] = new Button("back", 200 + 3 * 80,new Font("Arial",Font.PLAIN,28),new Font("Arial",Font.BOLD,28),
				Color.GREEN,Color.WHITE);
		
	}
	
	@Override
	public void enter() {}
	
	@Override
	public void tick(StateManager stateManager) 
	{
		boolean clicked = false;		
//		if(KeyInput.wasPressed(KeyEvent.VK_UP) || KeyInput.wasPressed(KeyEvent.VK_W))
//		{
//			currentSel--;
//			if(currentSel < 0)
//			{
//				currentSel = options.length - 1;
//			}
//		}
//		if(KeyInput.wasPressed(KeyEvent.VK_DOWN) || KeyInput.wasPressed(KeyEvent.VK_S))
//		{
//			currentSel++;
//			if(currentSel >= options.length)
//			{
//				currentSel = 0;
//			}
//			
//		}
//		for(int i = 0; i < options.length;i++)
//		{
		if(options[0].intersects(new Rectangle(MouseInput.getX(),MouseInput.getY(),1,1)))
		{
			currentSel = 0;
			clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
		}
//		}
		if(clicked || KeyInput.wasPressed(KeyEvent.VK_ENTER))
		{
			select(stateManager);
		}
		
	}
	
	private void select(StateManager stateManager) {
		switch(currentSel) {
		case 0:
			System.out.println("menu");
			stateManager.setState("menu");
			break;
		case 1:
			break;
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH,Game.HEIGHT);
		Fonts.drawString(g,new Font("Arial",Font.BOLD,72) ,Color.BLUE, "Shop",80);
		
		
		Fonts.drawString(g,new Font("Arial",Font.BOLD,28) ,Color.BLUE, "Colors: ",50,200);
		Fonts.drawString(g,new Font("Arial",Font.BOLD,28) ,Color.BLUE, "Power Ups: ",200,200);
		Fonts.drawString(g,new Font("Arial",Font.BOLD,28) ,Color.BLUE, "Lives: ",400,200);
		Tile lives = new Tile(420,250,new Sprite("life"));
		Tile colorShape = new Tile(80,250,new Sprite("octagonblue"));
		Tile powerUps = new Tile(220,250,new Sprite("lightning"));
		lives.render(g);
		colorShape.render(g);
		powerUps.render(g);

//		for(int i = 0;i < options.length;i++)
//		{
//			if(i == currentSel)
//			{
//				options[i].setSelected(true);
//				
//			}
//			else
//			{
//				options[i].setSelected(false);
//			}
			options[0].render(g);
//		}
	}
	@Override
	public void exit() {}
	
	@Override
	public String getName() {
		return "shop";
	}
	
}
