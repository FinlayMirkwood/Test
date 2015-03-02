package com.burningbushgames.test;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWindow extends BasicGameState {
	
	private Rectangle background;
	private Shape rectangle;
	private Image level;
	private float scale;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		background = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		rectangle = new Polygon(new float[] {288,427, 253,431, 253,326, 290,362, 290,427, 392,366, 434,238, 359,237, 292,238, 293,154, 258,152, 361,238,});
		rectangle.setCenterX(gc.getWidth()*.5F);
		rectangle.setCenterY(gc.getHeight()*.5F);
		level = new Image("res/Circular-Level.gif");
		scale = (gc.getWidth()/2F)/level.getWidth();
		level = level.getScaledCopy(scale);
		System.out.println(scale);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.setColor(Color.white);
		g.fill(background);
		g.setColor(Color.orange);
		g.fill(rectangle);
		g.setColor(Color.red);
		g.draw(rectangle);
		
		level.drawCentered(gc.getWidth()/2, gc.getHeight()/2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		level.rotate((float) (.09 * delta));
		
	}

	@Override
	public int getID() {
		return 0;
	}


}
