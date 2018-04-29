package com.cjburkey.evosim.window;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class CanvasPane extends Pane {
	
	private final Canvas canvas;
	
	public CanvasPane(double width, double height) {
		canvas = new Canvas(width, height);
		getChildren().add(canvas);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	protected void layoutChildren() {
		super.layoutChildren();
		final double x = snappedLeftInset();
		final double y = snappedTopInset();
		final double w = snapSize(getWidth()) - x - snappedRightInset();
		final double h = snapSize(getHeight()) - y - snappedBottomInset();
		canvas.setLayoutX(x);
		canvas.setLayoutY(y);
		canvas.setWidth(w);
		canvas.setHeight(h);
	}
	
}