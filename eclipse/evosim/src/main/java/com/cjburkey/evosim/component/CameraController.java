package com.cjburkey.evosim.component;

import com.cjburkey.evosim.Input;
import com.cjburkey.evosim.math.MathUtil;
import com.cjburkey.evosim.math.Vector2;
import javafx.scene.input.KeyCode;

public class CameraController extends Component {
	
	public float speed = 15.0f;
	public float scrollSpeed = 5.0f;
	public float scale = 1.0f;
	public float minScale = 25f;
	public float maxScale = 200f;
	
	private final Vector2 vel = new Vector2();
	
	public void onTick(double delta) {
		vel.set(null);
		if (Input.isKeyDown(KeyCode.S) || Input.isKeyDown(KeyCode.DOWN)) {
			vel.setY(vel.getY() + 1.0f);
		}
		if (Input.isKeyDown(KeyCode.W) || Input.isKeyDown(KeyCode.UP)) {
			vel.setY(vel.getY() - 1.0f);
		}
		if (Input.isKeyDown(KeyCode.D) || Input.isKeyDown(KeyCode.RIGHT)) {
			vel.setX(vel.getX() + 1.0f);
		}
		if (Input.isKeyDown(KeyCode.A) || Input.isKeyDown(KeyCode.LEFT)) {
			vel.setX(vel.getX() - 1.0f);
		}
		if (!vel.isEmpty()) {
			vel.normalize();
		}
		vel.mul(speed * (float) delta);
		transform.position.add(vel);
		
		scale += Input.getScroll() * scrollSpeed * scale / 25.0f * delta;
		scale = MathUtil.clamp(scale, minScale, maxScale);
	}
	
}