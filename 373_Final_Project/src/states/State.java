package states;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface State {
	public void init();
	public void enter();	//enter state
	public void tick(StateManager stateManager);
	public void render(Graphics2D g);
	public void exit();		//exit state
	public String getName();
//	public boolean nextState();
}
