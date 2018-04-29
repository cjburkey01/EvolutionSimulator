package com.cjburkey.evosim;

import com.cjburkey.evosim.component.BoxRenderer;
import com.cjburkey.evosim.component.PlaneRender;
import com.cjburkey.evosim.world.WorldObject;
import javafx.scene.paint.Color;

public class EvoSimHandler {
	
	private WorldObject testBox;
	private WorldObject ground;
	
	public void init() {
		testBox = EvoSim.getWorld().addObject();
		testBox.addComponent(BoxRenderer.class);
		testBox.transform.position.set(0.0f, -2.0f);
		
		ground = EvoSim.getWorld().addObject();
		PlaneRender plane = ground.addComponent(PlaneRender.class);
		plane.color = new Color(75.0f / 255.0f, 226.0f / 255.0f, 188.0f / 255.0f, 1.0f);
	}
	
	public void preTick(double delta) {
		
	}
	
	public void tick(double delta) {
		
	}
	
	public void postTick(double delta) {
		
	}
	
	public void preRender(double delta) {
		
	}
	
	public void render(double delta) {
		
	}
	
	public void postRender(double delta) {
		
	}
	
	public void exit() {
		
	}
	
}