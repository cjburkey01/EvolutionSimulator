package com.cjburkey.evosim;

import com.cjburkey.evosim.component.CameraController;
import com.cjburkey.evosim.window.WindowHandler;
import com.cjburkey.evosim.world.World;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class EvoSim extends Application {
	
	private static EvoSim instance;
	private static WindowHandler windowHandler;
	private static Loop loop;
	private static World world = new World();
	private static CameraController cc;
	private static EvoSimHandler handler;
	
	public EvoSim() {
		instance = this;
	}
	
	public void start(Stage stage) {
		Thread.currentThread().setName("JavaFX Thread");
		setDefaultErrorHandler();
		
		Debug.log("Starting evolution simulator");
		windowHandler = new WindowHandler(stage);
		windowHandler.init();
		windowHandler.show();
		DrawingHelper.setCanvas(windowHandler.canvasPane);
		windowHandler.root.requestFocus();
		Input.init(windowHandler.root);
		Debug.log("Initialized the window");
		
		loop = new Loop();
		loop.start();
		Debug.log("Created physics and render loop");
		
		cc = world.addObject().addComponent(CameraController.class);
		
		handler.init();
	}
	
	public static void main(String[] args) {
		Thread.currentThread().setName("Main Thread");
		setDefaultErrorHandler();
		launch(args);
	}
	
	public static EvoSim getInstance() {
		return instance;
	}
	
	public static WindowHandler getWindowHandler() {
		return windowHandler;
	}
	
	public static Loop getLoop() {
		return loop;
	}
	
	public static World getWorld() {
		return world;
	}
	
	public static void onTick(double delta) {
		handler.preTick(delta);
		world.tick(delta);
		handler.tick(delta);
		handler.postTick(delta);
		Input.lateUpdate();
	}
	
	public static void onRender(double delta) {
		DrawingHelper.clearCanvas(Color.CORNFLOWERBLUE);
		handler.preRender(delta);
		world.render(delta);
		handler.render(delta);
		handler.postRender(delta);
	}
	
	public static void onExit() {
		handler.exit();
		getWindowHandler().destroy();
	}
	
	public static void setDefaultErrorHandler() {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> Debug.logException(e));
		Debug.log("Set error handler for thread");
	}
	
	public static CameraController getCamera() {
		return cc;
	}
	
	public static EvoSimHandler getSimulator() {
		return handler;
	}
	
}