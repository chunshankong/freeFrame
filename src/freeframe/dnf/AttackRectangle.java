package freeframe.dnf;

import java.awt.Color;
import java.awt.Graphics2D;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.SceneFacade;

public class AttackRectangle extends AbstractGameObject implements ContactListener{

	public AttackRectangle(int x, int y, int width, int height,
			SceneFacade sceneFacade ) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Color color = g2d.getColor();
		
		g2d.setColor(Color.RED);
		g2d.drawRect(x, y, width, height);
		
		g2d.setColor(color);
	}
	public void setbounds(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
			 

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginContact(ContactListener target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endContact(ContactListener target) {
		// TODO Auto-generated method stub
		
	}

}
