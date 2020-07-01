package me.xtrm.delta.loader.api.event.bus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EventManager implements IEventManager {

	private final Map<Class<? extends IEvent>, List<Data>> registryMap;

    public EventManager() {
    	registryMap = new HashMap<Class<? extends IEvent>, List<Data>>();
	}
	
	@Override
	public void register(Object... listeners) {
		for(Object o : listeners) {
			for (final Method method : o.getClass().getDeclaredMethods()) {
	            if (!isMethodBad(method)) {
	                register(method, o);
	            }
	        }
		}
	}

	@Override
	public void unregister(Object... listeners) {
		for(Object o : listeners) {
			for (final List<Data> flexibalArray : registryMap.values()) {
	            for (final Data methodData : flexibalArray) {
	                if (methodData.source.equals(o)) {
	                    flexibalArray.remove(methodData);
	                }
	            }
	        }
		}

        cleanMap(true);
	}

	@Override
	public void call(IEvent event) {
		final List<Data> dataList = get(event.getClass());
		
		if (dataList != null) {
			for (final Data data : dataList) {
				try {
					data.target.invoke(data.source, event);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("serial")
	private void register(final Method method, final Object o) {
        final Class<?> clazz = method.getParameterTypes()[0];
        final Data methodData = new Data(o, method, method.getAnnotation(EventTarget.class).priority());

        if (!methodData.target.isAccessible()) {
            methodData.target.setAccessible(true);
        }

        if (registryMap.containsKey(clazz)) {
            if (!registryMap.get(clazz).contains(methodData)) {
            	registryMap.get(clazz).add(methodData);
                sortListValue((Class<? extends IEvent>) clazz);
            }
        } else {
        	registryMap.put((Class<? extends IEvent>) clazz, new ArrayList<Data>() {
                {
                    this.add(methodData);
                }
            });
        }
    }

    private void unregister(final Object o, final Class<? extends IEvent> clazz) {
        if (registryMap.containsKey(clazz)) {
            for (final Data methodData : registryMap.get(clazz)) {
                if (methodData.source.equals(o)) {
                	registryMap.get(clazz).remove(methodData);
                }
            }

            cleanMap(true);
        }
    }


    private void cleanMap(final boolean b) {
        final Iterator<Map.Entry<Class<? extends IEvent>, List<Data>>> iterator = registryMap.entrySet().iterator();

        while (iterator.hasNext()) {
            if (!b || iterator.next().getValue().isEmpty()) {
                iterator.remove();
            }
        }
    }

    private void removeEnty(final Class<? extends IEvent> clazz) {
        final Iterator<Map.Entry<Class<? extends IEvent>, List<Data>>> iterator = registryMap.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(clazz)) {
                iterator.remove();
                break;
            }
        }
    }

    private void sortListValue(final Class<? extends IEvent> clazz) {
        final List<Data> flexibleArray = new ArrayList<Data>();

        for (final byte b : Priority.values()) {
            for (final Data methodData : registryMap.get(clazz)) {
                if (methodData.priority == b) {
                    flexibleArray.add(methodData);
                }
            }
        }

        registryMap.put(clazz, flexibleArray);
    }

    private boolean isMethodBad(final Method method) {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class);
    }

    private boolean isMethodBad(final Method method, final Class<? extends IEvent> clazz) {
        return isMethodBad(method) || method.getParameterTypes()[0].equals(clazz);
    }

    private List<Data> get(Class<? extends IEvent> clazz) {
        return registryMap.get(clazz);
    }

}
