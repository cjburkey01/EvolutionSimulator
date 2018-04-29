package com.cjburkey.evosim;

import com.cjburkey.evosim.component.BoxRenderer;
import com.cjburkey.evosim.component.PlaneRender;

public class EvoSimHandler {
	
	public void init() {
		EvoSim.getWorld().addObject().addComponent(BoxRenderer.class);
		EvoSim.getWorld().addObject().addComponent(PlaneRender.class);
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