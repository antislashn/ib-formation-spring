package container;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ContextContainer {
	private Map<String, Object> beans = new HashMap<>();
	
	public void accept(Class<?> clazz) {
		if(clazz.isAnnotationPresent(Composant.class)) {
			Composant composant = clazz.getAnnotation(Composant.class);
			String name = "";
			if(composant.value().equals("")) {
				name = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1);
			} else {
				name = composant.value();
			}
			try {
				Object instance = clazz.getDeclaredConstructor().newInstance();
				if(checkProxy(clazz)){
					beans.put(name, Proxy.newProxyInstance(ContextContainer.class.getClassLoader(), clazz.getInterfaces(), new LoggerProxyHandler(instance)));
				}else {
					beans.put(name, instance);
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new IllegalArgumentException(name);
			}
		}
	}
	
	private boolean checkProxy(Class<?> clazz) {
		for(Method m : clazz.getDeclaredMethods()) {
			if(m.isAnnotationPresent(Log.class))
				return true;
		}
		return false;
	}

	public void inject() {
		for(Object o : beans.values()) {
			for(Field f : o.getClass().getDeclaredFields()) {
				if(f.isAnnotationPresent(Auto.class)) {
					f.setAccessible(true);
					Object obj = beans.get(f.getName());
					try {
						f.set(o, obj);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						throw new RuntimeException(f.getName()+" non accessible");
					}
				}
			}
		}
	}
	
	public Object getBean(String name) {
		return beans.get(name);
	}
}
