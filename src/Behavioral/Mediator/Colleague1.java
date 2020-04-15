/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;

public class Colleague1 implements ListenerInterface {
    public void onEvent()
    {
        System.out.printf("%s\n", "Colleague1: notified");
    }

    public void todo(MediatorInterface mediator, HandlerInterface handler) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.printf("%s\n", "Colleague1: act");

        mediator.notify("colleague_2", handler);
        mediator.notify("colleague_3", handler);
    }
}
