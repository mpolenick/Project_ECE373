package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import entities.Entity;
import entities.Player;
import graphic_for_game.Game;
import textures.Sprite;
import textures.SpriteSheet;
import textures.Texture;
import world.Tile;

public class GameState implements State{
	
	private ArrayList<Entity> entities;
	private ArrayList<Tile> tiles;
	@Override
	public void init() {
		tiles = new ArrayList<Tile>();
		entities = new ArrayList<Entity>();
		new Player(new Sprite("octagonred"), 100, 100, this);
		float x = 0;
		float y = Game.HEIGHT - 64;
		
		
		tiles.add(new Tile(100, 480 - 64 - 64, new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		tiles.add(new Tile(220, 480-(64*3), new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		tiles.add(new Tile(340, 480-(64*4), new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		//tiles.add(new Tile(400, 50, new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		//tiles.add(new Tile(300, 300, new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		//tiles.add(new Tile(640 - 64, 300, new Sprite(new SpriteSheet(new Texture("terrain"), 64), 1, 1)));
		 
		for (int i =0; i < 10;i++) {
			tiles.add(new Tile(x,y,new Sprite(new SpriteSheet(new Texture("terrain"),64),1,1)));
			x+=70;
		}
	}

	@Override
	public void enter() {}

	@Override
	public void tick(StateManager stateManager) {
		for (Entity e : entities) {
			e.tick();
		}
	}
	public ArrayList<Tile> getTiles(){
		return tiles;
	}
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		for (Entity e : entities) {
			e.render(g);
		}
		for (Tile t : tiles) {
			t.render(g);
		}
	}

	@Override
	public void exit() {
		entities.clear();
	}

	@Override
	public String getName() {
		return "game";
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

}
