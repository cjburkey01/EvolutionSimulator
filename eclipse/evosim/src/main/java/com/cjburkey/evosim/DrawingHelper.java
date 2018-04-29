package com.cjburkey.evosim;

import com.cjburkey.evosim.math.Vector2;
import com.cjburkey.evosim.window.CanvasPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class DrawingHelper {
	
	private static GraphicsContext canvas;
	
	public static void setCanvas(CanvasPane canvas) {
		DrawingHelper.canvas = canvas.getCanvas().getGraphicsContext2D();
	}
	
	public static void clearCanvas(Color clearColor) {
		canvas.clearRect(0, 0, canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight());
		fillRect(0.0f, 0.0f, (float) canvas.getCanvas().getWidth(), (float) canvas.getCanvas().getHeight(), clearColor, false);
	}
	
	public static void fillRect(float x, float y, float width, float height, Color color, boolean transform) {
		canvas.setFill(color);
		if (transform) {
			transformToCamera();
		}
		canvas.fillRect(x, y, width, height);
		if (transform) {
			resetTransform();
		}
		
	}
	
	public static void fillRect(float x, float y, float width, float height, Color color) {
		fillRect(x, y, width, height, color, true);
	}
	
	public static void fillRect(Vector2 pos, Vector2 size, Color color, boolean transform) {
		fillRect(pos.getX(), pos.getY(), size.getX(), size.getY(), color, transform);
	}
	
	public static void fillRect(Vector2 pos, Vector2 size, Color color) {
		fillRect(pos.getX(), pos.getY(), size.getX(), size.getY(), color, true);
	}
	
	public static void transformToCamera() {
		Vector2 tcp = getTransformedCameraPosition();
		canvas.translate(tcp.getX(), tcp.getY());
		canvas.scale(EvoSim.getCamera().scale, EvoSim.getCamera().scale);
	}
	
	public static void resetTransform() {
		canvas.scale(1.0d / EvoSim.getCamera().scale, 1.0d / EvoSim.getCamera().scale);
		Vector2 tcp = getTransformedCameraPosition();
		canvas.translate(-tcp.getX(), -tcp.getY());
	}
	
	public static float getTransformedY() {
		transformToCamera();
		float f = (float) canvas.getTransform().getTy();
		resetTransform();
		return f;
	}
	
	public static Vector2 getTransformedCameraPosition() {
		Vector2 out = new Vector2((float) canvas.getCanvas().getWidth() / 2.0f, (float) canvas.getCanvas().getHeight() / 2.0f);
		out.add(Vector2.mul(EvoSim.getCamera().transform.position, -EvoSim.getCamera().scale));
		return out;
	}
	
	public static Vector2 getSize() {
		return new Vector2((float) canvas.getCanvas().getWidth(), (float) canvas.getCanvas().getHeight());
	}
	
}