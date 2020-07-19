package me.xtrm.delta.client.api.event.events.move;

import me.xtrm.delta.loader.api.event.data.Cancellable;
import me.xtrm.delta.loader.api.event.data.Event;
import me.xtrm.delta.loader.api.event.data.EventType;

/**
 * Event fired before and after the player updates 
 * 
 * @author xTrM_
 */
@Cancellable
public class EventMotion extends Event {

	/** The event type */
	private EventType type;
	
	/** The x position */
	private double x; 
	/** The y position */
	private double y; 
	/** The z position */
	private double z;
	/** The yaw rotation */
	private float yaw; 
	/** The pitch rotation */
	private float pitch;
	/** The ground state */
	private boolean onGround;
	
	/** The silent state */
	private boolean silent;
	
	/**
	 * Constructor
	 * @param type
	 * 		the event type
	 * @param x
	 * 		the x position
	 * @param y
	 * 		the y position
	 * @param z
	 * 		the z position
	 * @param yaw
	 * 		the yaw rotation
	 * @param pitch
	 * 		the pitch rotation
	 * @param onGround
	 * 		the ground state
	 */
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
	
	/**
	 * @return the silent state
	 */
	public boolean isSilent() {
		return silent;
	}
	
	/**
	 * @param silent
	 * 		the silent state
	 */
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	
	/**
	 * @return the event type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * @return the x position 
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x
	 * 		the x position 
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y position 
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y
	 * 		the y position 
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the z position 
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @param z
	 * 		the z position 
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * @return the yaw rotation
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * @param yaw
	 * 		the yaw rotation
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	/**
	 * @return the pitch rotation
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * @param pitch
	 * 		the pitch rotation 
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	/**
	 * @return the ground state 
	 */
	public boolean isOnGround() {
		return onGround;
	}

	/**
	 * @param onGround
	 * 		the ground state 
	 */
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

}
