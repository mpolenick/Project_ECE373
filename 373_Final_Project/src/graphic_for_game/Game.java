package graphic_for_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import input.KeyInput;
import input.MouseInput;
import states.GameState;
import states.MenuState;
import states.ScoreState;
import states.ShopState;
import states.StateManager;
import states.options;
import textures.Sprite;
import textures.SpriteSheet;
import textures.Texture;

public class Game extends Canvas implements Runnable {
	public static final String TITLE = "Shape Runner";
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH /4 *3;
	
	private boolean running;
	
	private Texture texture,t2,t3,t4;
	private SpriteSheet sheet;
	private Sprite sprite;
	private double sX = 350,sY = 300;
	
	//private Menu menu;
	private StateManager stateManager;
	
	public static Game INSTANCE;
	
	public Game()
	{
		//menu = new Menu();
		stateManager = new StateManager();
		stateManager.addState(new MenuState());
		stateManager.addState(new GameState());
		stateManager.addState(new options());
		stateManager.addState(new ScoreState());
		stateManager.addState(new ShopState());
		//sheet = new SpriteSheet(new Texture("test_sheet"),64);
		//sprite = new Sprite(sheet,1,3);
		addKeyListener(new KeyInput());
		MouseInput m1 = new MouseInput();
		addMouseListener(m1);
		addMouseMotionListener(m1);
		
		INSTANCE = this;
	}
	
	private void tick() {
		if(KeyInput.isDown(KeyEvent.VK_SPACE))
		{
			sY -= 2;
		}
		if(KeyInput.wasPressed(KeyEvent.VK_ENTER))
		{
			sY = 300;
			System.out.println("was pressed");
		}
		if(MouseInput.isDown(MouseEvent.BUTTON1))
		{
			//System.out.println("left is pressed");
			
		}
		if(MouseInput.wasPressed(MouseEvent.BUTTON3))
		{
			System.out.println("right is pressed");
		}
		if(KeyInput.isDown(KeyEvent.VK_ESCAPE))		//closes the program if the esc is pressed
		{
			this.INSTANCE.stop();
		}
		stateManager.tick();
	}
	
	private void render()
	{
		BufferStrategy bufferStrat = getBufferStrategy();
		if(bufferStrat == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufferStrat.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(-6,-28);//hardcoded
		//////////////////////////////////////////
		//background
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);
		//sprite.render(g, 350, 400);
		stateManager.render(g2d);
		
		///////////////////////////////////////////
		g.dispose();
		bufferStrat.show();
		
	}
	protected void start()
	{
		if(running)return;
		running = true;
		new Thread(this,"ShapeRunnerMain").start();
		
		
	}
	public void stop() 
	{
		if(!running)return;
		running = false;
		System.exit(0);
	}
	public void run() 
	{
		requestFocus();
		double target = 60.0;
		double nsPerTick = 1000000000.0/target;
		double unprocessed = 0.0;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		
		
		while(running) 
		{
			long now = System.nanoTime();
			unprocessed = unprocessed + (now - lastTime)/nsPerTick;
			lastTime = now;
			
			if(unprocessed >= 1.0)
			{
				tick();
				KeyInput.update();
				MouseInput.update();
				unprocessed--;
				tps++;
				canRender = true;
			}
			else
			{
				canRender = false;
				
			}
			
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(canRender)
			{
				render();
				fps++;
			}
			
			if(System.currentTimeMillis() - 1000  > timer)
			{
				timer = timer + 1000;
				System.out.printf("FPS: %d || TPS: %d\n",fps,tps);
				fps = 0;
				tps = 0;
			}
			
			
			
			
			
		}
		System.exit(0);
	}
	

	
}
