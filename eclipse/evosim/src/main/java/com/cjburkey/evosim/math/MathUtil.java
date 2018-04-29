package com.cjburkey.evosim.math;

public class MathUtil {
	
	public static float clamp(float val, float min, float max) {
		return clampMin(clampMax(val, max), min);
	}
	
	public static float clampMin(float val, float min) {
		return Math.max(val, min);
	}
	
	public static float clampMax(float val, float max) {
		return Math.min(val, max);
	}
	
}