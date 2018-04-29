package com.cjburkey.evosim.math;

public class Vector2 {
	
	private float x;
	private float y;
	
	public Vector2() {
		this(0.0f, 0.0f);
	}
	
	public Vector2(float x, float y) {
		set(x, y);
	}
	
	public Vector2(Vector2 a) {
		set(a);
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void set(float x, float y) {
		setX(x);
		setY(y);
	}
	
	public void set(Vector2 a) {
		if (a == null) {
			set(0.0f, 0.0f);
			return;
		}
		set(a.x, a.y);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getMagnitude() {
		return (float) Math.sqrt(getMagnitudeSq());
	}
	
	public float getMagnitudeSq() {
		return x * x + y * y;
	}
	
	public void add(Vector2 b) {
		x += b.x;
		y += b.y;
	}
	
	public void add(float b) {
		x += b;
		y += b;
	}
	
	public void mul(Vector2 b) {
		x *= b.x;
		y *= b.y;
	}
	
	public void mul(float scalar) {
		x *= scalar;
		y *= scalar;
	}
	
	public float cross(Vector2 b) {
		return x * b.x + y * b.y;
	}
	
	public void normalize() {
		float mag = getMagnitude();
		x /= mag;
		y /= mag;
	}
	
	public boolean isEmpty() {
		return x == 0.0f && y == 0.0f;
	}
	
	public Vector2 getNormalized() {
		Vector2 ret = new Vector2(this);
		ret.normalize();
		return ret;
	}
	
	public String toString() {
		return x + ", " + y;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Vector2 other = (Vector2) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
			return false;
		}
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
			return false;
		}
		return true;
	}
	
	public static Vector2 add(Vector2 a, Vector2 b) {
		return new Vector2(a.x + b.x, a.y + b.y);
	}
	
	public static Vector2 mul(Vector2 a, Vector2 b) {
		return new Vector2(a.x * b.x, a.y * b.y);
	}
	
	public static Vector2 mul(Vector2 a, float scalar) {
		return new Vector2(a.x * scalar, a.y * scalar);
	}
	
}