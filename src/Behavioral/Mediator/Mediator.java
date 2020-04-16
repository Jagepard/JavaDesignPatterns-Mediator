/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class Mediator implements MediatorInterface {
    LinkedHashMap<String, AbstractListener> listeners = new LinkedHashMap<>();
    LinkedHashMap<String, String> events = new LinkedHashMap<>();

    @Override
    public void addListener(AbstractListener listener, String methodToCall) {
        String name = listener.getClass().getName();
        if (listeners.containsKey(name) && events.containsKey(name)) {
            throw new IllegalArgumentException(name + " already exists");
        }

        listeners.put(name, listener);
        events.put(name, methodToCall);
    }

    @Override
    public void notify(String name, HandlerInterface handler) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (listeners.containsKey(name) && events.containsKey(name)) {
            AbstractListener listener = listeners.get(name);
            String methodName = events.get(name);
            Method method = listener.getClass().getMethod(methodName, HandlerInterface.class);
            method.invoke(listener, handler);
        }
    }
}
