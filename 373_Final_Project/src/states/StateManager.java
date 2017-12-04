package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class StateManager {

	private Map<String, State> map;
	private State curState;
	
	public StateManager() {
		map = new HashMap<String, State>();
	}
	
	public void addState(State state) {
		map.put(state.getName().toUpperCase(), state);
		state.init();
		if(curState == null) {
			state.enter();
			curState = state;
		}
	}
	
	public void setState(String name) {
		State state = map.get(name.toUpperCase());
		if(state == null) {
			System.err.println("State <"+name+"> not found");
			return;
		}
		curState.exit();
		state.enter();
		curState = state;
	}
	
	public void tick() {
		curState.tick(this);
	}
	
	public void render(Graphics2D g) {
		curState.render(g);
	}
	
	public State getState() {
		return curState;
	}
	
	public void nextState() {
		String[] barf = curState.getName().split("game");
		Integer turkey = Integer.parseInt(barf[1]) + 1 ;
		curState = map.get( "GAME" + turkey.toString().toUpperCase());   // name.toUpperCase())
	}
}
