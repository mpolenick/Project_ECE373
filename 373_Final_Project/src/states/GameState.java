package states;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Entity;
import entities.Player;
import textures.Sprite;

public class GameState implements State{
	
	private ArrayList<Entity> entities;

	@Override
	public void init() {
		entities = new ArrayList<Entity>();
		new Player(new Sprite("TBD"), 100, 100, this);
	}

	@Override
	public void enter() {}

	@Override
	public void tick(StateManager stateManager) {
		for (Entity e : entities)
			e.tick();
	}

	@Override
	public void render(Graphics g) {
		for (Entity e : entities)
			e.render(g);
	}

	@Override
	public void exit() {
		entities.clear();
	}

	@Override
	public String getName() {
		return "Level1";
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

}
