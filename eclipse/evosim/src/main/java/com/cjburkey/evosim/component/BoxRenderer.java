package com.cjburkey.evosim.component;

import com.cjburkey.evosim.DrawingHelper;
import com.cjburkey.evosim.math.Vector2;
import javafx.scene.paint.Color;

public class BoxRenderer extends Component {
	
	public Color color = Color.WHITE;
	public Vector2 size = new Vector2(1.0f, 1.0f);
	
	public void onRender(double delta) {
		DrawingHelper.fillRect(Vector2.add(transform.position, Vector2.mul(size, -1.0f / 2.0f)), size, color, true);
	}
	
}