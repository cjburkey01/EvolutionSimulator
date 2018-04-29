package com.cjburkey.evosim;

import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;

public class Loop {
	
	private boolean first;
	private boolean running;
	private long lastFrame;
	
	private Thread thread = new Thread(new Task<Void>() {
		public Void call() {
			EvoSim.setDefaultErrorHandler();
			first = true;
			running = true;
			timer.start();
			return null;
		}
	});
	
	private AnimationTimer timer = new AnimationTimer() {
		public void handle(long now) {
			if (!running) {
				timer.stop();
				exit();
				return;
			}
			double delta = (first) ? 0.0d : ((now - lastFrame) / 1000000000.0d);
			if (first) {
				first = false;
			}
			lastFrame = now;
			tick(delta);
			render(delta);
		}
	};
	
	public void start() {
		thread.setName("PhysicsRender Thread");
		thread.start();
	}
	
	public void stop() {
		first = false;
		running = false;
	}
	
	private void tick(double delta) {
		EvoSim.onTick(delta);
	}
	
	private void render(double delta) {
		EvoSim.onRender(delta);
	}
	
	private void exit() {
		Debug.log("Stopped PhysicsRender loop");
		EvoSim.onExit();
	}
	
}