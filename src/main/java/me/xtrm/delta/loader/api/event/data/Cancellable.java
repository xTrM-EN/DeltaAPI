package me.xtrm.delta.loader.api.event.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for Cancellable {@link IEvent Events}<br>
 * <br>
 * {@link IEvent Event} classes should add this annotation to specify that they are cancellable.<br>
 * Calling {@link IEvent#setCancelled(boolean)} on an {@link IEvent} without this annotation will cause an {@link UnsupportedOperationException}
 * 
 * @author xTrM_
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)
public @interface Cancellable {}
