package com.burningbushgames.test;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWindow extends BasicGameState {
	
	private Rectangle background;
	private Shape attachedBox;
	private Shape floatingBox;
	private Shape levelHolder;
	private Shape ground;
	private Image level;
	private float scale;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		background = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		
		level = new Image("res/Circular-Level.gif");
		scale = (gc.getWidth()/2F)/level.getWidth();
		level = level.getScaledCopy(scale);
		System.out.println(scale);
		//Hi
		levelHolder = new Polygon(new float[] {0,0, level.getWidth(),0, level.getWidth(),level.getHeight(), 0,level.getHeight()});
		levelHolder.setCenterX(gc.getWidth()/2);
		levelHolder.setCenterY(gc.getHeight()/2);
		
		attachedBox = new Polygon(new float[] {250*scale,358*scale, 291*scale,358*scale, 290*scale,428*scale, 250*scale,431*scale,});
		attachedBox.setX(levelHolder.getX() + attachedBox.getX());
		attachedBox.setY(levelHolder.getY() + attachedBox.getY());
		
		floatingBox = new Polygon(new float[] {290*scale,149*scale, 361*scale,149*scale, 361*scale,240*scale, 290*scale,240*scale});
		floatingBox.setX(levelHolder.getX() + floatingBox.getX());
		floatingBox.setY(levelHolder.getY() + floatingBox.getY());
		
		ground = new Circle(gc.getWidth()/2, gc.getHeight()/2, (level.getWidth() - (140 * scale))/2);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.setColor(Color.white);
		g.fill(background);
		g.setColor(Color.orange);
		g.fill(attachedBox);
		g.fill(floatingBox);
		g.setColor(Color.red);
		g.draw(attachedBox);
		g.draw(floatingBox);
		g.draw(levelHolder);
		g.setColor(Color.pink);
		g.draw(ground);
		
		level.drawCentered(gc.getWidth()/2, gc.getHeight()/2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		level.rotate((float) (.09 * delta));
		levelHolder = levelHolder.transform(Transform.createRotateTransform((float) Math.toRadians(.09 * delta), gc.getWidth()/2, gc.getHeight()/2));
		attachedBox = attachedBox.transform(Transform.createRotateTransform((float) Math.toRadians(.09 * delta), gc.getWidth()/2, gc.getHeight()/2));
		floatingBox = floatingBox.transform(Transform.createRotateTransform((float) Math.toRadians(.09 * delta), gc.getWidth()/2, gc.getHeight()/2));
		ground = ground.transform(Transform.createRotateTransform((float) Math.toRadians(.09 * delta), gc.getWidth()/2, gc.getHeight()/2));
	}

	@Override
	public int getID() {
		return 0;
	}


}
