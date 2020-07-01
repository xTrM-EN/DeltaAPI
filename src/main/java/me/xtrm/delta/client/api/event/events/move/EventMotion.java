package me.xtrm.delta.client.api.event.events.move;

import me.xtrm.delta.loader.api.event.bus.Cancellable;
import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;

@Cancellable
public class EventMotion extends Event {

	private EventType type;
	
	private double x, y, z;
	private float yaw, pitch;
	private boolean onGround;
	
	private boolean silent;
	
	public EventMotion(EventType type, double x, double y, double z, float yaw, float pitch, boolean onGround) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
		this.silent = true;
	}
	
	public boolean isSilent() {
		return silent;
	}
	
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	
	public EventType getType() {
		return type;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public boolean isOnGround() {
		return onGround;
	}

	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

}
