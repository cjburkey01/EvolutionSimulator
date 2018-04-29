package com.cjburkey.evosim;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public final class Input {
	
	private static final Map<KeyCode, Boolean> keys = new HashMap<>();
	private static float scroll;
	
	public static void init(Node root) {
		root.setOnKeyPressed(e -> {
			keys.put(e.getCode(), true);
		});
		root.setOnKeyReleased(e -> {
			keys.remove(e.getCode());
		});
		root.setOnScroll(e -> {
			scroll = (float) e.getDeltaY();
		});
	}
	
	public static void lateUpdate() {
		for (KeyCode key : keys.keySet()) {
			keys.put(key, false);
		}
		scroll = 0.0f;
	}
	
	/**
	 * Returns whether this key is currently pressed
	 */
	public static boolean isKeyDown(KeyCode key) {
		return keys.containsKey(key);
	}
	
	/**
	 * Return whether the key was just pressed down this frame
	 */
	public static boolean isKeyFirstPressed(KeyCode key) {
		return keys.containsKey(key) && keys.get(key);
	}
	
	public static float getScroll() {
		return scroll;
	}
	
}