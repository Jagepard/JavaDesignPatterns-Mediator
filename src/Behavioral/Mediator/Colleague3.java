/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;

public class Colleague3 implements ListenerInterface {
    public void onEvent(HandlerInterface handler)
    {
        handler.setMessage("Colleague3");
        System.out.printf("%s%s\n", handler.getMessage(), ": notified");
    }

    public void todo(MediatorInterface mediator, HandlerInterface handler) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.printf("%s\n", "Colleague3: act");

        mediator.notify("colleague_1", null);
        mediator.notify("colleague_2", handler);
    }
}
