package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Entity;
import entities.Player;
import graphic_for_game.Game;
import textures.Sprite;
import textures.SpriteSheet;
import textures.Texture;
import world.Tile;

public abstract class GameState implements State{
	
	private ArrayList<Entity> entities;
	private ArrayList<Tile> tiles;
	private String filename;
	@Override
	public void init() {
		
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
		
		try {
		g.drawImage(ImageIO.read(new File("./src/images/"+filename +".png")), 0, 0, 1280, 720,null);// ,0, 0, 1280, 720);
		}catch(IOException e){
			e.printStackTrace();
		}

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
