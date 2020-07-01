package me.xtrm.delta.client.api.event.events.network;

import me.xtrm.delta.loader.api.event.bus.Cancellable;
import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;
import net.minecraft.network.Packet;

@Cancellable
public class EventPacket extends Event {

	private final Packet packet;
	private final EventType type;
	
	public EventPacket(Packet packet, EventType type) {	
		if(type != EventType.RECIEVE && type != EventType.SEND)
			throw new IllegalArgumentException("EventType must either be RECIEVE or SEND");
		
		this.type = type;
		this.packet = packet;
	}
	
	public Packet getPacket() {
		return packet; 
	}
	
	public EventType getType() {
		return type;
	}

}
