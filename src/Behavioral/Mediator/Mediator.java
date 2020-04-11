/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class Mediator implements MediatorInterface {
    LinkedHashMap<String, Listener> listeners = new LinkedHashMap<>();
    LinkedHashMap<String, String> events = new LinkedHashMap<>();

    @Override
    public void addListener(String name, Listener listener, String methodName) {
        if (listeners.containsKey(name) && events.containsKey(name)) {
            throw new IllegalArgumentException(name + " already exists");
        }

        listeners.put(name, listener);
        events.put(name, methodName);
    }

    @Override
    public void notify(String name, HandlerInterface handler) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (listeners.containsKey(name) && events.containsKey(name)) {
            Listener listener = listeners.get(name);
            String methodName = events.get(name);

            listener.getClass().getMethod(methodName).invoke(listener, null);
        }
    }
}
