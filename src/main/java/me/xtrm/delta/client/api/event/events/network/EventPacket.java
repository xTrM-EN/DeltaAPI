package me.xtrm.delta.client.api.event.events.network;

import me.xtrm.delta.loader.api.event.data.Cancellable;
import me.xtrm.delta.loader.api.event.data.Event;
import me.xtrm.delta.loader.api.event.data.EventType;
import net.minecraft.network.Packet;

/**
 * Event fired when a packet is sent or recieved
 * 
 * @author xTrM_
 */
@Cancellable
public class EventPacket extends Event {

	/** The event packet */
	private final Packet packet;
	/** The event type */
	private final EventType type;
	
	/**
	 * Constructor
	 * @param packet
	 * 		the packet being sent/recieved
	 * @param type
	 * 		the event type
	 */
	public EventPacket(Packet packet, EventType type) {	
		if(type != EventType.RECIEVE && type != EventType.SEND) {
			throw new IllegalArgumentException("EventType must either be RECIEVE or SEND");
		}
		
		this.type = type;
		this.packet = packet;
	}
	
	/**
	 * @return the event packet
	 */
	public Packet getPacket() {
		return packet; 
	}
	
	/**
	 * @return the event type
	 */
	public EventType getType() {
		return type;
	}

}
