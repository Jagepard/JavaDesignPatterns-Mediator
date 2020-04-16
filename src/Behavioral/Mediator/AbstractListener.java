/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractListener {
    /**
     * @param handler
     */
    public void onEvent(HandlerInterface handler){
        handler.setMessage(this.getClass().getName() + ": Fine, thanks!");
        System.out.printf("%s\n", handler.getMessage());
    }

    /**
     * @param listenerName
     * @param mediator
     * @param handler
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void toGreet(String listenerName, MediatorInterface mediator, HandlerInterface handler) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.printf("%s: How are you %s?\n", this.getClass().getName(), listenerName);
        mediator.notify(listenerName, handler);
    }
}
