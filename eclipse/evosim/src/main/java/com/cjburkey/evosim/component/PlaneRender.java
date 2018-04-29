package com.cjburkey.evosim.component;

import com.cjburkey.evosim.DrawingHelper;
import javafx.scene.paint.Color;

public class PlaneRender extends Component {
	
	public float y = 0.0f;
	public Color color = Color.WHITE;
	
	public void onRender(double delta) {
		float ty = DrawingHelper.getTransformedY();
		DrawingHelper.fillRect(0.0f, ty + y, DrawingHelper.getSize().getX(), DrawingHelper.getSize().getY() - ty, color, false);
	}
	
}