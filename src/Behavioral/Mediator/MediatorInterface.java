/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;

public interface MediatorInterface {
    /**
     * @param listener
     */
    void addListener(String name, ListenerInterface listener, String methodName);

    /**
     * @param name
     * @param handler
     */
    void notify(String name, HandlerInterface handler) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
