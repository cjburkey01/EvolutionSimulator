package com.cjburkey.evosim.component;

import com.cjburkey.evosim.world.Transform;
import com.cjburkey.evosim.world.WorldObject;

public abstract class Component {
	
	public final WorldObject worldObject = null;
	public final Transform transform = null;
	
	public void onAdd() {
	}
	
	public void onTick(double delta) {
	}
	
	public void onRender(double delta) {
	}
	
	public void onRemove() {
	}
	
	public final String getName() {
		return getClass().getSimpleName();
	}
	
	public final String toString() {
		return "Component " + getName();
	}
	
}