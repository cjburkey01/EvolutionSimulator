package com.cjburkey.evosim.world;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.cjburkey.evosim.Debug;
import com.cjburkey.evosim.component.Component;

public class WorldObject {
	
	public final UUID uuid;
	public final Transform transform;
	
	private final List<Component> components = new ArrayList<>();
	private final List<Component> toAdd = new ArrayList<>();
	private final List<Component> toRemove = new ArrayList<>();
	
	public WorldObject() {
		uuid = UUID.randomUUID();
		transform = addComponent(Transform.class);
	}
	
	public <T extends Component> T addComponent(Class<T> component) {
		try {
			T comp = component.newInstance();
			if (comp == null) {
				throw new Exception("Failed to create an instance of the component");
			}
			Field worldObjectField = component.getField("worldObject");
			Field transformField = component.getField("transform");
			if (worldObjectField == null || transformField == null) {
				throw new Exception("worldObjectField and/or transformField were/was null");
			}
			worldObjectField.setAccessible(true);
			worldObjectField.set(comp, this);
			transformField.setAccessible(true);
			transformField.set(comp, transform);
			toAdd.add(comp);
			return comp;
		} catch (Exception e) {
			Debug.logError("Unable to add component type: " + component.getSimpleName() + " | " + e.getMessage());
		}
		return null;
	}
	
	public <T extends Component> T removeComponent(Class<T> component) {
		for (Component comp : components) {
			if (comp.getClass().equals(component)) {
				removeComponent(comp);
				return component.cast(comp);
			}
		}
		return null;
	}
	
	public void removeComponent(Component comp) {
		toRemove.add(comp);
	}
	
	public void onTick(double delta) {
		doComponentUpdates();
		for (Component comp : components) {
			comp.onTick(delta);
		}
	}
	
	public void onRender(double delta) {
		for (Component comp : components) {
			comp.onRender(delta);
		}
	}
	
	public void destroy() {
		toAdd.clear();
		toRemove.clear();
		for (Component comp : components) {
			removeComponent(comp);
		}
		doComponentUpdates();
	}
	
	private void doComponentUpdates() {
		for (Component comp : toAdd) {
			components.add(comp);
			comp.onAdd();
		}
		toAdd.clear();
		for (Component comp : toRemove) {
			comp.onRemove();
			components.remove(comp);
		}
		toRemove.clear();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		WorldObject other = (WorldObject) obj;
		if (uuid == null) {
			if (other.uuid != null) {
				return false;
			}
		} else if (!uuid.equals(other.uuid)) {
			return false;
		}
		return true;
	}
	
}