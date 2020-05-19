/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class AbstractListener {
    /**
     * @param handler
     */
    public String onEvent(HandlerInterface handler){
        handler.setMessage(this.getClass().getName() + ": Fine, thanks!");
        return handler.getMessage();
    }

    /**
     * @param listenerName
     * @param mediator
     * @param handler
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @return
     */
    public ArrayList<String> toGreet(String listenerName, MediatorInterface mediator, HandlerInterface handler) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ArrayList<String> messages = new ArrayList<String>();
        messages.add(String.format("%s: How are you %s?", this.getClass().getName(), listenerName));
        messages.add(mediator.notify(listenerName, handler));

        return messages;
    }
}
