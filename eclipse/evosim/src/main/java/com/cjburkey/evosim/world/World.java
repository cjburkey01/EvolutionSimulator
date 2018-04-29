package com.cjburkey.evosim.world;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	private final List<WorldObject> objects = new ArrayList<>();
	private final List<WorldObject> toAdd = new ArrayList<>();
	private final List<WorldObject> toRemove = new ArrayList<>();
	
	public WorldObject addObject() {
		WorldObject obj = new WorldObject();
		toAdd.add(obj);
		return obj;
	}
	
	public void tick(double delta) {
		doObjectUpdates();
		for (WorldObject obj : objects) {
			obj.onTick(delta);
		}
	}
	
	public void render(double delta) {
		for (WorldObject obj : objects) {
			obj.onRender(delta);
		}
	}
	
	public void destroy(WorldObject obj) {
		if (objects.contains(obj)) {
			toRemove.add(obj);
		}
	}
	
	private void doObjectUpdates() {
		for (WorldObject obj : toAdd) {
			objects.add(obj);
		}
		toAdd.clear();
		for (WorldObject obj : toRemove) {
			obj.destroy();
			objects.remove(obj);
		}
		toRemove.clear();
	}
	
}