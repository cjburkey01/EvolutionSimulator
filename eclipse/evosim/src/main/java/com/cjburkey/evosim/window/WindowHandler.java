package com.cjburkey.evosim.window;

import com.cjburkey.evosim.EvoSim;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class WindowHandler {
	
	public final Stage stage;
	public final VBox root;
	public final Scene scene;
	public final CanvasPane canvasPane;
	
	public WindowHandler(Stage stage) {
		this.stage = stage;
		root = new VBox();
		scene = new Scene(root);
		this.stage.setScene(scene);
		Rectangle2D scr = Screen.getPrimary().getBounds();
		canvasPane = new CanvasPane(scr.getWidth() / 2.0d, scr.getHeight() / 2.0d);
		root.setFillWidth(true);
		VBox.setVgrow(canvasPane, Priority.ALWAYS);
	}
	
	public void init() {
		root.getChildren().add(canvasPane);
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setTitle("Evolution Simulator v0.0.1");
		stage.setOnCloseRequest(e -> {
			e.consume();
			EvoSim.getLoop().stop();
		});
	}
	
	public void show() {
		stage.show();
	}
	
	public void hide() {
		stage.hide();
	}
	
	public void destroy() {
		stage.close();
	}
	
}